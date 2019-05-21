package com.zlq.mall.service.impl;


import com.github.pagehelper.PageHelper;
import com.zlq.mall.dao.OmsOrderDao;
import com.zlq.mall.dao.OmsOrderOperateHistoryDao;
import com.zlq.mall.dto.OmsOrderBatchCloseParam;
import com.zlq.mall.dto.OmsOrderDeliveryParam;
import com.zlq.mall.dto.OmsOrderDetail;
import com.zlq.mall.dto.OmsOrderQueryParam;
import com.zlq.mall.mapper.OmsOrderMapper;
import com.zlq.mall.model.OmsOrder;
import com.zlq.mall.model.OmsOrderExample;
import com.zlq.mall.model.OmsOrderOperateHistory;
import com.zlq.mall.service.OmsOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Date;

/**
 * 订单管理Service实现类
 */
@Service
public class OmsOrderServiceImpl implements OmsOrderService {
    @Autowired
    private OmsOrderMapper orderMapper;

    @Autowired
    private OmsOrderDao orderDao;

    @Autowired
    private OmsOrderOperateHistoryDao orderOperateHistoryDao;

    @Override
    public int delete(List<Long> ids) {
        OmsOrder record = new OmsOrder();
        record.setDeleteStatus(1);
        OmsOrderExample example= new OmsOrderExample();
        example.createCriteria().andDeleteStatusEqualTo(0).andIdIn(ids);
        return orderMapper.updateByExampleSelective(record, example);
    }

    @Override
    public List<OmsOrder> list(OmsOrderQueryParam queryParam, Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        return orderDao.getOrderList(queryParam);
    }


    @Override
    public OmsOrderDetail getOrderDetail(Long id){
        return orderDao.getOrderDetail(id);
    }

    @Override
    public int delivery(List<OmsOrderDeliveryParam> deliveryParamList){
        //批量发货
        int count = orderDao.delivery(deliveryParamList);
        //添加操作记录
        List<OmsOrderOperateHistory> operateHistoryList = deliveryParamList.stream()
                .map(omsOrderDeliveryParam -> {
                    OmsOrderOperateHistory history = new OmsOrderOperateHistory();
                    history.setOrderId(omsOrderDeliveryParam.getOrderId());
                    history.setCreateTime(new Date());
                    history.setOperateMan("后台管理员");
                    history.setOrderStatus(2);
                    history.setNote("完成发货");
                    return history;
                }).collect(Collectors.toList());
        orderOperateHistoryDao.insertList(operateHistoryList);
        return count;
    }


    /**
     * 批量关闭订单
     */
    @Override
    public int batchClose(OmsOrderBatchCloseParam batchCloseParam){
        OmsOrder record = new OmsOrder();
        record.setStatus(4);
        OmsOrderExample example = new OmsOrderExample();
        List<Long> ids = batchCloseParam.getOrderIds();
        example.createCriteria().andDeleteStatusEqualTo(0).andIdIn(ids);
        int count = orderMapper.updateByExampleSelective(record, example);
        //添加操作记录
        List<OmsOrderOperateHistory> historyList = ids.stream().map(
            orderId->{
                OmsOrderOperateHistory history = new OmsOrderOperateHistory();
                history.setNote("订单手动关闭:" + batchCloseParam.getNote());
                history.setOrderId(orderId);
                history.setOperateMan("后台管理员");
                history.setCreateTime(new Date());
                history.setOrderStatus(4);
                return history;
            }
        ).collect(Collectors.toList());

        orderOperateHistoryDao.insertList(historyList);
        return count;
    }

}

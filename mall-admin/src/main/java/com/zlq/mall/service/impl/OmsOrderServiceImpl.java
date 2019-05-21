package com.zlq.mall.service.impl;


import com.github.pagehelper.PageHelper;
import com.zlq.mall.dao.OmsOrderDao;
import com.zlq.mall.dao.OmsOrderOperateHistoryDao;
import com.zlq.mall.dto.*;
import com.zlq.mall.mapper.OmsOrderMapper;
import com.zlq.mall.mapper.OmsOrderOperateHistoryMapper;
import com.zlq.mall.model.OmsOrder;
import com.zlq.mall.model.OmsOrderExample;
import com.zlq.mall.model.OmsOrderOperateHistory;
import com.zlq.mall.service.OmsOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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


    @Autowired
    private OmsOrderOperateHistoryMapper orderOperateHistoryMapper;


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


    /**
     * 修改订单费用信息
     */
    @Override
    public int updateMoneyInfo(OmsMoneyInfoParam moneyInfoParam){
        OmsOrder record = new OmsOrder();
        record.setId(moneyInfoParam.getOrderId());
        record.setModifyTime(new Date());
        record.setFreightAmount(moneyInfoParam.getFreightAmount());
        record.setDiscountAmount(moneyInfoParam.getDiscountAmount());
        int count = orderMapper.updateByPrimaryKeySelective(record);
        //添加操作记录
        OmsOrderOperateHistory history = new OmsOrderOperateHistory();
        history.setOrderId(moneyInfoParam.getOrderId());
        history.setCreateTime(new Date());
        history.setOperateMan("后台管理员");
        history.setOrderStatus(moneyInfoParam.getStatus());
        history.setNote("修改收货人信息");
        List<OmsOrderOperateHistory> historyList = new ArrayList<>();
        historyList.add(history);
        orderOperateHistoryDao.insertList(historyList);

        // 因为在 OmsOrderOperateHistoryDao.xml里面备注一样，
        // 我将订单id， 加了唯一索引， 如果用 orderOperateHistoryMapper.insert(history)， 会导致冲突
        return count;
    }


    /**
     * 修改订单备注
     */
    @Override
    public int updateNote(Long id, String note, Integer status){
        OmsOrder order = new OmsOrder();
        order.setId(id);
        order.setNote(note);
        order.setModifyTime(new Date());
        int count = orderMapper.updateByPrimaryKeySelective(order);
        //添加操作记录
        OmsOrderOperateHistory history = new OmsOrderOperateHistory();
        history.setOrderId(id);
        history.setCreateTime(new Date());
        history.setOperateMan("后台管理员");
        history.setOrderStatus(status);
        history.setNote("修改备注信息:" + note);
        List<OmsOrderOperateHistory> historyList = new ArrayList<>();
        historyList.add(history);
        orderOperateHistoryDao.insertList(historyList);
        return count;
    }


    /**
     * 修改订单收货人信息
     */
    @Override
    public int updateReceiverInfo(OmsReceiverInfoParam receiverInfoParam) {
        OmsOrder order = new OmsOrder();
        Long orderId = receiverInfoParam.getOrderId();
        order.setId(orderId);
        order.setReceiverName(receiverInfoParam.getReceiverName());
        order.setReceiverPhone(receiverInfoParam.getReceiverPhone());
        order.setReceiverPostCode(receiverInfoParam.getReceiverPostCode());
        order.setReceiverDetailAddress(receiverInfoParam.getReceiverDetailAddress());
        order.setReceiverProvince(receiverInfoParam.getReceiverProvince());
        order.setReceiverCity(receiverInfoParam.getReceiverCity());
        order.setReceiverRegion(receiverInfoParam.getReceiverRegion());
        order.setModifyTime(new Date());

        int count = orderMapper.updateByPrimaryKeySelective(order);
        OmsOrderOperateHistory history = new OmsOrderOperateHistory();
        history.setOrderId(receiverInfoParam.getOrderId());
        history.setCreateTime(new Date());
        history.setOperateMan("后台管理员");
        history.setOrderStatus(receiverInfoParam.getStatus());
        history.setNote("修改收货人信息");
        List<OmsOrderOperateHistory> historyList = new ArrayList<>();
        historyList.add(history);
        orderOperateHistoryDao.insertList(historyList);

        return count;
    }
}

package com.zlq.mall.service.impl;


import com.github.pagehelper.PageHelper;
import com.zlq.mall.dao.OmsOrderDao;
import com.zlq.mall.dto.OmsOrderDeliveryParam;
import com.zlq.mall.dto.OmsOrderDetail;
import com.zlq.mall.dto.OmsOrderQueryParam;
import com.zlq.mall.mapper.OmsOrderMapper;
import com.zlq.mall.model.OmsOrder;
import com.zlq.mall.model.OmsOrderExample;
import com.zlq.mall.service.OmsOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 订单管理Service实现类
 */
@Service
public class OmsOrderServiceImpl implements OmsOrderService {
    @Autowired
    private OmsOrderMapper orderMapper;

    @Autowired
    private OmsOrderDao orderDao;

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
        return 0;
    }

}

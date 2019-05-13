package com.zlq.mall.service;

import com.zlq.mall.dto.OmsOrderDeliveryParam;
import com.zlq.mall.dto.OmsOrderDetail;
import com.zlq.mall.dto.OmsOrderQueryParam;
import com.zlq.mall.model.OmsOrder;

import java.util.List;

public interface OmsOrderService {

    /**
     * 批量删除订单
     */
    int delete(List<Long> ids);

    /**
     * 查询订单
     */
    List<OmsOrder> list(OmsOrderQueryParam queryParam, Integer pageNum, Integer pageSize);

    /**
     * 查询订单
     */
    OmsOrderDetail getOrderDetail(Long id);

    /**
     * 批量发货
     */
    int delivery(List<OmsOrderDeliveryParam> deliveryParamList);


}

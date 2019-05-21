package com.zlq.mall.service;

import com.zlq.mall.dto.*;
import com.zlq.mall.model.OmsOrder;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    int delivery(List<OmsOrderDeliveryParam> deliveryParamList);

    /**
     * 批量关闭订单
     */
    @Transactional
    int batchClose(OmsOrderBatchCloseParam batchCloseParam);

    /**
    * 修改订单费用信息
    */
    @Transactional
    int updateMoneyInfo(OmsMoneyInfoParam moneyInfoParam);

    /**
     * 修改订单备注
     */
    @Transactional
    int updateNote(Long id, String note, Integer status);


    /**
     * 修改订单收货人信息
     */
    @Transactional
    int updateReceiverInfo(OmsReceiverInfoParam receiverInfoParam);


}

package com.zlq.mall.service;

import java.util.List;

public interface OmsOrderService {

    /**
     * 批量删除订单
     */
    int delete(List<Long> ids);
}

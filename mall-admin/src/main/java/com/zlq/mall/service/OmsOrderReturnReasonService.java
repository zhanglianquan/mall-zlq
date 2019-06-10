package com.zlq.mall.service;

import com.zlq.mall.model.OmsOrderReturnReason;

import java.util.List;

/**
 * 订单原因管理Service
 * @author zlq
 */
public interface OmsOrderReturnReasonService {
    /**
     * 添加订单原因
     */
    int create(OmsOrderReturnReason returnReason);

    /**
     * 批量删除退货原因
     */
    int batchDelete(List<Long> ids);

    /**
     * 分页获取退货原因
     */
    List<OmsOrderReturnReason> list(Integer pageNum, Integer pageSize);
}

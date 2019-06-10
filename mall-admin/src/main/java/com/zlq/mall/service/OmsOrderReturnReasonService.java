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

    /**
     * 修改退货原因
     */
    int update(Long id, OmsOrderReturnReason returnReason);

    /**
     * 批量修改退货原因状态
     */
    int updateStatus(List<Long> ids, Integer status);

    /**
     * 获取单个退货原因详情信息
     */
    OmsOrderReturnReason getItem(Long id);

}

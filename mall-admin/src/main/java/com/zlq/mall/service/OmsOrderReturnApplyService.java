package com.zlq.mall.service;

import java.util.List;

/**
 * 退货申请管理Service
 *
 * @author zlq
 */

public interface OmsOrderReturnApplyService {

    /**
     * 批量删除申请
     */
    int batchDelete(List<Long> ids);
}

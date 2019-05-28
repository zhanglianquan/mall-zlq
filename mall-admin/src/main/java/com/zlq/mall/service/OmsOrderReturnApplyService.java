package com.zlq.mall.service;

import com.zlq.mall.dto.OmsOrderReturnApplyResult;
import com.zlq.mall.dto.OmsReturnApplyQueryParam;
import com.zlq.mall.dto.OmsUpdateStatusParam;
import com.zlq.mall.model.OmsOrderReturnApply;

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

    /**
     * 分页查询退货申请
     */
    List<OmsOrderReturnApply> list(OmsReturnApplyQueryParam returnApplyQueryParam, Integer pageNum, Integer pageSize);

    /**
     * 修改申请状态
     */
    int updateStatus(Long id, OmsUpdateStatusParam statusParam);

    /**
     * 获取退货申请详情
     */
    OmsOrderReturnApplyResult getDetail(Long id);

}

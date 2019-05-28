package com.zlq.mall.dao;


import com.zlq.mall.dto.OmsOrderReturnApplyResult;
import com.zlq.mall.dto.OmsReturnApplyQueryParam;
import com.zlq.mall.model.OmsOrderReturnApply;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单退货申请自定义Dao
 * @author zlq
 */
public interface OmsOrderReturnApplyDao {
    /**
     * 查询申请列表
     */
    List<OmsOrderReturnApply> getList(@Param("queryParam") OmsReturnApplyQueryParam queryParam);


    /**
     * 获取申请详情
     */
    OmsOrderReturnApplyResult getDetail(@Param("id")Long id);

}

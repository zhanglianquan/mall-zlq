package com.zlq.mall.dao;

import com.zlq.mall.dto.SmsCouponParam;
import org.apache.ibatis.annotations.Param;

/**
 * 优惠券管理自定义查询Dao
 */
public interface SmsCouponDao {
    SmsCouponParam getItem(@Param("id") Long id);
}

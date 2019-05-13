package com.zlq.mall.dao;

import com.zlq.mall.dto.OmsOrderDetail;
import com.zlq.mall.dto.OmsOrderQueryParam;
import com.zlq.mall.model.OmsOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单自定义查询Dao
 * @author zlq
 */

public interface OmsOrderDao {
    /**
     * 条件查询订单
     * @param queryParam 订单 查询参数.
     * @return 符合条件的订单.
     */
    List<OmsOrder> getOrderList(@Param("queryParam") OmsOrderQueryParam queryParam);

    /**
     * 订单详情
     * @param id 订单id .
     * @return 符合条件的订单.
     */
    OmsOrderDetail getOrderDetail(@Param("id") Long id);

}

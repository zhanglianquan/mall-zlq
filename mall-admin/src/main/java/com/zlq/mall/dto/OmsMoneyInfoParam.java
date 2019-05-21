package com.zlq.mall.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * 修改订单费用信息参数
 * @author zlq
 */
@Getter
@Setter
public class OmsMoneyInfoParam {
    /**
     * 订单id
     */
    private Long orderId;

    /**
     * 运费金额
     */
    private BigDecimal freightAmount;

    /**
     * 管理员后台调整订单使用的折扣金额
     */
    private BigDecimal discountAmount;

    /**
     * 状态
     */
    private Integer status;
}
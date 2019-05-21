package com.zlq.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 订单发货参数
 *
 * @author zlq
 */
@Getter
@Setter
public class OmsOrderDeliveryParam {
    @ApiModelProperty("物流公司")
    private String deliveryCompany;
    @ApiModelProperty("物流单号")
    private String deliverySn;

    @ApiModelProperty("订单id")
    private Long orderId;
}

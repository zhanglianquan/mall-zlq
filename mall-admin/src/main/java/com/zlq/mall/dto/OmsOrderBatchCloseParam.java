package com.zlq.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


/**
 * 订单批量关闭参数
 *
 * @author zlq
 */

@Getter
@Setter
public class OmsOrderBatchCloseParam {
    @ApiModelProperty("订单ids 集合")
    private List<Long> orderIds;

    @ApiModelProperty("订单备注")
    private String note;
}

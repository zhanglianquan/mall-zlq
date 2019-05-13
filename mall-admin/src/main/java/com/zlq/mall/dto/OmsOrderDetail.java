package com.zlq.mall.dto;

import com.zlq.mall.model.OmsOrder;
import com.zlq.mall.model.OmsOrderItem;
import com.zlq.mall.model.OmsOrderOperateHistory;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 订单详情信息
 * @author zlq
 */


public class OmsOrderDetail extends OmsOrder {
    @Getter
    @Setter
    private List<OmsOrderItem> orderItemList;

    @Getter
    @Setter
    private List<OmsOrderOperateHistory> historyList;
}

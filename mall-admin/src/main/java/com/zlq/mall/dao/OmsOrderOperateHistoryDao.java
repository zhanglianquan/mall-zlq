package com.zlq.mall.dao;

import com.zlq.mall.model.OmsOrderOperateHistory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单操作记录自定义Dao
 *
 * @author zlq
 */

public interface OmsOrderOperateHistoryDao {
    int insertList(@Param("historyList")List<OmsOrderOperateHistory> orderOperateHistoryList);
}

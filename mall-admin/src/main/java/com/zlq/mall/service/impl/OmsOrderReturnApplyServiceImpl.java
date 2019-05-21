package com.zlq.mall.service.impl;

import com.zlq.mall.mapper.OmsOrderReturnApplyMapper;
import com.zlq.mall.model.OmsOrderReturnApplyExample;
import com.zlq.mall.service.OmsOrderReturnApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 订单退货管理Service
 *
 * @author zlq
 */

@Service
public class OmsOrderReturnApplyServiceImpl implements OmsOrderReturnApplyService {
    @Autowired
    OmsOrderReturnApplyMapper returnApplyMapper;
    /**
     * 批量删除申请
     */
    @Override
    public int batchDelete(List<Long> ids) {
        OmsOrderReturnApplyExample example = new OmsOrderReturnApplyExample();
        example.createCriteria().andStatusEqualTo(3).andIdIn(ids);
        return returnApplyMapper.deleteByExample(example);
    }
}

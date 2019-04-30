package com.zlq.mall.service.impl;


import com.github.pagehelper.PageHelper;
import com.zlq.mall.dto.OmsOrderQueryParam;
import com.zlq.mall.mapper.OmsOrderMapper;
import com.zlq.mall.model.OmsOrder;
import com.zlq.mall.model.OmsOrderExample;
import com.zlq.mall.service.OmsOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 订单管理Service实现类
 */
@Service
public class OmsOrderServiceImpl implements OmsOrderService {
    @Autowired
    private OmsOrderMapper orderMapper;

    @Override
    public int delete(List<Long> ids) {
        OmsOrder record = new OmsOrder();
        record.setDeleteStatus(1);
        OmsOrderExample example= new OmsOrderExample();
        example.createCriteria().andDeleteStatusEqualTo(0).andIdIn(ids);
        return orderMapper.updateByExampleSelective(record, example);
    }

    @Override
    public List<OmsOrder> list(OmsOrderQueryParam queryParam, Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        return orderMapper.selectByExample(new OmsOrderExample());
    }

}

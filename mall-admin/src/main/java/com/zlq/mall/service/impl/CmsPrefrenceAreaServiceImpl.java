package com.zlq.mall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zlq.mall.service.CmsPrefrenceAreaService;
import com.zlq.mall.mapper.CmsPrefrenceAreaMapper;
import com.zlq.mall.model.CmsPrefrenceArea;
import com.zlq.mall.model.CmsPrefrenceAreaExample;

import java.util.List;

/**
 * 商品优选Service实现类
 */
@Service
public class CmsPrefrenceAreaServiceImpl implements CmsPrefrenceAreaService {
    @Autowired
    private CmsPrefrenceAreaMapper prefrenceAreaMapper;

    @Override
    public List<CmsPrefrenceArea> listAll() {
        return prefrenceAreaMapper.selectByExample(new CmsPrefrenceAreaExample());
    }
}


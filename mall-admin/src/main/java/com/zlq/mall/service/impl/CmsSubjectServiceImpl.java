package com.zlq.mall.service.impl;

import com.zlq.mall.mapper.CmsSubjectMapper;
import com.zlq.mall.model.CmsSubject;
import com.zlq.mall.model.CmsSubjectExample;
import com.zlq.mall.service.CmsSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品专题Service实现类
 */

@Service
public class CmsSubjectServiceImpl implements CmsSubjectService {

    @Autowired
    private CmsSubjectMapper subjectMapper;

    @Override
    public List<CmsSubject> listAll() {
        return subjectMapper.selectByExample(new CmsSubjectExample());
    }
}

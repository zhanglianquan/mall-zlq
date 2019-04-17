package com.zlq.mall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zlq.mall.service.OmsCompanyAddressService;
import com.zlq.mall.model.OmsCompanyAddress;
import com.zlq.mall.model.OmsCompanyAddressExample;
import com.zlq.mall.mapper.OmsCompanyAddressMapper
;
import java.util.List;

/**
 * 收货地址管理Service实现类
 */
@Service
public class OmsCompanyAddressServiceImpl implements OmsCompanyAddressService {
    @Autowired
    private OmsCompanyAddressMapper companyAddressMapper;

    @Override
    public List<OmsCompanyAddress> list() {
        return companyAddressMapper.selectByExample(new OmsCompanyAddressExample());
    }
}
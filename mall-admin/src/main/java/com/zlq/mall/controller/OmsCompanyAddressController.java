package com.zlq.mall.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.zlq.mall.model.OmsCompanyAddress;
import com.zlq.mall.service.OmsCompanyAddressService;
import com.zlq.mall.dto.CommonResult;
import java.util.List;

/**
 * 收货地址管理Controller
 */
@Controller
@Api(tags = "OmsCompanyAddressController", description = "收货地址管理")
@RequestMapping("/companyAddress")
public class OmsCompanyAddressController {
    @Autowired
    private OmsCompanyAddressService companyAddressService;

    @ApiOperation("获取所有收货地址")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public Object list() {
        List<OmsCompanyAddress> companyAddressList = companyAddressService.list();
        return new CommonResult().success(companyAddressList);
    }
}

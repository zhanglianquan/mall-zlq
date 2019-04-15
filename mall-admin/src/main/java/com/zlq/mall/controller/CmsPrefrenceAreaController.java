package com.zlq.mall.controller;

import com.zlq.mall.test_bean.Demo;
import com.zlq.mall.service.CmsPrefrenceAreaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.zlq.mall.dto.CommonResult;
import com.zlq.mall.model.CmsPrefrenceArea;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 商品优选管理Controller
 */



@Controller
@Api(tags = "CmsPrefrenceAreaController", description = "商品优选管理")
@RequestMapping("/prefrenceArea")
public class CmsPrefrenceAreaController {

    @Autowired
    private CmsPrefrenceAreaService prefrenceAreaService;


    @ApiOperation("获取所有商品优选")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public  Object listAll(){
        List<CmsPrefrenceArea> prefrenceAreaList = prefrenceAreaService.listAll();
        return new CommonResult().success(prefrenceAreaList);
    }
}

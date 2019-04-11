package com.zlq.mall.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 商品优选管理Controller
 */
@Controller
@Api(tags = "CmsPrefrerenceAreaController", description = "商品优选管理")
@RequestMapping("prefrenceArea")
public class CmsPrefrerenceAreaController {


    @ApiOperation("获取所有商品优选")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    public  Object listAll(){

        return "";
    }
}

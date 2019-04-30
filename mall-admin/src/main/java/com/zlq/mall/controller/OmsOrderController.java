package com.zlq.mall.controller;

import com.zlq.mall.dto.OmsOrderQueryParam;
import com.zlq.mall.model.OmsOrder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.zlq.mall.dto.CommonResult;
import com.zlq.mall.service.OmsOrderService;

import java.util.List;

/**
 * 订单管理Controller
 */
@Controller
@Api(tags = "OmsOrderController", description = "订单管理")
@RequestMapping("/order")
public class OmsOrderController {

    @Autowired
    private  OmsOrderService  orderService;

    @ApiOperation("批量删除订单")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public Object delete(@RequestParam("ids") List<Long> ids) {
        int count = orderService.delete(ids);
        if (count > 0) {
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }
    @ApiOperation(value = "查询订单", notes = "根据指定条件查询订单信息")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public  Object getList(OmsOrderQueryParam queryParam,
                           /*第几页*/
                           @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                          /*每页记录数*/
                           @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize){
        List<OmsOrder> orderList = orderService.list(queryParam, pageSize, pageNum);
        return new CommonResult().success(orderList);
    }
}

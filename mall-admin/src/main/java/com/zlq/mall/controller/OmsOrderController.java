package com.zlq.mall.controller;

import com.zlq.mall.dto.*;
import com.zlq.mall.model.OmsOrder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
        List<OmsOrder> orderList = orderService.list(queryParam, pageNum, pageSize);
        return new CommonResult().pageSuccess(orderList);
    }

    @ApiOperation(value = "获取订单详情:订单信息、商品信息、操作记录")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Object getOrderDetail(@PathVariable(value = "id", required = true) Long id){
        OmsOrderDetail orderDetailResult = orderService.getOrderDetail(id);
        return new CommonResult().success(orderDetailResult);
    }

    @ApiOperation(value = "批量发货")
    @RequestMapping(value = "/update/delivery", method = RequestMethod.POST)
    @ResponseBody
    public Object delivery(@RequestBody List<OmsOrderDeliveryParam> deliveryParamList){
        int count = orderService.delivery(deliveryParamList);
        if (count > 0) {
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }


    @ApiOperation(value = "批量关闭订单")
    @RequestMapping(value = "/update/close", method = RequestMethod.POST)
    @ResponseBody
    public Object batchClose(OmsOrderBatchCloseParam batchCloseParam) {
        int count = orderService.batchClose(batchCloseParam);
        if (count > 0) {
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }
}

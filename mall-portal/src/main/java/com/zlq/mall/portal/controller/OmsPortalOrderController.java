package com.zlq.mall.portal.controller;

import com.zlq.mall.portal.domain.CommonResult;
import com.zlq.mall.portal.domain.ConfirmOrderResult;
import com.zlq.mall.portal.domain.OrderParam;
import com.zlq.mall.portal.service.OmsPortalOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 订单管理Controller
 * 链接：https://juejin.im/post/5cff98986fb9a07ed36ea139
 * 用户名: admin , 密码：123456， {
 *   "couponId":3,
 *   "memberReceiveAddressId": 1,
 *   "payType": 0,
 *   "useIntegration": 100
 * }
 *每次测试：需要修改的地方1：如果couponId和useIntegration为空， 那么不需要修改1， 直接修改2
 *
 * UmsMemberCouponServiceImpl的 listCart 函数屏蔽，开启：
 * //                if(now.before(endTime)&&totalAmount.intValue()>0&&totalAmount.subtract(minPoint).intValue()>=0){
 * //                    enableList.add(couponHistoryDetail);
 * //                }else{
 * //                    disableList.add(couponHistoryDetail);
 * //                }
 *
 *                 enableList.add(couponHistoryDetail);
 * 需要修改的地方2：每次测试完成优惠券后将表： oms_cart_item的 对应的member_id 的delete_status 重置为0，
 * sms_coupon_history表对应的member_id 的use_status重置为0，
 * 这样测试下单成功
 */
@Controller
@Api(tags = "OmsPortalOrderController",description = "订单管理")
@RequestMapping("/order")
public class OmsPortalOrderController {
    @Autowired
    private OmsPortalOrderService portalOrderService;
    @ApiOperation("根据购物车信息生成确认单信息")
    @RequestMapping(value = "/generateConfirmOrder",method = RequestMethod.POST)
    @ResponseBody
    public Object generateConfirmOrder(){
        ConfirmOrderResult confirmOrderResult = portalOrderService.generateConfirmOrder();
        return new CommonResult().success(confirmOrderResult);
    }

    @ApiOperation("根据购物车信息生成订单")
    @RequestMapping(value = "/generateOrder",method = RequestMethod.POST)
    @ResponseBody
    public Object generateOrder(@RequestBody OrderParam orderParam){
        return portalOrderService.generateOrder(orderParam);
    }
    @ApiOperation("支付成功的回调")
    @RequestMapping(value = "/paySuccess",method = RequestMethod.POST)
    @ResponseBody
    public Object paySuccess(@RequestParam Long orderId){
        return portalOrderService.paySuccess(orderId);
    }

    @ApiOperation("自动取消超时订单")
    @RequestMapping(value = "/cancelTimeOutOrder",method = RequestMethod.POST)
    @ResponseBody
    public Object cancelTimeOutOrder(){
        return portalOrderService.cancelTimeOutOrder();
    }

    @ApiOperation("取消单个超时订单")
    @RequestMapping(value = "/cancelOrder",method = RequestMethod.POST)
    @ResponseBody
    public Object cancelOrder(Long orderId){
        portalOrderService.sendDelayMessageCancelOrder(orderId);
        return new CommonResult().success(null);
    }
}

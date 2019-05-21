package com.zlq.mall.controller;

import com.zlq.mall.dto.CommonResult;
import com.zlq.mall.service.OmsOrderReturnApplyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 订单退货申请管理
 * @author zlq
 */
@Controller
@Api(tags = "OmsOrderReturnApplyController", description = "订单退货申请管理")
@RequestMapping("/returnApply")
public class OmsOrderReturnApplyController {

    @Autowired
    OmsOrderReturnApplyService returnApplyService;

    @ApiOperation("批量删除申请")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public Object batchDelete(@RequestParam("ids") List<Long> ids){
        int count = returnApplyService.batchDelete(ids);
        if (count > 0) {
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }
}

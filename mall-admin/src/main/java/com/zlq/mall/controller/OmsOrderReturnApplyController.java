package com.zlq.mall.controller;

import com.zlq.mall.dto.CommonResult;
import com.zlq.mall.dto.OmsOrderReturnApplyResult;
import com.zlq.mall.dto.OmsReturnApplyQueryParam;
import com.zlq.mall.dto.OmsUpdateStatusParam;
import com.zlq.mall.model.OmsOrderReturnApply;
import com.zlq.mall.service.OmsOrderReturnApplyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @ApiOperation("分页查询退货申请")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Object list(OmsReturnApplyQueryParam returnApplyQueryParam,
                       @RequestParam(value="pageNum", defaultValue = "1") Integer pageNum,
                       @RequestParam(value="pageSize", defaultValue = "5") Integer pageSize){
        List<OmsOrderReturnApply> returnApplyList = returnApplyService.list(returnApplyQueryParam, pageNum, pageSize);
        return new CommonResult().pageSuccess(returnApplyList);
    }


    @ApiOperation("修改申请状态")
    @RequestMapping(value = "/update/status/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Object updateStatus(@PathVariable Long id, @RequestBody OmsUpdateStatusParam statusParam){
        int count = returnApplyService.updateStatus(id, statusParam);
        if (count > 0) {
            return new CommonResult().success(count);
        }
        return new CommonResult().failed();
    }


    @ApiOperation("获取退货申请详情")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Object getDetail(@PathVariable Long id){
        OmsOrderReturnApplyResult result = returnApplyService.getDetail(id);
        return new CommonResult().success(result);
    }
}

package com.zlq.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.zlq.mall.dao.OmsOrderReturnApplyDao;
import com.zlq.mall.dto.OmsOrderReturnApplyResult;
import com.zlq.mall.dto.OmsReturnApplyQueryParam;
import com.zlq.mall.dto.OmsUpdateStatusParam;
import com.zlq.mall.mapper.OmsOrderReturnApplyMapper;
import com.zlq.mall.model.OmsOrderReturnApply;
import com.zlq.mall.model.OmsOrderReturnApplyExample;
import com.zlq.mall.service.OmsOrderReturnApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 订单退货管理Service
 *
 * @author zlq
 */

@Service
public class OmsOrderReturnApplyServiceImpl implements OmsOrderReturnApplyService {
    @Autowired
    OmsOrderReturnApplyMapper returnApplyMapper;
    @Autowired
    OmsOrderReturnApplyDao returnApplyDao;
    /**
     * 批量删除申请
     */
    @Override
    public int batchDelete(List<Long> ids) {
        OmsOrderReturnApplyExample example = new OmsOrderReturnApplyExample();
        example.createCriteria().andStatusEqualTo(3).andIdIn(ids);
        return returnApplyMapper.deleteByExample(example);
    }

    /**
     * 分页查询退货申请
     */
    @Override
    public List<OmsOrderReturnApply> list(OmsReturnApplyQueryParam returnApplyQueryParam, Integer pageNum,
                                          Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        return returnApplyDao.getList(returnApplyQueryParam);
    }


    /**
     * 修改申请状态
     */
    @Override
    public int updateStatus(Long id, OmsUpdateStatusParam statusParam){
        Integer status = statusParam.getStatus();
        OmsOrderReturnApply returnApply = new OmsOrderReturnApply();
        if(status.equals(1)){
            //确认退货
            returnApply.setId(id);
            returnApply.setStatus(1);
            returnApply.setReturnAmount(statusParam.getReturnAmount());
            returnApply.setCompanyAddressId(statusParam.getCompanyAddressId());
            returnApply.setHandleTime(new Date());
            returnApply.setHandleMan(statusParam.getHandleMan());
            returnApply.setHandleNote(statusParam.getHandleNote());
        }else if(status.equals(2)){
            //完成退货
            returnApply.setId(id);
            returnApply.setStatus(2);
            returnApply.setReceiveTime(new Date());
            returnApply.setReceiveMan(statusParam.getReceiveMan());
            returnApply.setReceiveNote(statusParam.getReceiveNote());
        }else if(status.equals(3)){
            //拒绝退货
            returnApply.setId(id);
            returnApply.setStatus(3);
            returnApply.setHandleTime(new Date());
            returnApply.setHandleMan(statusParam.getHandleMan());
            returnApply.setHandleNote(statusParam.getHandleNote());
        }else{
            return 0;
        }
        return returnApplyMapper.updateByPrimaryKeySelective(returnApply);
    }


    /**
     * 获取退货申请详情
     */
    @Override
    public OmsOrderReturnApplyResult getDetail(Long id){
        return returnApplyDao.getDetail(id);
    }
}

package com.zlq.mall.dto;

import com.zlq.mall.model.SmsCoupon;
import com.zlq.mall.model.SmsCouponProductCategoryRelation;
import com.zlq.mall.model.SmsCouponProductRelation;

import java.util.List;

/**
 * 优惠券信息封装，包括绑定商品和绑定分类
 */
public class SmsCouponParam extends SmsCoupon {
    //优惠券绑定的商品
    private List<SmsCouponProductRelation> productRelationList;
    //优惠券绑定的商品分类
    private List<SmsCouponProductCategoryRelation> productCategoryRelationList;

    public List<SmsCouponProductRelation> getProductRelationList() {
        return productRelationList;
    }

    public void setProductRelationList(List<SmsCouponProductRelation> productRelationList) {
        this.productRelationList = productRelationList;
    }

    public List<SmsCouponProductCategoryRelation> getProductCategoryRelationList() {
        return productCategoryRelationList;
    }

    public void setProductCategoryRelationList(List<SmsCouponProductCategoryRelation> productCategoryRelationList) {
        this.productCategoryRelationList = productCategoryRelationList;
    }
}

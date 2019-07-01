package com.zlq.mall.dto;

import com.zlq.mall.model.PmsProductAttribute;
import com.zlq.mall.model.PmsProductAttributeCategory;

import java.util.List;

/**
 * 包含有分类下属性的dto
 *
 * @author zlq
 */

public class PmsProductAttributeCategoryItem extends PmsProductAttributeCategory {
    private List<PmsProductAttribute> productAttributeList;

    public List<PmsProductAttribute> getProductAttributeList() {
        return productAttributeList;
    }

    public void setProductAttributeList(List<PmsProductAttribute> productAttributeList) {
        this.productAttributeList = productAttributeList;
    }
}

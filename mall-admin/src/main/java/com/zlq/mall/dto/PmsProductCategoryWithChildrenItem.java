package com.zlq.mall.dto;

import com.zlq.mall.model.PmsProductCategory;

import java.util.List;

/**
 * 这个类演示了文档注释
 *
 * @author zlq
 */

public class PmsProductCategoryWithChildrenItem extends PmsProductCategory {
    private List<PmsProductCategory> children;

    public List<PmsProductCategory> getChildren() {
        return children;
    }

    public void setChildren(List<PmsProductCategory> children) {
        this.children = children;
    }
}

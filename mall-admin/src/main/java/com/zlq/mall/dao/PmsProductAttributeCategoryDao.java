package com.zlq.mall.dao;

import com.zlq.mall.dto.PmsProductAttributeCategoryItem;

import java.util.List;

/**
 * 自定义商品属性分类Dao
 *
 * @author zlq
 */

public interface PmsProductAttributeCategoryDao {
    List<PmsProductAttributeCategoryItem> getListWithAttr();
}

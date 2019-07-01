package com.zlq.mall.service;

import com.zlq.mall.dto.PmsProductAttributeCategoryItem;
import com.zlq.mall.model.PmsProductAttributeCategory;

import java.util.List;

/**
 * 商品属性分类Service
 *
 * @author zlq
 */

public interface PmsProductAttributeCategoryService {
    int create(String name);

    int update(Long id, String name);

    int delete(Long id);

    PmsProductAttributeCategory getItem(Long id);

    List<PmsProductAttributeCategory> getList(Integer pageSize, Integer pageNum);

    List<PmsProductAttributeCategoryItem> getListWithAttr();
}
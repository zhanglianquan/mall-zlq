package com.zlq.mall.dao;

import com.zlq.mall.model.PmsProductAttributeValue;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品参数，商品自定义规格属性Dao
 */
public interface PmsProductAttributeValueDao {
    int insertList(@Param("list") List<PmsProductAttributeValue> productAttributeValueList);
}

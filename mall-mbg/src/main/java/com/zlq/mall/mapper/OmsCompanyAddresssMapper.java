package com.zlq.mall.mapper;

import com.zlq.mall.model.OmsCompanyAddresss;
import com.zlq.mall.model.OmsCompanyAddresssExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OmsCompanyAddresssMapper {
    int countByExample(OmsCompanyAddresssExample example);

    int deleteByExample(OmsCompanyAddresssExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OmsCompanyAddresss record);

    int insertSelective(OmsCompanyAddresss record);

    List<OmsCompanyAddresss> selectByExample(OmsCompanyAddresssExample example);

    OmsCompanyAddresss selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OmsCompanyAddresss record, @Param("example") OmsCompanyAddresssExample example);

    int updateByExample(@Param("record") OmsCompanyAddresss record, @Param("example") OmsCompanyAddresssExample example);

    int updateByPrimaryKeySelective(OmsCompanyAddresss record);

    int updateByPrimaryKey(OmsCompanyAddresss record);
}
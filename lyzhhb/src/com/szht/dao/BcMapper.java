package com.szht.dao;

import com.szht.model.Bc;
import com.szht.model.BcExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BcMapper {
    int countByExample(BcExample example);

    int deleteByExample(BcExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Bc record);

    int insertSelective(Bc record);

    List<Bc> selectByExample(BcExample example);

    Bc selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Bc record, @Param("example") BcExample example);

    int updateByExample(@Param("record") Bc record, @Param("example") BcExample example);

    int updateByPrimaryKeySelective(Bc record);

    int updateByPrimaryKey(Bc record);
}
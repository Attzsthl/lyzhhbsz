package com.szht.dao;

import com.szht.model.Bcinfo;
import com.szht.model.BcinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BcinfoMapper {
    int countByExample(BcinfoExample example);

    int deleteByExample(BcinfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Bcinfo record);

    int insertSelective(Bcinfo record);

    List<Bcinfo> selectByExample(BcinfoExample example);

    Bcinfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Bcinfo record, @Param("example") BcinfoExample example);

    int updateByExample(@Param("record") Bcinfo record, @Param("example") BcinfoExample example);

    int updateByPrimaryKeySelective(Bcinfo record);

    int updateByPrimaryKey(Bcinfo record);
}
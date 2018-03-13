package com.szht.dao;

import com.szht.model.Jcdm;
import com.szht.model.JcdmExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JcdmMapper {
    int countByExample(JcdmExample example);

    int deleteByExample(JcdmExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Jcdm record);

    int insertSelective(Jcdm record);

    List<Jcdm> selectByExample(JcdmExample example);

    Jcdm selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Jcdm record, @Param("example") JcdmExample example);

    int updateByExample(@Param("record") Jcdm record, @Param("example") JcdmExample example);

    int updateByPrimaryKeySelective(Jcdm record);

    int updateByPrimaryKey(Jcdm record);
}
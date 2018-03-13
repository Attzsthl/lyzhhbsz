package com.szht.dao;

import com.szht.model.Problems;
import com.szht.model.ProblemsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProblemsMapper {
    int countByExample(ProblemsExample example);

    int deleteByExample(ProblemsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Problems record);

    int insertSelective(Problems record);

    List<Problems> selectByExample(ProblemsExample example);

    Problems selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Problems record, @Param("example") ProblemsExample example);

    int updateByExample(@Param("record") Problems record, @Param("example") ProblemsExample example);

    int updateByPrimaryKeySelective(Problems record);

    int updateByPrimaryKey(Problems record);
}
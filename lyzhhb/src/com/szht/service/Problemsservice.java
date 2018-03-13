package com.szht.service;

import com.szht.model.Problems;
import com.szht.model.ProblemsExample;
import java.util.List;


public interface Problemsservice {
    int countByExample(ProblemsExample example);

    int deleteByExample(ProblemsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Problems record);

    int insertSelective(Problems record);

    List<Problems> selectByExample(ProblemsExample example);

    Problems selectByPrimaryKey(Integer id);

    int updateByExampleSelective(Problems record, ProblemsExample example);

    int updateByExample(Problems record, ProblemsExample example);

    int updateByPrimaryKeySelective(Problems record);

    int updateByPrimaryKey(Problems record);
}

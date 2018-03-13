package com.szht.service;

import com.szht.model.Bcinfo;
import com.szht.model.BcinfoExample;
import java.util.List;


public interface Bcinfoservice {
    int countByExample(BcinfoExample example);

    int deleteByExample(BcinfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Bcinfo record);

    int insertSelective(Bcinfo record);

    List<Bcinfo> selectByExample(BcinfoExample example);

    Bcinfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(Bcinfo record, BcinfoExample example);

    int updateByExample(Bcinfo record, BcinfoExample example);

    int updateByPrimaryKeySelective(Bcinfo record);

    int updateByPrimaryKey(Bcinfo record);
}

package com.szht.service;

import com.szht.model.Bctbhb;
import com.szht.model.BctbhbExample;
import java.util.List;


public interface Bctbhbservice {
    int countByExample(BctbhbExample example);

    int deleteByExample(BctbhbExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Bctbhb record);

    int insertSelective(Bctbhb record);

    List<Bctbhb> selectByExample(BctbhbExample example);

    Bctbhb selectByPrimaryKey(Integer id);

    int updateByExampleSelective(Bctbhb record, BctbhbExample example);

    int updateByExample(Bctbhb record, BctbhbExample example);

    int updateByPrimaryKeySelective(Bctbhb record);

    int updateByPrimaryKey(Bctbhb record);
}

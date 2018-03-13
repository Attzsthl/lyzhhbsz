package com.szht.service;

import com.szht.model.Jcdm;
import com.szht.model.JcdmExample;
import java.util.List;


public interface Jcdmservice {
    int countByExample(JcdmExample example);

    int deleteByExample(JcdmExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Jcdm record);

    int insertSelective(Jcdm record);

    List<Jcdm> selectByExample(JcdmExample example);

    Jcdm selectByPrimaryKey(Integer id);

    int updateByExampleSelective(Jcdm record, JcdmExample example);

    int updateByExample(Jcdm record, JcdmExample example);

    int updateByPrimaryKeySelective(Jcdm record);

    int updateByPrimaryKey(Jcdm record);
}

package com.szht.service;

import com.szht.model.Xzdm;
import com.szht.model.XzdmExample;
import java.util.List;


public interface Xzdmservice {
    int countByExample(XzdmExample example);

    int deleteByExample(XzdmExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Xzdm record);

    int insertSelective(Xzdm record);

    List<Xzdm> selectByExample(XzdmExample example);

    Xzdm selectByPrimaryKey(Integer id);

    int updateByExampleSelective(Xzdm record, XzdmExample example);

    int updateByExample(Xzdm record, XzdmExample example);

    int updateByPrimaryKeySelective(Xzdm record);

    int updateByPrimaryKey(Xzdm record);
}

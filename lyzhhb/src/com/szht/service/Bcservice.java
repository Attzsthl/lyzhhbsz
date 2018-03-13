package com.szht.service;

import com.szht.model.Bc;
import com.szht.model.BcExample;
import java.util.List;


public interface Bcservice {
    int countByExample(BcExample example);

    int deleteByExample(BcExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Bc record);

    int insertSelective(Bc record);

    List<Bc> selectByExample(BcExample example);

    Bc selectByPrimaryKey(Integer id);

    int updateByExampleSelective(Bc record, BcExample example);

    int updateByExample(Bc record, BcExample example);

    int updateByPrimaryKeySelective(Bc record);

    int updateByPrimaryKey(Bc record);
}

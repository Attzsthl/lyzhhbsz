package com.szht.dao;

import com.szht.model.Bctbhb;
import com.szht.model.BctbhbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BctbhbMapper {
    int countByExample(BctbhbExample example);

    int deleteByExample(BctbhbExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Bctbhb record);

    int insertSelective(Bctbhb record);

    List<Bctbhb> selectByExample(BctbhbExample example);

    Bctbhb selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Bctbhb record, @Param("example") BctbhbExample example);

    int updateByExample(@Param("record") Bctbhb record, @Param("example") BctbhbExample example);

    int updateByPrimaryKeySelective(Bctbhb record);

    int updateByPrimaryKey(Bctbhb record);
}
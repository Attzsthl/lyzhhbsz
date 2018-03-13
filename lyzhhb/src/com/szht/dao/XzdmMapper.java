package com.szht.dao;

import com.szht.model.Xzdm;
import com.szht.model.XzdmExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface XzdmMapper {
    int countByExample(XzdmExample example);

    int deleteByExample(XzdmExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Xzdm record);

    int insertSelective(Xzdm record);

    List<Xzdm> selectByExample(XzdmExample example);

    Xzdm selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Xzdm record, @Param("example") XzdmExample example);

    int updateByExample(@Param("record") Xzdm record, @Param("example") XzdmExample example);

    int updateByPrimaryKeySelective(Xzdm record);

    int updateByPrimaryKey(Xzdm record);
}
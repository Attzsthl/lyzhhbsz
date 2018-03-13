package com.szht.service;

import com.szht.model.Site;
import com.szht.model.SiteExample;
import java.util.List;


public interface Siteservice {
    int countByExample(SiteExample example);

    int deleteByExample(SiteExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Site record);

    int insertSelective(Site record);

    List<Site> selectByExample(SiteExample example);

    Site selectByPrimaryKey(Integer id);

    int updateByExampleSelective(Site record, SiteExample example);

    int updateByExample(Site record, SiteExample example);

    int updateByPrimaryKeySelective(Site record);

    int updateByPrimaryKey(Site record);
}

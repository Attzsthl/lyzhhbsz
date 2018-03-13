package com.szht.service.impl;
import com.szht.model.Site;
import com.szht.model.SiteExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.szht.service.Siteservice;
@Service
public class Siteserviceimpl implements Siteservice{
@Resource
com.szht.dao.SiteMapper siteMapper;
@Override
public int countByExample(SiteExample example){
return siteMapper.countByExample(example);
}
@Override
public int deleteByExample(SiteExample example){
return siteMapper.deleteByExample(example);
}
@Override
public int deleteByPrimaryKey(Integer id){
return siteMapper.deleteByPrimaryKey(id);
}
@Override
public int insert(Site record){
return siteMapper.insert(record);
}
@Override
public int insertSelective(Site record){
return siteMapper.insertSelective(record);
}
@Override
public List<Site> selectByExample(SiteExample example){
return siteMapper.selectByExample(example);
}
@Override
public Site selectByPrimaryKey(Integer id){
return siteMapper.selectByPrimaryKey(id);
}
@Override
public int updateByExampleSelective(Site record, SiteExample example){
return siteMapper.updateByExampleSelective(record,example);
}
@Override
public int updateByExample(Site record, SiteExample example){
return siteMapper.updateByExample(record,example);
}
@Override
public int updateByPrimaryKeySelective(Site record){
return siteMapper.updateByPrimaryKeySelective(record);
}
@Override
public int updateByPrimaryKey(Site record){
return siteMapper.updateByPrimaryKey(record);
}
}

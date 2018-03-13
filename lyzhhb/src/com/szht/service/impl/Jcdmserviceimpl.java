package com.szht.service.impl;
import com.szht.model.Jcdm;
import com.szht.model.JcdmExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.szht.service.Jcdmservice;
@Service
public class Jcdmserviceimpl implements Jcdmservice{
@Resource
com.szht.dao.JcdmMapper jcdmMapper;
@Override
public int countByExample(JcdmExample example){
return jcdmMapper.countByExample(example);
}
@Override
public int deleteByExample(JcdmExample example){
return jcdmMapper.deleteByExample(example);
}
@Override
public int deleteByPrimaryKey(Integer id){
return jcdmMapper.deleteByPrimaryKey(id);
}
@Override
public int insert(Jcdm record){
return jcdmMapper.insert(record);
}
@Override
public int insertSelective(Jcdm record){
return jcdmMapper.insertSelective(record);
}
@Override
public List<Jcdm> selectByExample(JcdmExample example){
return jcdmMapper.selectByExample(example);
}
@Override
public Jcdm selectByPrimaryKey(Integer id){
return jcdmMapper.selectByPrimaryKey(id);
}
@Override
public int updateByExampleSelective(Jcdm record, JcdmExample example){
return jcdmMapper.updateByExampleSelective(record,example);
}
@Override
public int updateByExample(Jcdm record, JcdmExample example){
return jcdmMapper.updateByExample(record,example);
}
@Override
public int updateByPrimaryKeySelective(Jcdm record){
return jcdmMapper.updateByPrimaryKeySelective(record);
}
@Override
public int updateByPrimaryKey(Jcdm record){
return jcdmMapper.updateByPrimaryKey(record);
}
}

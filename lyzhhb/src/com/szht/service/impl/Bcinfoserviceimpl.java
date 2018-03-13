package com.szht.service.impl;
import com.szht.model.Bcinfo;
import com.szht.model.BcinfoExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.szht.service.Bcinfoservice;
@Service
public class Bcinfoserviceimpl implements Bcinfoservice{
@Resource
com.szht.dao.BcinfoMapper bcinfoMapper;
@Override
public int countByExample(BcinfoExample example){
return bcinfoMapper.countByExample(example);
}
@Override
public int deleteByExample(BcinfoExample example){
return bcinfoMapper.deleteByExample(example);
}
@Override
public int deleteByPrimaryKey(Integer id){
return bcinfoMapper.deleteByPrimaryKey(id);
}
@Override
public int insert(Bcinfo record){
return bcinfoMapper.insert(record);
}
@Override
public int insertSelective(Bcinfo record){
return bcinfoMapper.insertSelective(record);
}
@Override
public List<Bcinfo> selectByExample(BcinfoExample example){
return bcinfoMapper.selectByExample(example);
}
@Override
public Bcinfo selectByPrimaryKey(Integer id){
return bcinfoMapper.selectByPrimaryKey(id);
}
@Override
public int updateByExampleSelective(Bcinfo record, BcinfoExample example){
return bcinfoMapper.updateByExampleSelective(record,example);
}
@Override
public int updateByExample(Bcinfo record, BcinfoExample example){
return bcinfoMapper.updateByExample(record,example);
}
@Override
public int updateByPrimaryKeySelective(Bcinfo record){
return bcinfoMapper.updateByPrimaryKeySelective(record);
}
@Override
public int updateByPrimaryKey(Bcinfo record){
return bcinfoMapper.updateByPrimaryKey(record);
}
}

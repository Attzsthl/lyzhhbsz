package com.szht.service.impl;
import com.szht.model.Bc;
import com.szht.model.BcExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.szht.service.Bcservice;
@Service
public class Bcserviceimpl implements Bcservice{
@Resource
com.szht.dao.BcMapper bcMapper;
@Override
public int countByExample(BcExample example){
return bcMapper.countByExample(example);
}
@Override
public int deleteByExample(BcExample example){
return bcMapper.deleteByExample(example);
}
@Override
public int deleteByPrimaryKey(Integer id){
return bcMapper.deleteByPrimaryKey(id);
}
@Override
public int insert(Bc record){
return bcMapper.insert(record);
}
@Override
public int insertSelective(Bc record){
return bcMapper.insertSelective(record);
}
@Override
public List<Bc> selectByExample(BcExample example){
return bcMapper.selectByExample(example);
}
@Override
public Bc selectByPrimaryKey(Integer id){
return bcMapper.selectByPrimaryKey(id);
}
@Override
public int updateByExampleSelective(Bc record, BcExample example){
return bcMapper.updateByExampleSelective(record,example);
}
@Override
public int updateByExample(Bc record, BcExample example){
return bcMapper.updateByExample(record,example);
}
@Override
public int updateByPrimaryKeySelective(Bc record){
return bcMapper.updateByPrimaryKeySelective(record);
}
@Override
public int updateByPrimaryKey(Bc record){
return bcMapper.updateByPrimaryKey(record);
}
}

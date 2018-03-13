package com.szht.service.impl;
import com.szht.model.Xzdm;
import com.szht.model.XzdmExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.szht.service.Xzdmservice;
@Service
public class Xzdmserviceimpl implements Xzdmservice{
@Resource
com.szht.dao.XzdmMapper xzdmMapper;
@Override
public int countByExample(XzdmExample example){
return xzdmMapper.countByExample(example);
}
@Override
public int deleteByExample(XzdmExample example){
return xzdmMapper.deleteByExample(example);
}
@Override
public int deleteByPrimaryKey(Integer id){
return xzdmMapper.deleteByPrimaryKey(id);
}
@Override
public int insert(Xzdm record){
return xzdmMapper.insert(record);
}
@Override
public int insertSelective(Xzdm record){
return xzdmMapper.insertSelective(record);
}
@Override
public List<Xzdm> selectByExample(XzdmExample example){
return xzdmMapper.selectByExample(example);
}
@Override
public Xzdm selectByPrimaryKey(Integer id){
return xzdmMapper.selectByPrimaryKey(id);
}
@Override
public int updateByExampleSelective(Xzdm record, XzdmExample example){
return xzdmMapper.updateByExampleSelective(record,example);
}
@Override
public int updateByExample(Xzdm record, XzdmExample example){
return xzdmMapper.updateByExample(record,example);
}
@Override
public int updateByPrimaryKeySelective(Xzdm record){
return xzdmMapper.updateByPrimaryKeySelective(record);
}
@Override
public int updateByPrimaryKey(Xzdm record){
return xzdmMapper.updateByPrimaryKey(record);
}
}

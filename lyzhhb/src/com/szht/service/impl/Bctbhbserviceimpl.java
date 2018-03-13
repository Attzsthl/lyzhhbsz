package com.szht.service.impl;
import com.szht.model.Bctbhb;
import com.szht.model.BctbhbExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.szht.service.Bctbhbservice;
@Service
public class Bctbhbserviceimpl implements Bctbhbservice{
@Resource
com.szht.dao.BctbhbMapper bctbhbMapper;
@Override
public int countByExample(BctbhbExample example){
return bctbhbMapper.countByExample(example);
}
@Override
public int deleteByExample(BctbhbExample example){
return bctbhbMapper.deleteByExample(example);
}
@Override
public int deleteByPrimaryKey(Integer id){
return bctbhbMapper.deleteByPrimaryKey(id);
}
@Override
public int insert(Bctbhb record){
return bctbhbMapper.insert(record);
}
@Override
public int insertSelective(Bctbhb record){
return bctbhbMapper.insertSelective(record);
}
@Override
public List<Bctbhb> selectByExample(BctbhbExample example){
return bctbhbMapper.selectByExample(example);
}
@Override
public Bctbhb selectByPrimaryKey(Integer id){
return bctbhbMapper.selectByPrimaryKey(id);
}
@Override
public int updateByExampleSelective(Bctbhb record, BctbhbExample example){
return bctbhbMapper.updateByExampleSelective(record,example);
}
@Override
public int updateByExample(Bctbhb record, BctbhbExample example){
return bctbhbMapper.updateByExample(record,example);
}
@Override
public int updateByPrimaryKeySelective(Bctbhb record){
return bctbhbMapper.updateByPrimaryKeySelective(record);
}
@Override
public int updateByPrimaryKey(Bctbhb record){
return bctbhbMapper.updateByPrimaryKey(record);
}
}

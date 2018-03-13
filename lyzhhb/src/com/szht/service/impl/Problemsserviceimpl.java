package com.szht.service.impl;
import com.szht.model.Problems;
import com.szht.model.ProblemsExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.szht.service.Problemsservice;
@Service
public class Problemsserviceimpl implements Problemsservice{
@Resource
com.szht.dao.ProblemsMapper problemsMapper;
@Override
public int countByExample(ProblemsExample example){
return problemsMapper.countByExample(example);
}
@Override
public int deleteByExample(ProblemsExample example){
return problemsMapper.deleteByExample(example);
}
@Override
public int deleteByPrimaryKey(Integer id){
return problemsMapper.deleteByPrimaryKey(id);
}
@Override
public int insert(Problems record){
return problemsMapper.insert(record);
}
@Override
public int insertSelective(Problems record){
return problemsMapper.insertSelective(record);
}
@Override
public List<Problems> selectByExample(ProblemsExample example){
return problemsMapper.selectByExample(example);
}
@Override
public Problems selectByPrimaryKey(Integer id){
return problemsMapper.selectByPrimaryKey(id);
}
@Override
public int updateByExampleSelective(Problems record, ProblemsExample example){
return problemsMapper.updateByExampleSelective(record,example);
}
@Override
public int updateByExample(Problems record, ProblemsExample example){
return problemsMapper.updateByExample(record,example);
}
@Override
public int updateByPrimaryKeySelective(Problems record){
return problemsMapper.updateByPrimaryKeySelective(record);
}
@Override
public int updateByPrimaryKey(Problems record){
return problemsMapper.updateByPrimaryKey(record);
}
}

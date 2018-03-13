package com.szht.service.impl;
import com.szht.model.User;
import com.szht.model.UserExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.szht.service.Userservice;
@Service
public class Userserviceimpl implements Userservice{
@Resource
com.szht.dao.UserMapper userMapper;
@Override
public int countByExample(UserExample example){
return userMapper.countByExample(example);
}
@Override
public int deleteByExample(UserExample example){
return userMapper.deleteByExample(example);
}
@Override
public int deleteByPrimaryKey(Integer id){
return userMapper.deleteByPrimaryKey(id);
}
@Override
public int insert(User record){
return userMapper.insert(record);
}
@Override
public int insertSelective(User record){
return userMapper.insertSelective(record);
}
@Override
public List<User> selectByExample(UserExample example){
return userMapper.selectByExample(example);
}
@Override
public User selectByPrimaryKey(Integer id){
return userMapper.selectByPrimaryKey(id);
}
@Override
public int updateByExampleSelective(User record, UserExample example){
return userMapper.updateByExampleSelective(record,example);
}
@Override
public int updateByExample(User record, UserExample example){
return userMapper.updateByExample(record,example);
}
@Override
public int updateByPrimaryKeySelective(User record){
return userMapper.updateByPrimaryKeySelective(record);
}
@Override
public int updateByPrimaryKey(User record){
return userMapper.updateByPrimaryKey(record);
}
}

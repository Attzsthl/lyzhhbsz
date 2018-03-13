package com.szht.service.impl;
import com.szht.model.UserPermission;
import com.szht.model.UserPermissionExample;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.szht.service.UserPermissionservice;
@Service
public class UserPermissionserviceimpl implements UserPermissionservice{
@Resource
com.szht.dao.UserPermissionMapper userPermissionMapper;
@Override
public int countByExample(UserPermissionExample example){
return userPermissionMapper.countByExample(example);
}
@Override
public int deleteByExample(UserPermissionExample example){
return userPermissionMapper.deleteByExample(example);
}
@Override
public int deleteByPrimaryKey(Integer id){
return userPermissionMapper.deleteByPrimaryKey(id);
}
@Override
public int insert(UserPermission record){
return userPermissionMapper.insert(record);
}
@Override
public int insertSelective(UserPermission record){
return userPermissionMapper.insertSelective(record);
}
@Override
public List<UserPermission> selectByExample(UserPermissionExample example){
return userPermissionMapper.selectByExample(example);
}
@Override
public UserPermission selectByPrimaryKey(Integer id){
return userPermissionMapper.selectByPrimaryKey(id);
}
@Override
public int updateByExampleSelective(UserPermission record, UserPermissionExample example){
return userPermissionMapper.updateByExampleSelective(record,example);
}
@Override
public int updateByExample(UserPermission record, UserPermissionExample example){
return userPermissionMapper.updateByExample(record,example);
}
@Override
public int updateByPrimaryKeySelective(UserPermission record){
return userPermissionMapper.updateByPrimaryKeySelective(record);
}
@Override
public int updateByPrimaryKey(UserPermission record){
return userPermissionMapper.updateByPrimaryKey(record);
}
}

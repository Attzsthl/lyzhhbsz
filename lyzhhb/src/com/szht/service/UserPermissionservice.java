package com.szht.service;

import com.szht.model.UserPermission;
import com.szht.model.UserPermissionExample;
import java.util.List;


public interface UserPermissionservice {
    int countByExample(UserPermissionExample example);

    int deleteByExample(UserPermissionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserPermission record);

    int insertSelective(UserPermission record);

    List<UserPermission> selectByExample(UserPermissionExample example);

    UserPermission selectByPrimaryKey(Integer id);

    int updateByExampleSelective(UserPermission record, UserPermissionExample example);

    int updateByExample(UserPermission record, UserPermissionExample example);

    int updateByPrimaryKeySelective(UserPermission record);

    int updateByPrimaryKey(UserPermission record);
}

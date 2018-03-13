package com.szht.shiro;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import com.szht.dao.UserMapper;
import com.szht.model.User;
import com.szht.model.UserPermission;
import com.szht.model.custom.UserCustom;
import com.szht.model.custom.UserPermissionCustom;
import com.szht.service.Toexampleservice;
import com.szht.service.UserPermissionservice;
import com.szht.service.Userservice;
import com.szht.util.MD5;



public class CustomRealm extends AuthorizingRealm{
	@Resource
	MD5 md5;
	@Resource
	UserMapper userMapper;
	@Resource
	Toexampleservice toexampleservice;
	@Resource
	Userservice glUserservice;
	@Resource
	UserPermissionservice userPermissionservice;
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		//从 principals获取主身份信息
		//将getPrimaryPrincipal方法返回值转为真实身份类型（在上边的doGetAuthenticationInfo认证通过填充到SimpleAuthenticationInfo中身份类型），
		User user =  (User) principals.getPrimaryPrincipal();
		
		//根据身份信息获取权限信息
		//从数据库获取到权限数据


		//单独定一个集合对象 
		List<String> permissions = new ArrayList<String>();
		//将数据库中的权限标签 符放入集合
		UserPermissionCustom userPermissionCustom=new UserPermissionCustom();
		userPermissionCustom.setUsercode(user.getUsercode());
		List<UserPermission> userPermissions=userPermissionservice.selectByExample(toexampleservice.userPermissiontoexample(userPermissionCustom));
		for(UserPermission userPermission:userPermissions)
		{
			permissions.add(userPermission.getPermission());
		}

//		List<String> permissions = new ArrayList<String>();
//		permissions.add("user:create");//用户的创建
//		permissions.add("item:query");//商品查询权限
//		permissions.add("item:add");//商品添加权限
//		permissions.add("item:edit");//商品修改权限
		//....
		
		//查到权限数据，返回授权信息(要包括 上边的permissions)
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		//将上边查询到授权信息填充到simpleAuthorizationInfo对象中
		simpleAuthorizationInfo.addStringPermissions(permissions);

		return simpleAuthorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		// token是用户输入的用户名和密码 
		// 第一步从token中取出用户名
		UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
		String tokenCredentials = String.valueOf(usernamePasswordToken.getPassword());
		String userCode = (String) token.getPrincipal();
		UserCustom glUser=new UserCustom();
		glUser.setUsercode(userCode);
		List<User> user=userMapper.selectByExample(toexampleservice.usertoexample(glUser));
		String salt="jacksung";
		if(user.size()==0)
			return null;
		String password=user.get(0).getPassword();
		if(md5.md5(tokenCredentials,"jacksung",2).equals(password))
		{
			user.get(0).setLogtimes(user.get(0).getLogtimes()+1);
			user.get(0).setLasttime(new Date());
			glUserservice.updateByPrimaryKeySelective(user.get(0));
		}
		SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
				user, password, ByteSource.Util.bytes(salt),this.getName());
		return simpleAuthenticationInfo;
	}
	
	//清除缓存
	public void clearCached() {
		PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
		super.clearCache(principals);
	}
    //将传进来密码加密方法  
//    private String encrypt(String data) {  
//        Object sha384Hex = new Md5Hash(data,"jacksung",2);//这里可以选择自己的密码验证方式 比如 md5或者sha256等  
//        return sha384Hex.toString();  
//    }
}

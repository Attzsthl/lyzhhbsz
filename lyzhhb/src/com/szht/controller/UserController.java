package com.szht.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.szht.model.User;
import com.szht.model.UserPermission;
import com.szht.model.custom.UserCustom;
import com.szht.model.custom.UserPermissionCustom;
import com.szht.service.Toexampleservice;
import com.szht.service.UserPermissionservice;
import com.szht.service.Userservice;
import com.szht.util.MD5;


@Controller
public class UserController {
    @Resource
    private Userservice userservice;
    @Resource
    private  Toexampleservice toexampleservice;
    JsonConfig jsonConfig = new JsonConfig();
	 SimpleDateFormat myFmt2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @ModelAttribute
    public void jsondata()
    {
	    jsonConfig.registerJsonValueProcessor(java.util.Date.class,new JsonValueProcessor() {
	        private final String format="yyyy-MM-dd HH:mm:ss";
	        public Object processObjectValue(String key, Object value,JsonConfig arg2){
	          if(value==null)
	                return "";
	          if (value instanceof java.util.Date) {
	                String str = new SimpleDateFormat(format).format((java.util.Date) value);
	                return str;
	          }
	                return value.toString();
	        }
	        public Object processArrayValue(Object value, JsonConfig arg1){
	                   return null;
	        }       
	    });
    }
    
    @RequiresPermissions("super")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @RequestMapping("selectUser.action")
    public void selectUser(HttpServletRequest request,HttpServletResponse response,UserCustom example)
    {     

    	List<User> result=userservice.selectByExample(toexampleservice.usertoexample(example));
 
	        JSONArray jsonArray=JSONArray.fromObject(result,jsonConfig);
	        String json=jsonArray.toString();
			try {
				response.setCharacterEncoding("UTF-8");
				response.setContentType("text/json");
				response.getWriter().write(json);
				response.getWriter().flush();
				response.getWriter().close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
    	
    }
    @Resource MD5 md5;
    @Resource UserPermissionservice userPermissionservice;
    @RequestMapping("changepassword.action")//更改密码
    public void changepassword(HttpServletRequest request,HttpServletResponse response,String password)
    {
    	String result="";
		//从shiro的session中取activeUser
		Subject subject = SecurityUtils.getSubject();
		//取身份信息
		User user = (User) subject.getPrincipal();
		String psd=md5.md5(password, "jacksung", 2);
		if(psd==null)
			result="密码格式错误";
		else if(psd=="")
			result="不能为空";
		else
		{
			user.setPassword2(password);
			user.setPassword(psd);
			userservice.updateByPrimaryKey(user);
			result="操作成功";
		}
		try {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/json");
			response.getWriter().write(result);
			response.getWriter().flush();
			response.getWriter().close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
    }
    @RequiresPermissions("super")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @RequestMapping("deleteUser.action")
    public void deleteUser(HttpServletRequest request,HttpServletResponse response,UserCustom example,String ids)
    {            	
		
		int result=1;
    	if(ids!=null)
    	{
    		
	    	String[] idStrings=ids.split(",");
		    for(String idString:idStrings)
		    {
		    	Integer id= Integer.valueOf(idString);
		    	

		    	
		    	if(userservice.deleteByPrimaryKey(id)==0)
		    		result=0;
		    	
		    	UserPermissionCustom userPermissionCustom=new UserPermissionCustom();
		    	User user=userservice.selectByPrimaryKey(id);
		    	userPermissionCustom.setUsercode(user.getUsercode());
		    	userPermissionservice.deleteByExample(toexampleservice.userPermissiontoexample(userPermissionCustom));
		    }
    	}
    	else {
	    	UserPermissionCustom userPermissionCustom=new UserPermissionCustom();
	    	User user=userservice.selectByPrimaryKey(example.getId());
	    	userPermissionCustom.setUsercode(user.getUsercode());
	    	userPermissionservice.deleteByExample(toexampleservice.userPermissiontoexample(userPermissionCustom));
	    	
    		userservice.deleteByPrimaryKey(example.getId());
		}

		
			String resultstring="操作成功";
			if(result!=1)
				resultstring="操作失败";
			try {
				response.setCharacterEncoding("UTF-8");
				response.setContentType("text/json");
				response.getWriter().write(resultstring);
				response.getWriter().flush();
				response.getWriter().close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
    	
    }
    @RequiresPermissions("super")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @RequestMapping("updateUser.action")
    public void updateUser(HttpServletRequest request,HttpServletResponse response,UserCustom record)
    {     
    	System.out.println("注册用户");
    	String result="操作成功";
    	String psdString=md5.md5(record.getPassword(),"jacksung",2);

    	UserCustom userCustom=new UserCustom();
    	userCustom.setUsercode(record.getUsercode());
    	List<User> userlist=userservice.selectByExample(toexampleservice.usertoexample(userCustom));
    	if(userlist!=null&&userlist.size()!=0&&userlist.get(0)!=null)
    	{
    		result="账户名已存在";
    	}
    	else if(psdString==null)
    		result="密码格式错误";
    	else if(psdString=="")
    		result="请输入密码";
    	else if(record.getUsercode()=="")
    		result="请输入账号";
		else if(record.getUsername()=="")
			result="请输入使用者";
		else	
		{
			record.setPassword2(record.getPassword());
    	record.setPassword(psdString);
    	record.setLogtimes(0);
    	record.setCreatetime(new Date());
    	userservice.insert(record);
    	
    	UserPermission userPermission=new UserPermission();
    	userPermission.setUsercode(record.getUsercode());
    	userPermission.setPermission("user");
    	userPermissionservice.insertSelective(userPermission);
		}
		try {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/json");
			response.getWriter().write(result);
			response.getWriter().flush();
			response.getWriter().close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
    	
    }
    
    @RequiresPermissions("super")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @RequestMapping("changeuserinfo.action")
    public void changeuserinfo(HttpServletRequest request,HttpServletResponse response,UserCustom example)
    {            	
    	example.setPassword(md5.md5(example.getPassword2(), "jacksung", 2));
    	int result=userservice.updateByPrimaryKeySelective(example);
		String resultstring="操作成功";
		if(result!=1)
			resultstring="操作失败";
		try {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/json");
			response.getWriter().write(resultstring);
			response.getWriter().flush();
			response.getWriter().close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
    	
    }
    
}

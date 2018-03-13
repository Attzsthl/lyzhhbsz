package com.szht.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.szht.model.UserPermission;
import com.szht.model.custom.UserPermissionCustom;
import com.szht.service.Toexampleservice;
import com.szht.service.UserPermissionservice;
import com.szht.shiro.CustomRealm;
@Controller
public class UserPermissionController {
    @Resource
    private UserPermissionservice userPermissionservice;
    @Resource
    private CustomRealm customRealm;
    @Resource
    private  Toexampleservice toexampleservice;
    JsonConfig jsonConfig = new JsonConfig();
	 SimpleDateFormat myFmt2=new SimpleDateFormat("yyyy-MM-dd");
    @ModelAttribute
    public void jsondata()
    {
	    jsonConfig.registerJsonValueProcessor(java.util.Date.class,new JsonValueProcessor() {
	        private final String format="yyyy-MM-dd";
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
    @RequestMapping("selectUserPermission.action")
    public void selectUserPermission(HttpServletRequest request,HttpServletResponse response,UserPermissionCustom example)
    {     

    	List<UserPermission> result=userPermissionservice.selectByExample(toexampleservice.userPermissiontoexample(example));
 
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
    @RequiresPermissions("super")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @RequestMapping("deleteUserPermission.action")
    public void deleteUserPermission(HttpServletRequest request,HttpServletResponse response,UserPermissionCustom example,String ids)
    {            	
			
		int result=1;
    	if(ids!=null)
    	{

	    	String[] idStrings=ids.split(",");
		    for(String idString:idStrings)
		    {
		    	Integer id= Integer.valueOf(idString);
		    	if(userPermissionservice.deleteByPrimaryKey(id)==0)
	    		result=0;
	
		    }
    	}
    	else {
    		userPermissionservice.deleteByPrimaryKey(example.getId());
		}

		
			String resultstring="操作成功";
			if(result!=1)
				resultstring="操作失败";
			customRealm.clearCached();
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
    @RequestMapping("updateUserPermission.action")
    public void updateUserPermission(HttpServletRequest request,HttpServletResponse response,UserPermissionCustom example)
    {     
	    	int result;
	    	if(example.getId()!=null)
	    		result=userPermissionservice.updateByPrimaryKeySelective(example);
	    	else {
				result=userPermissionservice.insertSelective(example);
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

}

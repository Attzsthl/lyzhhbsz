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
import org.apache.shiro.subject.Subject;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.szht.model.Problems;
import com.szht.model.User;
import com.szht.model.custom.ProblemsCustom;
import com.szht.service.Problemsservice;
import com.szht.service.Toexampleservice;


@Controller
public class ProblemsController {
    @Resource
    private Problemsservice problemsservice;
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
    

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @RequestMapping("selectProblems.action")
    public void selectProblems(HttpServletRequest request,HttpServletResponse response,ProblemsCustom example)
    {     

    	List<Problems> result=problemsservice.selectByExample(toexampleservice.problemstoexample(example));
 
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
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @RequestMapping("deleteProblems.action")
    public void deleteProblems(HttpServletRequest request,HttpServletResponse response,ProblemsCustom example,String ids)
    {            	
			
		int result=1;
    	if(ids!=null)
    	{

	    	String[] idStrings=ids.split(",");
		    for(String idString:idStrings)
		    {
		    	Integer id= Integer.valueOf(idString);
		    	if(problemsservice.deleteByPrimaryKey(id)==0)
	    		result=0;
	
		    }
    	}
    	else {
    		problemsservice.deleteByPrimaryKey(example.getId());
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
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @RequestMapping("updateProblems.action")
    public void updateProblems(HttpServletRequest request,HttpServletResponse response,ProblemsCustom example)
    {   
		//从shiro的session中取activeUser
		Subject subject = SecurityUtils.getSubject();
		//取身份信息
		User user = (User) subject.getPrincipal();
    	
	    	int result;
	    	if(example.getId()!=null){
	    		
	    		result=problemsservice.updateByPrimaryKeySelective(example);
	    	}

	    	else {
	    		example.setUsername(user.getUsername());
	    		example.setSubmittime(new Date());
	    		example.setStatus("未处理");
				result=problemsservice.insertSelective(example);
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

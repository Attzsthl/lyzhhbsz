package com.szht.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

import org.apache.shiro.authc.DisabledAccountException;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.szht.model.Jcdm;
import com.szht.model.JcdmExample;
import com.szht.model.custom.JcdmCustom;
import com.szht.service.Jcdmservice;
import com.szht.service.Toexampleservice;


@Controller
public class JcdmController {
    @Resource
    private Jcdmservice jcdmservice;
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
    @RequestMapping("selectJcdm.action")
    public void selectJcdm(HttpServletRequest request,HttpServletResponse response,JcdmCustom example)
    {     
    	JcdmExample jcdmExample=toexampleservice.jcdmtoexample(example);
    	jcdmExample.setOrderByClause("year,month,dmmc desc");
    	List<Jcdm> result=jcdmservice.selectByExample(jcdmExample);
 
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
    @RequestMapping("deleteJcdm.action")
    public void deleteJcdm(HttpServletRequest request,HttpServletResponse response,JcdmCustom example,String ids)
    {            	
			
		int result=1;
    	if(ids!=null)
    	{

	    	String[] idStrings=ids.split(",");
		    for(String idString:idStrings)
		    {
		    	Integer id= Integer.valueOf(idString);
		    	if(jcdmservice.deleteByPrimaryKey(id)==0)
	    		result=0;
	
		    }
    	}
    	else {
    		jcdmservice.deleteByPrimaryKey(example.getId());
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
    @RequestMapping("updateJcdm.action")
    public void updateJcdm(HttpServletRequest request,HttpServletResponse response,JcdmCustom example)
    {     
	    	int result;
	    	if(example.getId()!=null)
	    		result=jcdmservice.updateByPrimaryKeySelective(example);
	    	else {
				result=jcdmservice.insertSelective(example);
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

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

import com.szht.model.Bctbhb;
import com.szht.model.custom.BctbhbCustom;
import com.szht.service.Bctbhbservice;
import com.szht.service.Toexampleservice;


@Controller
public class BctbhbController {
    @Resource
    private Bctbhbservice bctbhbservice;
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
    @RequestMapping("selectBctbhb.action")
    public void selectBctbhb(HttpServletRequest request,HttpServletResponse response,BctbhbCustom example)
    {     

    	List<Bctbhb> result=bctbhbservice.selectByExample(toexampleservice.bctbhbtoexample(example));
 
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
    @RequestMapping("deleteBctbhb.action")
    public void deleteBctbhb(HttpServletRequest request,HttpServletResponse response,BctbhbCustom example,String ids)
    {            	
			
		int result=1;
    	if(ids!=null)
    	{

	    	String[] idStrings=ids.split(",");
		    for(String idString:idStrings)
		    {
		    	Integer id= Integer.valueOf(idString);
		    	if(bctbhbservice.deleteByPrimaryKey(id)==0)
	    		result=0;
	
		    }
    	}
    	else {
    		bctbhbservice.deleteByPrimaryKey(example.getId());
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
    @RequestMapping("updateBctbhb.action")
    public void updateBctbhb(HttpServletRequest request,HttpServletResponse response,BctbhbCustom example)
    {     
	    	int result;
	    	if(example.getId()!=null)
	    		result=bctbhbservice.updateByPrimaryKeySelective(example);
	    	else {
				result=bctbhbservice.insertSelective(example);
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

package com.szht.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.szht.model.Bc;
import com.szht.model.BcExample;
import com.szht.model.JcdmExample;
import com.szht.model.custom.BcCustom;
import com.szht.service.Bcservice;
import com.szht.service.Toexampleservice;


@Controller
public class BcController {
	@Resource
	com.szht.util.Log log;
	@Resource
	private Bcservice bcservice;
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
    @RequestMapping("selectBc.action")
    public void selectBc(HttpServletRequest request,HttpServletResponse response,BcCustom example)
    {     
    	
    	BcExample bcExample=toexampleservice.bctoexample(example);
    	bcExample.setOrderByClause("year,month,dm desc");
    	List<Bc> result=bcservice.selectByExample(bcExample);
 
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
    @RequestMapping("deleteBc.action")
    public void deleteBc(HttpServletRequest request,HttpServletResponse response,BcCustom example,String ids)
    {            	
    	try {
    		Bc bc=bcservice.selectByPrimaryKey(example.getId());
			log.writelog("区域补偿断面删除", "bc表格", "id:"+bc.getId()+"、断面名称："+bc.getDm()+"、年份"+bc.getYear()+"、月份："+bc.getMonth());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int result=1;
    	if(ids!=null)
    	{

	    	String[] idStrings=ids.split(",");
		    for(String idString:idStrings)
		    {
		    	Integer id= Integer.valueOf(idString);
		    	if(bcservice.deleteByPrimaryKey(id)==0)
	    		result=0;
	
		    }
    	}
    	else {
    		bcservice.deleteByPrimaryKey(example.getId());
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
    @RequestMapping("updateBc.action")
    public void updateBc(HttpServletRequest request,HttpServletResponse response,BcCustom example)
    {     
	    	int result;
	    	if(example.getId()!=null)
	    		result=bcservice.updateByPrimaryKeySelective(example);
	    	else {
				result=bcservice.insertSelective(example);
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

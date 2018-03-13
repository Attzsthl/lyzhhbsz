package com.szht.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.processors.DefaultValueProcessor;
import net.sf.json.processors.JsonValueProcessor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.szht.model.Bc;
import com.szht.model.BcExample;
import com.szht.model.BcSeri;
import com.szht.model.custom.BcCustom;
import com.szht.service.Bcservice;
import com.szht.service.CustomService;
import com.szht.service.Toexampleservice;

@Controller
public class letecontroller {
    @Resource
    private Bcservice bcservice;
    @Resource
    private  Toexampleservice toexampleservice;
    JsonConfig jsonConfig=new JsonConfig();
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
        jsonConfig.registerDefaultValueProcessor(Double.class,  
                new DefaultValueProcessor() {  
                    public Object getDefaultValue(Class type) {  
                        return null;  
                    }  
                }); 
    }
    @Autowired
    CustomService customService;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @RequestMapping("newbc.action")
    public void bc(HttpServletRequest request,HttpServletResponse response,BcCustom example,String type)
    {
    	List<Bc> bcList=new ArrayList<Bc>();
        BcExample bcExample=toexampleservice.bctoexample(example);
        bcExample.setOrderByClause("year");
    	if(example.getYear()!=-1){
    		 bcList=bcservice.selectByExample(bcExample);
    	}else {
    		List<Integer> years=customService.BcCountYearByName(example.getDm());
    		for (int i = 0; i < years.size(); i++) {
    			example.setYear(years.get(i));
    			bcList.addAll(bcservice.selectByExample(toexampleservice.bctoexample(example)));
			}
		}

       
        ArrayList<BcSeri> series=new ArrayList<BcSeri>();
        
        BcSeri bsbz=new BcSeri();
        ArrayList<Double> databz=new ArrayList<Double>();
        
        for(int i=0;i<bcList.size();++i){
            //int k;
            if(type.equals("高锰酸盐"))
                   databz.add(bcList.get(i).getGmsy());
                 
               
            if(type.equals("氨氮"))
                    databz.add(bcList.get(i).getAd());
                   
              
            if(type.equals("总磷"))
                    databz.add(bcList.get(i).getZl());
        }
        //bsbz.setName(String(example.getYear()));
        bsbz.setName(type);
        bsbz.setData(databz);
        series.add(bsbz);
        
        JSONArray jsonArray=JSONArray.fromObject(series,jsonConfig);
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
}

package com.szht.controller;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.szht.model.Site;
import com.szht.service.Siteservice;
import com.szht.service.Toexampleservice;
@Component
public class Api {
//	private Api() throws Exception{
//		test();
//	}
    @Resource
    private Siteservice siteservice;
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

    @Scheduled(cron = "0 10/60 * * * ?")
    public void api() throws Exception{
    	
        URL u=new URL("http://route.showapi.com/104-29?showapi_appid=47497&showapi_sign=a250802b940649a7b8947763e19f7f8a&city=%e6%ba%a7%e9%98%b3");
        //System.out.println(u);
        InputStream in=u.openStream();
        ByteArrayOutputStream out=new ByteArrayOutputStream();
        try {
            byte buf[]=new byte[1024];
            int read = 0;
            while ((read = in.read(buf)) > 0) {
                out.write(buf, 0, read);
            }
        }  finally {
            if (in != null) {
                in.close();
            }
        }
        byte b[]=out.toByteArray( );
        String result = new String(b,"utf-8");
        result=result.replace("primary_pollutant", "primaryPollutant").replace("site_name", "siteName").replace("_", "");
        //System.out.println(result);
        JSONObject jsonobject=JSONObject.fromObject(result,jsonConfig);
        JSONObject showapi_res_body=JSONObject.fromObject(jsonobject.get("showapiresbody"));
        
        JSONArray siteList=JSONArray.fromObject(showapi_res_body.get("siteList"));
        //System.out.println(siteList);
        JSONObject dmzz=JSONObject.fromObject(siteList.get(0));
        JSONObject yszz=JSONObject.fromObject(siteList.get(1));
        
        Site dmzzmodel = (Site) JSONObject.toBean(dmzz,Site.class); 
        Site yszzmodel = (Site) JSONObject.toBean(yszz,Site.class);
        siteservice.insertSelective(dmzzmodel);
        siteservice.insertSelective(yszzmodel);
        System.out.println(result);
    }
    
//    @Scheduled(cron = "0/2 * * * * ?")
//    public void test() throws Exception{
//        System.out.println("123");
//    }
}

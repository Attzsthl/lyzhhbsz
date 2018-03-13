package com.szht.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.processors.DefaultValueProcessor;
import net.sf.json.processors.JsonValueProcessor;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;
import com.szht.model.Bc;
import com.szht.model.BcExample;
import com.szht.model.BcSeri;
import com.szht.model.Bcinfo;
import com.szht.model.Jcdm;
import com.szht.model.JcdmExample;
import com.szht.model.Problems;
import com.szht.model.RiverAndBc;
import com.szht.model.Site;
import com.szht.model.SiteExample;
import com.szht.model.User;
import com.szht.model.UserPermission;
import com.szht.model.XAndSeries;
import com.szht.model.Xzdm;
import com.szht.model.XzdmExample;
import com.szht.model.custom.BcCustom;
import com.szht.model.custom.BcinfoCustom;
import com.szht.model.custom.JcdmCustom;
import com.szht.model.custom.SiteCustom;
import com.szht.model.custom.UserCustom;
import com.szht.model.custom.UserPermissionCustom;
import com.szht.model.custom.XzdmCustom;
import com.szht.service.Bcinfoservice;
import com.szht.service.Bcservice;
import com.szht.service.CustomService;
import com.szht.service.Jcdmservice;
import com.szht.service.Problemsservice;
import com.szht.service.Siteservice;
import com.szht.service.Toexampleservice;
import com.szht.service.UserPermissionservice;
import com.szht.service.Userservice;
import com.szht.service.Xzdmservice;
import com.szht.util.Fileutil;
import com.szht.util.MD5;
import com.szht.util.Parmeters;
@Controller
public class Custom {
    @Resource
    private Jcdmservice jcdmservice;
    @Resource
    private Bcservice bcservice;
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
	    jsonConfig.registerDefaultValueProcessor(Double.class,  
	            new DefaultValueProcessor() {  
	                public Object getDefaultValue(Class type) {  
	                    return null;  
	                }  
	            }); 
    }

    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @RequestMapping("aqi24.action")
    public void aqi24(HttpServletRequest request,HttpServletResponse response,SiteCustom example,String type)
    {
    	System.out.println("进入成功");
    	SiteExample siteExample=toexampleservice.sitetoexample(example);
    	siteExample.setOrderByClause("ct desc limit 24");
    	List<Site> site24=siteservice.selectByExample(siteExample);
        ArrayList<BcSeri> series = new ArrayList<BcSeri>();

        BcSeri bs = new BcSeri();
        ArrayList<Double> data = new ArrayList<Double>();
        bs.setData(data);
        if(type.equals("no2")){
            bs.setName(type);
            for(int i=site24.size()-1;i>=0;i--){
                if(site24.get(i).getNo2().equals("_")){
                    data.add(0.0);
                    continue;
                }
                data.add(Double.parseDouble(site24.get(i).getNo2()));
            }
        }

        if(type.equals("AQI")){
            bs.setName(type);
            for(int i=site24.size()-1;i>=0;i--){
                if(site24.get(i).getAqi().equals("_")){
                    data.add(0.0);
                    continue;
                }
                data.add(Double.parseDouble(site24.get(i).getAqi()));
            }
        }

        if(type.equals("co")){
            bs.setName(type);
            for(int i=site24.size()-1;i>=0;i--){
                if(site24.get(i).getCo().equals("_")){
                    data.add(0.0);
                    continue;
                }
                data.add(Double.parseDouble(site24.get(i).getCo()));
            }
        }

        if(type.equals("o3")){
            bs.setName(type);
            for(int i=site24.size()-1;i>=0;i--){
                if(site24.get(i).getO3().equals("_")){
                    data.add(0.0);
                    continue;
                }
                data.add(Double.parseDouble(site24.get(i).getO3()));
            }
        }

        if(type.equals("pm10")){
            bs.setName(type);
            for(int i=site24.size()-1;i>=0;i--){
                if(site24.get(i).getPm10().equals("_")){
                    data.add(0.0);
                    continue;
                }
                data.add(Double.parseDouble(site24.get(i).getPm10()));
            }
        }

        if(type.equals("pm2_5")){
            bs.setName(type);
            for(int i=site24.size()-1;i>=0;i--){
                if(site24.get(i).getPm25().equals("_")){
                    data.add(0.0);
                    continue;
                }
                data.add(Double.parseDouble(site24.get(i).getPm25()));
            }
        }

        if(type.equals("so2")){
            bs.setName(type);
            for(int i=site24.size()-1;i>=0;i--){
                if(site24.get(i).getSo2().equals("_")){
                    data.add(0.0);
                    continue;
                }
                data.add(Double.parseDouble(site24.get(i).getSo2()));
            }
        }

        series.add(bs);
    	
        JSONArray jsonArray=JSONArray.fromObject(series,jsonConfig);
        String json=jsonArray.toString();
        System.out.println(json);
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
    @RequestMapping("site.action")
    public void site(HttpServletRequest request,HttpServletResponse response,SiteCustom example,String type)
    {
    	SiteExample siteExample=toexampleservice.sitetoexample(example);
    	siteExample.setOrderByClause("ct desc limit 24");
    	List<Site> site24=siteservice.selectByExample(siteExample);
        
        JSONArray jsonArray=JSONArray.fromObject(site24.get(0),jsonConfig);
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
    @RequestMapping("x24.action")
    public void x24(HttpServletRequest request,HttpServletResponse response,SiteCustom example,String type)
    {
    	System.out.println("进入成功");
    	SiteExample siteExample=toexampleservice.sitetoexample(example);
    	siteExample.setOrderByClause("ct desc limit 24");
    	List<Site> site24=siteservice.selectByExample(siteExample);
        ArrayList<String> x24 = new ArrayList<String>();

            for(int i=site24.size()-1;i>=0;i--){
                x24.add(site24.get(i).getCt().substring(11,19));
            }
        
        JSONArray jsonArray=JSONArray.fromObject(x24,jsonConfig);
        String json=jsonArray.toString();
        System.out.println(json);
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
    @RequestMapping("bc.action")
    public void bc(HttpServletRequest request,HttpServletResponse response,BcCustom example,String type)
    {
    	System.out.println("进入成功");
    	BcExample bcExample=toexampleservice.bctoexample(example);
    	bcExample.setOrderByClause("month");
    	List<Bc> bcList=bcservice.selectByExample(bcExample);
        ArrayList<BcSeri> series = new ArrayList<BcSeri>();

        BcSeri bsbz = new BcSeri();
        bsbz.setName("鏍囧噯鍊�");
        ArrayList<Double> databz = new ArrayList<Double>();
        bsbz.setData(databz);
        series.add(bsbz);
        for(int i=0;i<12;i++){
            if (type.equals("gmsy"))
            	databz.add(Double.parseDouble("6"));


            if (type.equals("ad"))
            	databz.add(Double.parseDouble("1"));


            if (type.equals("zl"))
            	databz.add(Double.parseDouble("0.2"));
        }
        
        int j = 0;
        for (int i = 0; i < bcList.size() / 12; ++i) {
            int k;
            BcSeri bs = new BcSeri();
            bs.setName(((Bc)bcList.get(j)).getYear().toString());
            ArrayList<Double> data = new ArrayList<Double>();
            bs.setData(data);
            if (type.equals("gmsy"))
                for (k = 0; k < 12; ++k) {
                    data.add(((Bc)bcList.get(j)).getGmsy());
                    ++j;
                }


            if (type.equals("ad"))
                for (k = 0; k < 12; ++k) {
                    data.add(((Bc)bcList.get(j)).getAd());
                    ++j;
                }


            if (type.equals("zl"))
                for (k = 0; k < 12; ++k) {
                    data.add(((Bc)bcList.get(j)).getZl());
                    ++j;
                }


            series.add(bs);
        }

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
    
    @Autowired
    CustomService customService;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @RequestMapping("jcdm.action")
    public void jcdm(HttpServletRequest request,HttpServletResponse response,JcdmCustom example,String type)
    {         	
    	System.out.println("进入成功");
    	XAndSeries xAndSeries=new XAndSeries();
    	xAndSeries.setXaxis(customService.jcdmx(example));
    	BcSeri[] series;
    	if(example.getYear()==0){
    		
    		List<Integer> yearcount=customService.JcdmCountYearByName(example.getDmmc());
    		series = new BcSeri[yearcount.size()];
    		for(int i=0;i<series.length;i++){
    			example.setYear(yearcount.get(i));
    	    	JcdmExample jcdmExample=toexampleservice.jcdmtoexample(example);
    	    	jcdmExample.setOrderByClause("month");
    			List<Jcdm> jcdms=jcdmservice.selectByExample(jcdmExample);
    			series[i]=customService.JcdmBeanToBs(jcdms,type,yearcount.get(i).toString());
    		}
    	}else if(example.getYear()==-1){
    		List<Integer> yearcount=customService.JcdmCountYearByName(example.getDmmc());
    		series = new BcSeri[1];
    		List<Jcdm> jcdms=new ArrayList<Jcdm>();
    		for(int i=0;i<yearcount.size();i++){
    			example.setYear(yearcount.get(i));
    	    	JcdmExample jcdmExample=toexampleservice.jcdmtoexample(example);
    	    	jcdmExample.setOrderByClause("month");
    			jcdms.addAll(jcdmservice.selectByExample(jcdmExample));
    			
    		}
    		series[0]=customService.JcdmBeanToBs(jcdms,type,type);
		} else {
    		series=new BcSeri[1];
	    	JcdmExample jcdmExample=toexampleservice.jcdmtoexample(example);
	    	jcdmExample.setOrderByClause("month");
        	List<Jcdm> jcdms=jcdmservice.selectByExample(jcdmExample);

            series[0]=customService.JcdmBeanToBs(jcdms,type,type);
		}
    	xAndSeries.setSeries(series);
    	
	        JSONArray jsonArray=JSONArray.fromObject(xAndSeries,jsonConfig);
	        String json=jsonArray.toString();
	        System.out.println(json);
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
    
    @Resource
    Xzdmservice xzdmservice;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @RequestMapping("xzdm.action")
    public void xzdm(HttpServletRequest request,HttpServletResponse response,XzdmCustom example,String type)
    {
    	System.out.println("进入成功");
    	XAndSeries xAndSeries=new XAndSeries();    	
    	xAndSeries.setXaxis(customService.xzdmx(example));
    	
    	BcSeri[] bcSeris;
    	if(example.getYear()==0){
    		List<Integer> yearLists=customService.XzdmCountYearByName(example.getDmmc());
    		bcSeris=new BcSeri[yearLists.size()];
    		for(int i=0;i<yearLists.size();i++){
    			example.setYear(yearLists.get(i));
            	XzdmExample xzdmExample= toexampleservice.xzdmtoexample(example);
            	xzdmExample.setOrderByClause("season");
            	List<Xzdm> xzdms=xzdmservice.selectByExample(xzdmExample);
    			
    			bcSeris[i]=customService.XzdmBeanToBs(xzdms, type, type);
    		}
    	}else if(example.getYear()==-1){    		
    		List<Integer> yearLists=customService.XzdmCountYearByName(example.getDmmc());
    		ArrayList<Double> data=new ArrayList<Double>();
    		
    		for(int i=0;i<yearLists.size();i++){
    			example.setYear(yearLists.get(i));
            	XzdmExample xzdmExample= toexampleservice.xzdmtoexample(example);
            	xzdmExample.setOrderByClause("season");
            	List<Xzdm> xzdms=xzdmservice.selectByExample(xzdmExample);
            	
            	data.addAll(customService.XzdmBeanToBs(xzdms, type, type).getData());
    		}
    		bcSeris=new BcSeri[1];

    		BcSeri bcSeri=new BcSeri();
    		if(type.equals("ad")){
    			bcSeri.setName("姘ㄦ爱");
    		}else if(type.equals("zl")){
    			bcSeri.setName("鎬荤７");
			}else if(type.equals("gmsy")){
				bcSeri.setName("楂橀敯閰哥洂鎸囨暟");
			}else if(type.equals("rjy")){
				bcSeri.setName("婧惰В姘�");
			}
    		
    		bcSeri.setData(data);
    		bcSeris[0]=bcSeri;
		}else {
        	XzdmExample xzdmExample= toexampleservice.xzdmtoexample(example);
        	xzdmExample.setOrderByClause("season");
        	List<Xzdm> xzdms=xzdmservice.selectByExample(xzdmExample);
        	
        	bcSeris=new BcSeri[1];
        	bcSeris[0]=customService.XzdmBeanToBs(xzdms, type, type);
		}
    	xAndSeries.setSeries(bcSeris);
        JSONArray jsonArray=JSONArray.fromObject(xAndSeries,jsonConfig);
        String json=jsonArray.toString();
        System.out.println(json);
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
    @Autowired
    Bcinfoservice bcinfoservice;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @RequestMapping("bcinfo.action")
    public void bcinfo(HttpServletRequest request,HttpServletResponse response,BcCustom record)
    {
    	List<RiverAndBc> results=new ArrayList<RiverAndBc>();
    	List<BcinfoCustom> resultsBcinfoCustoms=new ArrayList<BcinfoCustom>();
    	BcinfoCustom bcinfo=new BcinfoCustom();

    	List<String> typeList=Arrays.asList("鍏ュ鏂潰","鍑哄鏂潰");
    	for (int j = 0; j < typeList.size(); j++) {
        	bcinfo.setDmlb(typeList.get(j));
        	List<Bcinfo> outlistList=bcinfoservice.selectByExample(toexampleservice.bcinfotoexample(bcinfo));
        	
        	List<String> dmmcsList=new ArrayList<String>();
         	for (int i = 0; i < outlistList.size(); i++) {
         		dmmcsList.add(outlistList.get(i).getDmmc());
         		record.setDm(outlistList.get(i).getDmmc());
         		BcinfoCustom resultBcinfoCustom=customService.GetBcinfoByName(record);
         		if(resultBcinfoCustom==null)
         			continue;
         		else {
         			resultsBcinfoCustoms.add(customService.GetBcinfoByName(record));
				}
         		
    		}
         	
         	RiverAndBc riverAndBc=new RiverAndBc();
         	riverAndBc.setRiver(typeList.get(j));
         	riverAndBc.setDmmcs(dmmcsList);
         	
         	results.add(riverAndBc);
		}
    	
    	
    	

    	
        JSONArray jsonArray=JSONArray.fromObject(resultsBcinfoCustoms,jsonConfig);
        String json=jsonArray.toString();
        System.out.println(json);
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
    @RequestMapping("getyearandmonth.action")
    public void getyearandmonth(HttpServletRequest request,HttpServletResponse response,String name,String type)
    {
    	List<Integer> years=new ArrayList<Integer>();
    	List<List<Integer>> months=new ArrayList<List<Integer>>();
    	if(type.equals("bc")){
    		years=customService.BcCountYearByName(name);
    		for (int i = 0; i < years.size(); i++) {
    			List<Integer> month=new ArrayList<Integer>();
    			month=customService.BcCountMonthByNameAndYear(name, years.get(i));
    			months.add(month);
			}    		
    	}
    	if(type.equals("jcdm")){
    		years=customService.JcdmCountYearByName(name);
    		for (int i = 0; i < years.size(); i++) {
    			List<Integer> month=new ArrayList<Integer>();
    			month=customService.JcdmCountMonthByNameAndYear(name, years.get(i));
    			months.add(month);
			}    		
    	}
    	if(type.equals("xzdm")){
    		years=customService.XzdmCountYearByName(name);
    		for (int i = 0; i < years.size(); i++) {
    			List<Integer> month=new ArrayList<Integer>();
    			month=customService.XzdmCountSeasonByNameAndYear(name, years.get(i));
    			months.add(month);
			}    		
    	}
    	List<Object> result=new ArrayList<Object>();
    	result.add(years);
    	result.add(months);
        JSONArray jsonArray=JSONArray.fromObject(result,jsonConfig);
        String json=jsonArray.toString();
        System.out.println(json);
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
    
    @Resource
    Problemsservice problemsservice;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @RequestMapping("solveproblems.action")
    public void solveproblems(HttpServletRequest request,HttpServletResponse response,Integer id,String approved)
    {
    	System.out.println(approved);
    	String result="-1";
    	Problems  problems=problemsservice.selectByPrimaryKey(id);
    	if(problems==null){
    		result="0";
    	}
    	else if(problems.getSlovetime()==null){
    		//浠巗hiro鐨剆ession涓彇activeUser
    		Subject subject = SecurityUtils.getSubject();
    		//鍙栬韩浠戒俊鎭�
    		User user = (User) subject.getPrincipal();
    		problems.setStatus("宸插鐞�");
    		problems.setSuggest(approved);
    		problems.setSolver(user.getUsername());
    		problems.setSlovetime(new Date());
    		problemsservice.updateByPrimaryKeySelective(problems);
    		result="1";
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
    @Resource Parmeters parmeters;
    @Resource Fileutil fileutil;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @RequestMapping("getloglist.action")
    public void getloglist(HttpServletRequest request,HttpServletResponse response,String dateString1,String dateString2) throws java.text.ParseException, IOException
    {
    	System.out.println(dateString1+"/"+dateString2);
    	long nowtimeString=0;
		//浠巗hiro鐨剆ession涓彇activeUser
		Subject subject = SecurityUtils.getSubject();
		//鍙栬韩浠戒俊鎭�
		User user = (User) subject.getPrincipal();
    	try
    	{
    	Date date1;
    	Date date2;
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	
    		
    		date1 = sdf.parse(dateString1);
    		date2 = sdf.parse(dateString2);

    	
	        
	        Calendar c = Calendar.getInstance();
	        c.setTime(date1);
	        nowtimeString=new Date().getTime();
	        for(Date now= c.getTime();now.compareTo(date2)<=0;){
	        	String filepath=parmeters.getUrl()+"\\BlogLog\\"+sdf.format(now)+"log.txt";
	        	
	        	System.out.println(nowtimeString+"");
	        	String outpath=parmeters.getUrl()+"\\BlogLog\\out\\"+nowtimeString+user.getUsercode()+"\\"+sdf.format(now)+"log.txt";
	        	System.out.println(outpath);
	            File dir=new File(filepath);
	            if(dir.exists()){
	            	fileutil.copyFile(filepath, outpath);
	            	System.out.println(sdf.format(now)+"log.txt");
	            }
	        	c.add(Calendar.DAY_OF_MONTH, 1);
	        	now= c.getTime();
	        }
	        
	        
	        
	        String sourceFilePath = parmeters.getUrl()+"\\BlogLog\\out\\"+nowtimeString+user.getUsercode();
	        String zipFilePath =parmeters.getUrl()+"\\BlogLog\\out";
	        String fileName = nowtimeString+user.getUsercode();  
	        File file=new File(sourceFilePath);
	        if(file.exists()){	        
		        boolean flag = fileutil.fileToZip(sourceFilePath, zipFilePath, fileName);  
		        if(flag){  
		            System.out.println("鏂囦欢鎵撳寘鎴愬姛!"); 
		            
		    		String result="涓嬭浇鎴愬姛";
	
		            //鑾峰彇杈撳叆娴�  
		            InputStream bis = new BufferedInputStream(new FileInputStream(new File(zipFilePath+"\\"+fileName+".zip")));  
		            //鍋囧浠ヤ腑鏂囧悕涓嬭浇鐨勮瘽  
		            String filename = dateString1+"-"+dateString2+".zip";  
		            //杞爜锛屽厤寰楁枃浠跺悕涓枃涔辩爜  
		            filename = URLEncoder.encode(filename,"UTF-8");
		            //璁剧疆鏂囦欢涓嬭浇澶�  
		            response.addHeader("Content-Disposition", "attachment;filename=" + filename);    
		            //1.璁剧疆鏂囦欢ContentType绫诲瀷锛岃繖鏍疯缃紝浼氳嚜鍔ㄥ垽鏂笅杞芥枃浠剁被鍨�    
		            response.setContentType("multipart/form-data");
		            BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());  
		            int len = 0;  
		            while((len = bis.read()) != -1){  
		                out.write(len);  
		                out.flush();  
		            }  
		            out.close();  
		    	        
	
	
		    		System.out.println(result);    	
		            
		        }else{  
		            System.out.println("鏂囦欢鎵撳寘澶辫触!");  
		            
					try {
						response.setCharacterEncoding("UTF-8");
						response.setContentType("text/json");
						response.getWriter().write("涓嬭浇澶辫触");
						response.getWriter().flush();
						response.getWriter().close();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
		        }
	    	}else {
				try {
					response.setCharacterEncoding("UTF-8");
					response.setContentType("text/json");
					response.getWriter().write("璇ユ湡闂存棤浠讳綍鏃ュ織鏂囦欢锛�");
					response.getWriter().flush();
					response.getWriter().close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
	        
		}
		catch (ParseException e)
		{
			System.out.println(e.getMessage());
		}
         


    	
    }
    @Resource Userservice userservice;
    @Resource MD5 md5;
    @RequiresPermissions("super")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @RequestMapping("chongzhi.action")
    public void chongzhi(HttpServletRequest request,HttpServletResponse response,UserCustom userCustom)
    {  
    	String result="";
    	userCustom.setPassword(md5.md5("123456", "jacksung", 2));
    	userCustom.setPassword2("123456");
    	int resultstring=userservice.updateByPrimaryKeySelective(userCustom);
    	if(resultstring==1){
    		result="閲嶇疆鎴愬姛";
    	}else if(resultstring==0){
    		result="閲嶇疆澶辫触锛屾棤璇ョ敤鎴凤紒";
		}else if(resultstring>1){
			result="鑷村懡閿欒锛岄噸缃鏉¤褰曪紝閲嶇疆id涓�"+userCustom.getId()+";璇峰皢璇d鍛婅瘔绠＄悊浜哄憳锛�";
		}else {
			result="鏈煡閿欒锛�";
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
    @Resource UserPermissionservice userPermissionservice;
    
    @RequiresPermissions("super")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @RequestMapping("newpermission.action")
    public void newpermission(HttpServletRequest request,HttpServletResponse response,String permissions)
    {  
    	String result="鎿嶄綔澶辫触";
    	String[] permissionlist= permissions.split("-");
    	UserPermissionCustom userPermissionCustom=new UserPermissionCustom();
    	userPermissionCustom.setUsercode(permissionlist[0]);
    	
    	/*****************************************/
    	userPermissionCustom.setPermission("super");
    	List<UserPermission> selectuserpermissiomList= userPermissionservice.selectByExample(toexampleservice.userPermissiontoexample(userPermissionCustom));
    	if(permissionlist[1].equals("super")&&selectuserpermissiomList.size()<1){
    		userPermissionservice.insertSelective(userPermissionCustom);        	
    	}else if(selectuserpermissiomList.size()>0){
    		userPermissionservice.deleteByExample(toexampleservice.userPermissiontoexample(userPermissionCustom));
		}
    	
    	/*****************************************/

//    	userPermissionservice.deleteByExample(toexampleservice.userPermissiontoexample(userPermissionCustom));
//    	for(int i=1;i<permissionlist.length;i++){
//    		userPermissionCustom.setPermission(permissionlist[i]);
//    		userPermissionservice.insertSelective(userPermissionCustom);
//    	}
    	/******************************/
    	result="鎿嶄綔鎴愬姛";
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
    
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @RequestMapping("download.action")
    public void download(HttpServletRequest request,HttpServletResponse response,String filepath) throws IOException
    {  
    	filepath = new String(filepath.getBytes("iso8859-1"), "utf-8");
        //鑾峰彇杈撳叆娴�  
        InputStream bis = new BufferedInputStream(new FileInputStream(new File(parmeters.getUrl()+"\\ModelDownload\\"+filepath)));  
        //鍋囧浠ヤ腑鏂囧悕涓嬭浇鐨勮瘽  
        String filename = filepath;  
        //杞爜锛屽厤寰楁枃浠跺悕涓枃涔辩爜  
        filename = URLEncoder.encode(filename,"UTF-8");
        //璁剧疆鏂囦欢涓嬭浇澶�  
        response.addHeader("Content-Disposition", "attachment;filename=" + filename);    
        //1.璁剧疆鏂囦欢ContentType绫诲瀷锛岃繖鏍疯缃紝浼氳嚜鍔ㄥ垽鏂笅杞芥枃浠剁被鍨�    
        response.setContentType("multipart/form-data");   
        BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());  
        int len = 0;  
        while((len = bis.read()) != -1){  
            out.write(len);  
            out.flush();  
        }  
        out.close(); 
    	
    }

}

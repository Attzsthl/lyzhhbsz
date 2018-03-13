package com.szht.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.szht.dao.CustomMapper;
import com.szht.model.Bc;
import com.szht.model.BcExample;
import com.szht.model.Jcdm;
import com.szht.model.JcdmExample;
import com.szht.model.custom.BcCustom;
import com.szht.model.custom.JcdmCustom;
import com.szht.model.custom.XzdmCustom;
import com.szht.service.Bcservice;
import com.szht.service.Jcdmservice;
import com.szht.service.Toexampleservice;
import com.szht.service.Xzdmservice;
import com.szht.service.impl.ExcelUtil;
import com.szht.util.Parmeters;

@Controller
public class PoiController {
	@Resource
	Parmeters parmeters;
	@Resource
	public ExcelUtil excelUtil;
 	@RequestMapping("outputbc.action")  
 	//public void down() throws Exception{  
    public void outputbc(HttpServletRequest request,HttpServletResponse response,String arrays) throws Exception{  
 		
 		System.out.println(arrays);
 		ArrayList<ArrayList<Object>> inresult=new ArrayList<>();
 		String[] arrayStrings=arrays.split("!@#");
 		String pathString=parmeters.getUrl()+"\\"+arrayStrings[0]+".xlsx";
 		for (int i = 0; i < arrayStrings.length; i++) { 		
 			arrayStrings[i]=arrayStrings[i].replaceAll("</font>", "")
 				.replaceAll("<td align=\"right\">", "")
 				.replaceAll("<font style=\"color: #007EAD;\">", "")
 				.replaceAll("<font style=\"color: #339933;\">", "")
 				.replaceAll("<img style=\"width: 15px;\" src=\"images/uparrow.png\">", "↑")
 				.replaceAll("<font style=\"color: red;\">", "red")
 				.replaceAll("<font style=\"color: green;\">", "green");
 			
 			Object[] cell=arrayStrings[i].split("</td>"); 			
 			ArrayList<Object> result0 = new ArrayList<>(Arrays.asList(cell));
 			inresult.add(result0);
		}

 		
 		excelUtil.writeExcel(inresult, pathString);
 		
		String result="下载成功";

        //获取输入流  
        InputStream bis = new BufferedInputStream(new FileInputStream(new File(pathString)));  
        //假如以中文名下载的话  
        String filename = arrayStrings[0]+".xlsx";  
        //转码，免得文件名中文乱码  
        filename = URLEncoder.encode(filename,"UTF-8");
        //设置文件下载头  
        response.addHeader("Content-Disposition", "attachment;filename=" + filename);    
        //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型    
        response.setContentType("multipart/form-data");   
        BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());  
        int len = 0;  
        while((len = bis.read()) != -1){  
            out.write(len);  
            out.flush();  
        }  
        out.close();  
	        


		System.out.println(result);
    }
 	@Resource
 	com.szht.util.Log log;
 	@Resource
 	Toexampleservice toexampleservice;
 	@Resource
 	public Bcservice bcservice;
 	@Resource
 	public Xzdmservice xzdmservice;
 	@Resource
 	public CustomMapper customMapper;
 	@Resource
 	public Jcdmservice jcdmservice;
 	@RequestMapping("inputbc.action")  
 	//public String inputbc(HttpServletRequest request,HttpServletResponse response) throws IOException{ 
	public String inputbc(HttpServletResponse response,@RequestParam("file") MultipartFile file,HttpServletRequest request,Model model) throws IOException{ 
 		String uninput="";
 		String result="";
 		try{			
        String path = parmeters.getUrl();   
        String fileName = new Date().getTime()+"-"+new Random().nextInt(100)+file.getOriginalFilename();    
        File dir = new File(path,fileName);  
        if(!dir.exists()){  
            dir.mkdirs();  
        }  
        //MultipartFile自带的解析方法  
        file.transferTo(dir);  
		result="导入成功！";
		
 		
 		List<String> dmlist=customMapper.GetDmmcList();
 		for (int j = 0; j < dmlist.size(); j++) {
 			ArrayList<ArrayList<Object>> readresult= excelUtil.readExcel(new File(path+"\\"+fileName),dmlist.get(j));
 	 		Integer year=-1;
 	 		
 	 		for (int i = 2; i < readresult.size(); i++) {
 	 			if((i-2)%16<12){
 	 				if((i-2)%16==0){
 	 					if(readresult.get(i).get(0).equals(""))
 	 						break;
 	 					System.out.println(j+","+i+","+readresult.get(j).get(0));
 	 					year=Double.valueOf((String)readresult.get(i).get(0)).intValue();
 	 				}
 	 	 	 		Bc bc=new Bc();

 	 	 	 		bc.setDm(dmlist.get(j));
 	 	 	 		bc.setYear(year);
 	 	 	 		bc.setMonth(Double.valueOf((String)readresult.get(i).get(1)).intValue());
 	 	 	 		
 	 	 	 		BcCustom bcCustom=new BcCustom();

	 	 	 	 	bcCustom.setDm(dmlist.get(j));
	 	 	 	 	bcCustom.setYear(year);
	 	 	 	 	bcCustom.setMonth(Double.valueOf((String)readresult.get(i).get(1)).intValue());
 	 	 	 		
 	 	 	 		BcExample bcExample=toexampleservice.bctoexample(bcCustom);
 	 	 	 		int count=bcservice.countByExample(bcExample);
 	 	 	 		
 	 	 	 		bc.setGmsy(Double.valueOf((String)readresult.get(i).get(2)));
 	 	 	 		bc.setAd(Double.valueOf((String)readresult.get(i).get(3)));
 	 	 	 		bc.setZl(Double.valueOf((String)readresult.get(i).get(4)));
 	 	 	 		if(count!=0){
 	 	 	 			String problem="导入excel中"+dmlist.get(j)+" 第"+(i+1)+"行数据已经存在，未导入！\n";
 	 	 	 			log.writelog("区域补偿导入","bc表格",problem);
 	 	 	 			uninput+=problem;
 	 	 	 			//bcservice.updateByExampleSelective(bc, bcExample);
 	 	 	 		}else {

 	 	 	 			bcservice.insertSelective(bc);
 	 	 	 			String problem="表单"+dmlist.get(j)+"中,第"+(i+1)+"行数据导入成功！\n";
 	 	 	 			log.writelog("区域补偿导入","bc表格",problem);
					}
 	 	 	 		
 	 			}else {
					continue;
				}

 			}

		}
 		}
		catch (Exception e) {
			System.out.println(e);
			result="导入失败";
		}
 		if(uninput!=""){
 			result="有部分数据已经存在，该部分数据未导入。具体列表见console（控制台）。";
 		}
		model.addAttribute("result", result);
		model.addAttribute("uninput", uninput);
		System.out.println(uninput);
		return "WEB-INF/jsp/BcList.jsp";
 	}
 	@RequestMapping("inputjcdm.action")  
 	//public String inputbc(HttpServletRequest request,HttpServletResponse response) throws IOException{ 
	public String inputjcdm(HttpServletResponse response,@RequestParam("file") MultipartFile file,HttpServletRequest request,Model model) throws IOException{ 
 		String uninput="";
 		String result="";
 		try{			
	        String path = parmeters.getUrl();   
	        String fileName = new Date().getTime()+"-"+new Random().nextInt(100)+file.getOriginalFilename();    
	        File dir = new File(path,fileName);  
	        if(!dir.exists()){  
	            dir.mkdirs();  
	        }  
	        //MultipartFile自带的解析方法  
	        file.transferTo(dir);  
			result="导入成功！";
			
	 		
	 		
	 		ArrayList<ArrayList<Object>> alltables=excelUtil.readExcel(new File(path+"\\"+fileName), "河流报表");
	 		for (int i = 2; i < alltables.size(); i++) { 	
	 			JcdmCustom jcdmCustom=new JcdmCustom();
	 			
	 			jcdmCustom.setDmmc(alltables.get(i).get(8).toString());
	 			jcdmCustom.setYear(Double.valueOf((String)alltables.get(i).get(4)).intValue());
	 			jcdmCustom.setMonth(Double.valueOf((String)alltables.get(i).get(12)).intValue()); 			
	 			
	 			JcdmExample jcdmExample=toexampleservice.jcdmtoexample(jcdmCustom);
	 			int count=jcdmservice.countByExample(jcdmExample);
	 			
	 			Integer date=Double.valueOf((String)alltables.get(i).get(13)).intValue();
	 			jcdmCustom.setDate(date.toString());
	 			jcdmCustom.setHlmc(alltables.get(i).get(6).toString());
	 			
	 			
	 			jcdmCustom.setGmsy(alltables.get(i).get(22).toString());
	 			jcdmCustom.setAndan(alltables.get(i).get(24).toString());
	 			jcdmCustom.setZongling(alltables.get(i).get(31).toString());
	 			
	 			
	 			jcdmCustom.setDiandaolv(alltables.get(i).get(20).toString());			
	 			jcdmCustom.setFlza(alltables.get(i).get(53).toString());
	 			jcdmCustom.setFuhuawu(alltables.get(i).get(34).toString());
	 			jcdmCustom.setGe(alltables.get(i).get(37).toString());
	 			jcdmCustom.setGong(alltables.get(i).get(27).toString());
	
	 			jcdmCustom.setHuifafen(alltables.get(i).get(26).toString());
	 			jcdmCustom.setHxxyl(alltables.get(i).get(29).toString());	
	 			jcdmCustom.setLiuhuawu(alltables.get(i).get(41).toString());
	 			jcdmCustom.setLiujiage(alltables.get(i).get(38).toString());
	 			jcdmCustom.setLiuliang(alltables.get(i).get(17).toString().split("/")[1]);
	 			
	 			jcdmCustom.setLiusuanyan(alltables.get(i).get(43).toString());
	 			jcdmCustom.setLvhuawu(alltables.get(i).get(44).toString());
	 			jcdmCustom.setPh(alltables.get(i).get(19).toString());
	 			jcdmCustom.setQian(alltables.get(i).get(28).toString());
	 			jcdmCustom.setRongjieyanng(alltables.get(i).get(21).toString());
	 			
	 			jcdmCustom.setShen(alltables.get(i).get(36).toString());
	 			jcdmCustom.setShiyoulei(alltables.get(i).get(25).toString());
	 			jcdmCustom.setShuishen(alltables.get(i).get(17).toString().split("/")[0]);
	 			jcdmCustom.setShuiweng(alltables.get(i).get(16).toString());
	 			jcdmCustom.setShxyl(alltables.get(i).get(23).toString());
	 			
	 			jcdmCustom.setSqdm(alltables.get(i).get(11).toString());
	 			jcdmCustom.setXi(alltables.get(i).get(35).toString());
	 			jcdmCustom.setXiaosuanyan(alltables.get(i).get(45).toString());
	 			jcdmCustom.setXuanfuwu(alltables.get(i).get(50).toString());
	 			jcdmCustom.setYxsy(alltables.get(i).get(52).toString());
	 			
	 			jcdmCustom.setZjhw(alltables.get(i).get(39).toString());
	 			jcdmCustom.setZongdan(alltables.get(i).get(30).toString()); 			
	 			jcdmCustom.setZongyingdu(alltables.get(i).get(51).toString());
	 		
	 			if(count==0){
	 				jcdmservice.insertSelective(jcdmCustom);
	 				String problem="监测站："+jcdmCustom.getDmmc()+" "+jcdmCustom.getYear()+"年"+jcdmCustom.getMonth()+"月数据导入成功\n";
	 				log.writelog("例行监测导入","jcdm表格",problem);
	 			}else {
					//jcdmservice.updateByExampleSelective(jcdmCustom, jcdmExample);
	 				String problem="监测站："+jcdmCustom.getDmmc()+" "+jcdmCustom.getYear()+"年"+jcdmCustom.getMonth()+"月数据已经存在，未导入\n";
	 				log.writelog("例行监测导入","jcdm表格",problem);
	 				uninput+=problem;
	 				
				}
	 		}
 		}
		catch (Exception e) {
			System.out.println(e);
			result="导入失败";
		}
 		if(uninput!=""){
 			result="有部分数据已经存在，进行了更新。具体列表见console（控制台）。";
 		}
		model.addAttribute("result", result);
		model.addAttribute("uninput", uninput);
		System.out.println(uninput);
		return "WEB-INF/jsp/JcdmList.jsp";
 	}
 	@RequestMapping("inputxzdm.action")  
 	//public String inputxzdm(HttpServletRequest request,HttpServletResponse response) throws IOException{ 
	public String inputxzdm(HttpServletResponse response,@RequestParam("file") MultipartFile file,HttpServletRequest request,Model model) throws IOException{ 
 		String uninput="";
 		String result="";
 		try{			
	        String path = parmeters.getUrl();   
	        String fileName = new Date().getTime()+"-"+new Random().nextInt(100)+file.getOriginalFilename();    
	        File dir = new File(path,fileName);  
	        if(!dir.exists()){  
	            dir.mkdirs();  
	        }  
	        //MultipartFile自带的解析方法  
	        file.transferTo(dir);  
			result="导入成功！";
			
	 		
	 		
	 		ArrayList<ArrayList<Object>> alltables=excelUtil.readExcel(new File(path+"\\"+fileName), "Sheet1");
	 		for (int i = 2; i < alltables.size(); i++) { 	
	 			XzdmCustom xzdmCustom=new XzdmCustom();	 			
	 			
	 			xzdmCustom.setDmmc(alltables.get(i).get(2).toString());
	 			xzdmCustom.setYear(Double.valueOf((String)alltables.get(i).get(9)).intValue());
	 			xzdmCustom.setSeason(Double.valueOf((String)alltables.get(i).get(10)).intValue());
	 			int count=xzdmservice.countByExample(toexampleservice.xzdmtoexample(xzdmCustom));
	 			
	 			xzdmCustom.setAd(Double.valueOf((String)alltables.get(i).get(3)));
	 			xzdmCustom.setZl(Double.valueOf((String)alltables.get(i).get(4)));
	 			xzdmCustom.setGmsy(Double.valueOf((String)alltables.get(i).get(5)));
	 			xzdmCustom.setRjy(Double.valueOf((String)alltables.get(i).get(6)));
	 			
	 			xzdmCustom.setHlmc(alltables.get(i).get(1).toString());
	 			xzdmCustom.setZhenqu(alltables.get(i).get(0).toString());
	 			xzdmCustom.setDabiao(alltables.get(i).get(7).toString());
	 			
	 			if(count==0){
	 				xzdmservice.insertSelective(xzdmCustom);
	 				String problem="镇区断面："+xzdmCustom.getDmmc()+" "+xzdmCustom.getYear()+"年"+xzdmCustom.getSeason()+"季度数据导入成功\n";
	 				log.writelog("镇区断面监测数据导入","zxdm表格",problem);
	 			}else {
					//xzdmservice.updateByExampleSelective(jcdmCustom, jcdmExample);
	 				String problem="镇区断面："+xzdmCustom.getDmmc()+" "+xzdmCustom.getYear()+"年"+xzdmCustom.getSeason()+"季度数据已经存在，未导入\n";
	 				log.writelog("镇区断面监测数据导入","xzdm表格",problem);
	 				uninput+=problem;
	 				
				}
	 		}
 		}
		catch (Exception e) {
			System.out.println(e);
			result="导入失败";
		}
 		if(uninput!=""){
 			result="有部分数据已经存在，进行了更新。具体列表见console（控制台）。";
 		}
		model.addAttribute("result", result);
		model.addAttribute("uninput", uninput);
		System.out.println(uninput);
		return "WEB-INF/jsp/XzdmList.jsp";
 	}
}

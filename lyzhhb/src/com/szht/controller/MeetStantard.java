package com.szht.controller;

import java.text.DecimalFormat;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.szht.model.Jcdm;
import com.szht.model.custom.JcdmCustom;
import com.szht.service.Jcdmservice;
import com.szht.service.Toexampleservice;

@Controller
public class MeetStantard {
	@Resource
	Jcdmservice jcdmservice;
	@Resource
	Toexampleservice toexampleservice;
	@RequestMapping("rivermean.action")
	public void name(HttpServletRequest request,HttpServletResponse response, JcdmCustom record) {
		List<Jcdm> results=jcdmservice.selectByExample(toexampleservice.jcdmtoexample(record));
		double[] hxxyl=new double[6];
		double[] andan=new double[6];
		double[] shiyoulei=new double[6];
		for(int i=0;i<results.size();i++){
			Jcdm result=results.get(i);
			if(result.getYear().equals("2010")){
				hxxyl[0]+=Double.valueOf(result.getHxxyl());
				andan[0]+=Double.valueOf(result.getAndan());
				shiyoulei[0]+=Double.valueOf(result.getShiyoulei());
			}
			if(result.getYear().equals("2011")){
				hxxyl[1]+=Double.valueOf(result.getHxxyl());
				andan[1]+=Double.valueOf(result.getAndan());
				shiyoulei[1]+=Double.valueOf(result.getShiyoulei());
			}
			if(result.getYear().equals("2012")){
				hxxyl[2]+=Double.valueOf(result.getHxxyl());
				andan[2]+=Double.valueOf(result.getAndan());
				shiyoulei[2]+=Double.valueOf(result.getShiyoulei());
			}
			if(result.getYear().equals("2013")){
				hxxyl[3]+=Double.valueOf(result.getHxxyl());
				andan[3]+=Double.valueOf(result.getAndan());
				shiyoulei[3]+=Double.valueOf(result.getShiyoulei());
			}
			if(result.getYear().equals("2014")){
				hxxyl[4]+=Double.valueOf(result.getHxxyl());
				andan[4]+=Double.valueOf(result.getAndan());
				shiyoulei[4]+=Double.valueOf(result.getShiyoulei());
			}
			if(result.getYear().equals("2015")){
				hxxyl[5]+=Double.valueOf(result.getHxxyl());
				andan[5]+=Double.valueOf(result.getAndan());
				shiyoulei[5]+=Double.valueOf(result.getShiyoulei());
			}
		}
		System.out.println(hxxyl.toString());
		
		
        DecimalFormat df = new DecimalFormat("#.00");  

		String resultsString="[";
		for(int i=0;i<6;i++){
			hxxyl[i]/=results.size();
			andan[i]/=results.size();
			shiyoulei[i]/=results.size();
			resultsString+="{";
			resultsString+="\"hxxyl\":\""+df.format(hxxyl[i])+"\",";
			resultsString+="\"andan\":\""+df.format(andan[i])+"\",";
			resultsString+="\"shiyoulei\":\""+df.format(shiyoulei[i])+"\",";
			resultsString=resultsString.substring(0,resultsString.length()- 1);
			resultsString+="},";
		}	
		resultsString=resultsString.substring(0,resultsString.length()- 1);
		resultsString+="]";
		System.out.println(resultsString);
		try {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/json");
			response.getWriter().write(resultsString);
			response.getWriter().flush();
			response.getWriter().close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}

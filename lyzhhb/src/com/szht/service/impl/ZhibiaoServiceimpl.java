package com.szht.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.szht.model.Bc;
import com.szht.service.Bcinfoservice;
import com.szht.service.Toexampleservice;
import com.szht.service.ZhibiaoService;
@Service
public class ZhibiaoServiceimpl implements ZhibiaoService {
	//		高锰酸盐、氨氮、总磷
	//一类 	2		0.15	0.02
	//二类 	4		0.5		0.1
	//三类 	6		1		0.2
	//四类 	10		1.5		0.3
	//五类 	15		2		0.4
	@Autowired
	Bcinfoservice bcinfoservice;
	@Autowired
	Toexampleservice toexampleservice;
	@Override
	public String BcDabiao(Bc bc,Integer mubiao) {
		List<Double> gmsy=Arrays.asList(0.0,2.0,4.0,6.0,10.0,15.0);
		Integer gmsyInteger=shuizhi(bc.getGmsy(),gmsy);
		List<Double> ad=Arrays.asList(0.0,0.15,0.5,1.0,1.5,2.0);
		Integer adiInteger=shuizhi(bc.getAd(),ad);
		List<Double> zl=Arrays.asList(0.0,0.02,0.1,0.2,0.3,0.4);
		Integer zlInteger=shuizhi(bc.getZl(),zl);
		Integer resultDouble=biggerone(biggerone(gmsyInteger, adiInteger), zlInteger);
		String resultString=shuizhiinttostring(resultDouble);
		if(mubiao>=resultDouble){
			resultString+="-达标";
		}else {
			resultString+="-不达标";
		}
		resultString+="-"+resultDouble;
		return resultString;
	}
	@Override
	public String shuizhiinttostring(Integer a) {
		String resultString="未计量";
		switch (a) {
		case 1:
			resultString="I类水";
			break;
		case 2:
			resultString="II类水";
			break;
		case 3:
			resultString="III类水";
			break;
		case 4:
			resultString="IV类水";
			break;
		case 5:
			resultString="V类水";
			break;
		case 6:
			resultString="劣V类水";
			break;
		}
		return resultString;
	}
	
	public Integer shuizhi(Double testDouble,List<Double> numlist) {
		Integer result=6;
		for (int i = 0; i < numlist.size()-1; i++) {
	        if(isin(testDouble, numlist.get(i), numlist.get(i+1))){
	        	result=i+1;
	        	break;
	        }
		}
		return result;
	}
	public Boolean isin(Double test,Double a,Double b) {
		if(a<test&&test<b||a==test||b==test){
			return true;
		}else {
			return false;
		}
	}
	public Integer biggerone(Integer a,Integer b) {
		if(a>b){
			return a;
		}else {
			return b;
		}
		
	}

}

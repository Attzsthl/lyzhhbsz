package com.szht.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.szht.dao.CustomMapper;
import com.szht.model.Bc;
import com.szht.model.BcSeri;
import com.szht.model.Bcinfo;
import com.szht.model.Bctbhb;
import com.szht.model.Jcdm;
import com.szht.model.Xzdm;
import com.szht.model.custom.BcCustom;
import com.szht.model.custom.BcinfoCustom;
import com.szht.model.custom.BctbhbCustom;
import com.szht.model.custom.JcdmCustom;
import com.szht.model.custom.XzdmCustom;
import com.szht.service.Bcinfoservice;
import com.szht.service.Bcservice;
import com.szht.service.Bctbhbservice;
import com.szht.service.CustomService;
import com.szht.service.Toexampleservice;
import com.szht.service.ZhibiaoService;
@Service
public class CustomServiceImpl implements CustomService{
	@Autowired
	CustomMapper customMapper;

	@Override
	public BcSeri JcdmBeanToBs(List<Jcdm> jcdms,String type,String name){
        BcSeri bs = new BcSeri();
        bs.setName(name);
        ArrayList<Double> data = new ArrayList<Double>();

        if(type.equals("水温"))
        for(int i=0;i<jcdms.size();i++){
            data.add(Double.parseDouble(jcdms.get(i).getShuiweng()));
            }
        if(type.equals("水深"))
            for(int i=0;i<jcdms.size();i++){
                data.add(Double.parseDouble(jcdms.get(i).getShuishen()));
            }
        if(type.equals("流量"))
            for(int i=0;i<jcdms.size();i++){
                data.add(Double.parseDouble(jcdms.get(i).getLiuliang()));
            }
        if(type.equals("pH"))
            for(int i=0;i<jcdms.size();i++){
                data.add(Double.parseDouble(jcdms.get(i).getPh()));
            }
        if(type.equals("电导率"))
            for(int i=0;i<jcdms.size();i++){
                data.add(Double.parseDouble(jcdms.get(i).getDiandaolv()));
            }
        if(type.equals("溶解氧"))
            for(int i=0;i<jcdms.size();i++){
                data.add(Double.parseDouble(jcdms.get(i).getRongjieyanng()));
            }
        if(type.equals("高锰酸盐指数"))
            for(int i=0;i<jcdms.size();i++){
                data.add(Double.parseDouble(jcdms.get(i).getGmsy()));
            }
        if(type.equals("生化需氧量"))
            for(int i=0;i<jcdms.size();i++){
                data.add(Double.parseDouble(jcdms.get(i).getShxyl()));
            }
        if(type.equals("氨氮"))
            for(int i=0;i<jcdms.size();i++){
                data.add(Double.parseDouble(jcdms.get(i).getAndan()));
            }
        if(type.equals("石油类"))
            for(int i=0;i<jcdms.size();i++){
                data.add(Double.parseDouble(jcdms.get(i).getShiyoulei()));
            }
        if(type.equals("挥发酚"))
            for(int i=0;i<jcdms.size();i++){
                data.add(Double.parseDouble(jcdms.get(i).getHuifafen()));
            }
        if(type.equals("铅"))
            for(int i=0;i<jcdms.size();i++){
                data.add(Double.parseDouble(jcdms.get(i).getQian()));
            }
        if(type.equals("化学需氧量"))
            for(int i=0;i<jcdms.size();i++){
                data.add(Double.parseDouble(jcdms.get(i).getHxxyl()));
            }
        if(type.equals("总氮"))
            for(int i=0;i<jcdms.size();i++){
                data.add(Double.parseDouble(jcdms.get(i).getZongdan()));
            }
        if(type.equals("总磷"))
            for(int i=0;i<jcdms.size();i++){
                data.add(Double.parseDouble(jcdms.get(i).getZongling()));
            }
        if(type.equals("氟化物"))
            for(int i=0;i<jcdms.size();i++){
                data.add(Double.parseDouble(jcdms.get(i).getFuhuawu()));
            }
        if(type.equals("硒"))
            for(int i=0;i<jcdms.size();i++){
                data.add(Double.parseDouble(jcdms.get(i).getXi()));
            }
        if(type.equals("砷"))
            for(int i=0;i<jcdms.size();i++){
                data.add(Double.parseDouble(jcdms.get(i).getShen()));
            }
        if(type.equals("镉"))
            for(int i=0;i<jcdms.size();i++){
                data.add(Double.parseDouble(jcdms.get(i).getGe()));
            }
        if(type.equals("六价铬"))
            for(int i=0;i<jcdms.size();i++){
                data.add(Double.parseDouble(jcdms.get(i).getLiujiage()));
            }
        if(type.equals("总氰化物"))
            for(int i=0;i<jcdms.size();i++){
                data.add(Double.parseDouble(jcdms.get(i).getZjhw()));
            }
        if(type.equals("硫化物"))
            for(int i=0;i<jcdms.size();i++){
                data.add(Double.parseDouble(jcdms.get(i).getLiuhuawu()));
            }
        if(type.equals("硫酸盐"))
            for(int i=0;i<jcdms.size();i++){
                data.add(Double.parseDouble(jcdms.get(i).getLiusuanyan()));
            }
        if(type.equals("氯化物"))
            for(int i=0;i<jcdms.size();i++){
                data.add(Double.parseDouble(jcdms.get(i).getLvhuawu()));
            }
        if(type.equals("硝酸盐"))
            for(int i=0;i<jcdms.size();i++){
                data.add(Double.parseDouble(jcdms.get(i).getXiaosuanyan()));
            }
        if(type.equals("悬浮物"))
            for(int i=0;i<jcdms.size();i++){
                data.add(Double.parseDouble(jcdms.get(i).getXuanfuwu()));
            }
        if(type.equals("总硬度"))
            for(int i=0;i<jcdms.size();i++){
                data.add(Double.parseDouble(jcdms.get(i).getZongyingdu()));
            }
        if(type.equals("亚硝酸盐"))
            for(int i=0;i<jcdms.size();i++){
                data.add(Double.parseDouble(jcdms.get(i).getYxsy()));
            }
        if(type.equals("非离子氨"))
            for(int i=0;i<jcdms.size();i++){
                data.add(Double.parseDouble(jcdms.get(i).getFlza()));
            }
        bs.setData(data);
        return bs;
	}

	@Override
	public List<Integer> JcdmCountYearByName(String dmmc) {
		return customMapper.JcdmCountYearByName(dmmc);
	}

	@Override
	public List<Integer> JcdmCountMonthByNameAndYear(String dmmc,Integer year) {
		return customMapper.JcdmCountMonthByNameAndYear(dmmc,year);
	}

	@Override
	public BcSeri XzdmBeanToBs(List<Xzdm> xzdms,String type,String name) {

		ArrayList<Double> data=new ArrayList<Double>();
        if(type.equals("ad")){
            for(int i=0;i<xzdms.size();i++){      
            	data.add(xzdms.get(i).getAd());
            }
        }
        else if(type.equals("zl")){
            for(int i=0;i<xzdms.size();i++){
            	data.add(xzdms.get(i).getZl());
            }
        }
        else if(type.equals("gmsy")){
	        for(int i=0;i<xzdms.size();i++){
	        	data.add(xzdms.get(i).getGmsy());
	        }
        }
        else if(type.equals("rjy")){
	        for(int i=0;i<xzdms.size();i++){
	        	data.add(xzdms.get(i).getRjy());
	        }
        }
        BcSeri bcSeri=new BcSeri();
        bcSeri.setData(data);
        if(name=="rjy")        	
        	bcSeri.setName("溶解氧");
        if(name=="gmsy")        	
        	bcSeri.setName("高锰酸盐");
        if(name=="ad")        	
        	bcSeri.setName("氨氮");
        return bcSeri;
	}

	@Override
	public ArrayList<String> jcdmx(JcdmCustom example) {
		ArrayList<String> monthsLists=new ArrayList<String>();
        if(example.getYear()==0){
//        	List<Integer> yearsList=customService.CountYearByName(example.getDmmc());
//        	
//        	List<List<Integer>> monthsLists=new ArrayList<List<Integer>>();
//        	for(int i=0;i<yearsList.size();i++){
//        		monthsLists.add(
//        				customService.CountMonthByNameAndYear(
//        						example.getDmmc(),yearsList.get(i)
//        						)
//        						);
//        	}
        	for(int i=1;i<=12;i++){
        		monthsLists.add(i+"月");
        	}
        }else if(example.getYear()==-1){
        	
        	List<Integer> yearsList=JcdmCountYearByName(example.getDmmc());
        	
        	List<List<Integer>> monthsList=new ArrayList<List<Integer>>();
        	for(int i=0;i<yearsList.size();i++){
        		monthsList.add(
        				JcdmCountMonthByNameAndYear(
        						example.getDmmc(),yearsList.get(i)
        						)
        						);
        	}
        	for(int i=0;i<monthsList.size();i++){
            	for(int j=0;j<monthsList.get(i).size();j++){
            		monthsLists.add(yearsList.get(i)+"年"+monthsList.get(i).get(j)+"月");
            	}
        	}
		} else {
			
        	List<Integer> intmonths=JcdmCountMonthByNameAndYear(example.getDmmc(),example.getYear());
        	for(int i=0;i<intmonths.size();i++){
        		monthsLists.add(intmonths.get(i)+"月");
        	}
		}
        
        return monthsLists;

	}

	@Override
	public ArrayList<String> xzdmx(XzdmCustom example) {
		ArrayList<String> monthsLists=new ArrayList<String>();
        if(example.getYear()==0){
//        	List<Integer> yearsList=customService.CountYearByName(example.getDmmc());
//        	
//        	List<List<Integer>> monthsLists=new ArrayList<List<Integer>>();
//        	for(int i=0;i<yearsList.size();i++){
//        		monthsLists.add(
//        				customService.CountMonthByNameAndYear(
//        						example.getDmmc(),yearsList.get(i)
//        						)
//        						);
//        	}
        	for(int i=1;i<=12;i++){
        		monthsLists.add(i+"月");
        	}
        }else if(example.getYear()==-1){
        	
        	List<Integer> yearsList=XzdmCountYearByName(example.getDmmc());
        	
        	List<List<Integer>> monthsList=new ArrayList<List<Integer>>();
        	for(int i=0;i<yearsList.size();i++){
        		monthsList.add(
        				XzdmCountSeasonByNameAndYear(
        						example.getDmmc(),yearsList.get(i)
        						)
        						);
        	}
        	for(int i=0;i<monthsList.size();i++){
            	for(int j=0;j<monthsList.get(i).size();j++){
            		monthsLists.add(yearsList.get(i)+"年第"+monthsList.get(i).get(j)+"季度");
            	}
        	}
		} else {
			
        	List<Integer> intmonths=XzdmCountSeasonByNameAndYear(example.getDmmc(),example.getYear());
        	for(int i=0;i<intmonths.size();i++){
        		monthsLists.add(intmonths.get(i)+"季度");
        	}
		}
        
        return monthsLists;

	}

	@Override
	public List<Integer> XzdmCountYearByName(String dmmc) {
		return customMapper.XzdmCountYearByName(dmmc);
	}

	@Override
	public List<Integer> XzdmCountSeasonByNameAndYear(String dmmc, Integer year) {
		return customMapper.XzdmCountSeasonByNameAndYear(dmmc, year);
	}
	@Autowired
	Toexampleservice toexampleservice;
    @Autowired
    Bctbhbservice bctbhbservice;
    @Autowired
    Bcinfoservice bcinfoservice;
    @Autowired
    ZhibiaoService zhibiaoService;
    @Autowired
    Bcservice bcservice;
	@Override
	public BcinfoCustom GetBcinfoByName(BcCustom record) {
		
    	BctbhbCustom bctbhbCustom=new BctbhbCustom();
    	bctbhbCustom.setDmmc(record.getDm());
    	bctbhbCustom.setYear(record.getYear());
    	bctbhbCustom.setMonth(record.getMonth());
    	List<Bctbhb> bctbhbs=bctbhbservice.selectByExample(toexampleservice.bctbhbtoexample(bctbhbCustom));
    	if(bctbhbs.size()==0)
    		return null;
    	else {
    		Bctbhb bctbhb=bctbhbs.get(0);
        	BcinfoCustom bcinfoCustom=new BcinfoCustom();
        	bcinfoCustom.setDmmc(record.getDm());
        	Bcinfo bcinfo=bcinfoservice.selectByExample(toexampleservice.bcinfotoexample(bcinfoCustom)).get(0);
        	
        	Bc bc=bcservice.selectByExample(toexampleservice.bctoexample(record)).get(0);
        	

        	String dabiaoshuizhi=zhibiaoService.BcDabiao(bc, bcinfo.getMubiao());
        	bcinfoCustom.setShuizhi(dabiaoshuizhi.split("-")[0]);
        	bcinfoCustom.setDabiao(dabiaoshuizhi.split("-")[1]);
        	bcinfoCustom.setMuqianshuizhiInteger(Integer.parseInt(dabiaoshuizhi.split("-")[2]));
        	bcinfoCustom.setBcinfo(bcinfo);
        	bcinfoCustom.setBctbhb(bctbhb);
        	bcinfoCustom.setBc(bc);
        	bcinfoCustom.setMubiaoshuizhi(zhibiaoService.shuizhiinttostring(bcinfo.getMubiao()));
        	return bcinfoCustom;
		}
    	
    	

	}

	@Override
	public List<Integer> BcCountYearByName(String dmmc) {
		return customMapper.BcCountYearByName(dmmc);
	}

	@Override
	public List<Integer> BcCountMonthByNameAndYear(String dmmc, Integer year) {
		return customMapper.BcCountMonthByNameAndYear(dmmc, year);
	}

}

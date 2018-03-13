package com.szht.service;

import java.util.ArrayList;
import java.util.List;

import com.szht.model.BcSeri;
import com.szht.model.Jcdm;
import com.szht.model.Xzdm;
import com.szht.model.custom.BcCustom;
import com.szht.model.custom.BcinfoCustom;
import com.szht.model.custom.JcdmCustom;
import com.szht.model.custom.XzdmCustom;

public interface CustomService {
	public BcSeri JcdmBeanToBs(List<Jcdm> jcdms,String type,String name);
	public BcSeri XzdmBeanToBs(List<Xzdm> xzdms,String type,String name);
	public BcinfoCustom GetBcinfoByName(BcCustom record);
	
	public ArrayList<String> jcdmx(JcdmCustom example);
	public ArrayList<String> xzdmx(XzdmCustom example);
	
	public List<Integer> JcdmCountYearByName(String dmmc); 
	public List<Integer> JcdmCountMonthByNameAndYear(String dmmc,Integer year); 
	public List<Integer> XzdmCountYearByName(String dmmc); 
	public List<Integer> XzdmCountSeasonByNameAndYear(String dmmc,Integer year); 
	public List<Integer> BcCountYearByName(String dmmc);
	public List<Integer> BcCountMonthByNameAndYear(String dmmc,Integer year);
}

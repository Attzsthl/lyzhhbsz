package com.szht.dao;

import java.util.List;


public interface CustomMapper {
	List<String> GetBcRiverList();
	List<String> GetDmmcList();
	List<String> GetBcdmByRiver(String rivername);
	
	List<Integer> BcCountYearByName(String dmmc);
	List<Integer> BcCountMonthByNameAndYear(String dmmc,Integer year);
	
	List<Integer> XzdmCountYearByName(String dmmc);
	List<Integer> XzdmCountSeasonByNameAndYear(String dmmc,Integer year);
	
	List<Integer> JcdmCountYearByName(String dmmc);
	List<Integer> JcdmCountMonthByNameAndYear(String dmmc,Integer year);
}
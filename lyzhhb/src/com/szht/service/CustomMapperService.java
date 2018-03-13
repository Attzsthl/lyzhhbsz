package com.szht.service;

import java.util.List;

public interface CustomMapperService {
	List<String> GetBcRiverList();
	List<String> GetDmmcList();
	List<String> GetBcdmByRiver(String rivername);
}

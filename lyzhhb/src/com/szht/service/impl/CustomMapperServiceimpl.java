package com.szht.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.szht.dao.CustomMapper;
import com.szht.service.CustomMapperService;
@Service
public class CustomMapperServiceimpl implements CustomMapperService {

	@Resource
	CustomMapper customMapper;
	@Override
	public List<String> GetBcRiverList() {
		return customMapper.GetBcRiverList();
	}

	@Override
	public List<String> GetBcdmByRiver(String rivername) {
		return customMapper.GetBcdmByRiver(rivername);
	}

	@Override
	public List<String> GetDmmcList() {
		return customMapper.GetDmmcList();
	}

}

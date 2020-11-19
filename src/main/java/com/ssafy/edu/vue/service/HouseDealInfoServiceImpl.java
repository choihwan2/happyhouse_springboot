package com.ssafy.edu.vue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.edu.vue.dao.HouseDealInfoDaoImpl;
import com.ssafy.edu.vue.dto.HouseDealInfoDto;

@Service
public class HouseDealInfoServiceImpl implements HouseDealInfoService {
	
	@Autowired
	HouseDealInfoDaoImpl dao;
	
	@Override
	public List<HouseDealInfoDto> getDealInfoDongName(String dongName) throws Exception {
		return dao.getDealInfoDongName(dongName);
	}

	@Override
	public List<HouseDealInfoDto> getDealInfoHouseName(String houseName) throws Exception {
		return dao.getDealInfoHouseName(houseName);
	}

}

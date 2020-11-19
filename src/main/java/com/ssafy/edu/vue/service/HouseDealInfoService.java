package com.ssafy.edu.vue.service;

import java.util.List;

import com.ssafy.edu.vue.dto.HouseDealInfoDto;


public interface HouseDealInfoService {
	List<HouseDealInfoDto> getDealInfoDongName(String dongName)throws Exception;
	List<HouseDealInfoDto> getDealInfoHouseName(String houseName)throws Exception;
}

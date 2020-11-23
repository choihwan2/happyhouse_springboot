package com.ssafy.edu.vue.service;

import java.util.List;

import com.ssafy.edu.vue.dto.HouseDealInfoDto;
import com.ssafy.edu.vue.dto.StarHouseDto;

public interface StarHouseService {
	
	void addStarApt(StarHouseDto dto) throws Exception;
	List<HouseDealInfoDto> getStarApt(String user) throws Exception;
	void deleteStarApt(StarHouseDto dto) throws Exception;
	StarHouseDto getOneStarApt(StarHouseDto dto) throws Exception;
}

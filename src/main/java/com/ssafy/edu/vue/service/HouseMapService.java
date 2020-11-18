package com.ssafy.edu.vue.service;

import java.util.List;

import com.ssafy.edu.vue.dto.HouseInfoDto;
import com.ssafy.edu.vue.dto.SidoGugunCodeDto;

public interface HouseMapService {
	
	List<SidoGugunCodeDto> getSido() throws Exception;
	List<SidoGugunCodeDto> getGugunInSido(String sido) throws Exception;
	List<HouseInfoDto> getDongInGugun(String gugun) throws Exception;
	List<HouseInfoDto> getHouseInDong(String dong) throws Exception;
	List<HouseInfoDto> getHouseName(String houseName)throws Exception;
}

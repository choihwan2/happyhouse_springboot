package com.ssafy.edu.vue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.edu.vue.dao.HouseMapDaoImpl;
import com.ssafy.edu.vue.dto.HouseInfoDto;
import com.ssafy.edu.vue.dto.SidoGugunCodeDto;

@Service
public class HouseMapServiceImpl implements HouseMapService {
	
	@Autowired
	HouseMapDaoImpl dao;
	
	@Override
	public List<SidoGugunCodeDto> getSido() throws Exception {
		return dao.getSido();
	}

	@Override
	public List<SidoGugunCodeDto> getGugunInSido(String sido) throws Exception {
		return dao.getGugunInSido(sido);
	}

	@Override
	public List<HouseInfoDto> getDongInGugun(String gugun) throws Exception {
		return dao.getDongInGugun(gugun);
	}

	@Override
	public List<HouseInfoDto> getHouseInDong(String dong) throws Exception {
		return dao.getHouseInDong(dong);
	}

	@Override
	public List<HouseInfoDto> getHouseName(String houseName) throws Exception {
		return dao.getHouseName(houseName);
	}
	
}

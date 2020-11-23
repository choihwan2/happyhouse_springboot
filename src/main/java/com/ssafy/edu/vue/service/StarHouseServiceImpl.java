package com.ssafy.edu.vue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.edu.vue.dao.StarHouseDaoImpl;
import com.ssafy.edu.vue.dto.HouseDealInfoDto;
import com.ssafy.edu.vue.dto.StarHouseDto;

@Service
public class StarHouseServiceImpl implements StarHouseService {

	@Autowired
	StarHouseDaoImpl dao;

	@Override
	public void addStarApt(StarHouseDto dto) {
		dao.addStarApt(dto);
	}

	@Override
	public List<HouseDealInfoDto> getStarApt(String userId) {
		return dao.getStarAptList(userId);
	}

	@Override
	public void deleteStarApt(StarHouseDto dto) throws Exception {
		dao.deleteStarApt(dto);
	}

	@Override
	public StarHouseDto getOneStarApt(StarHouseDto dto) throws Exception {
		return dao.getOneStarApt(dto);
	}

}

package com.ssafy.edu.vue.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.edu.vue.dto.HouseDealInfoDto;
import com.ssafy.edu.vue.dto.StarHouseDto;

@Repository
public class StarHouseDaoImpl {

	String ns = "com.ssafy.stardao.";
	@Autowired
	private SqlSession sqlSession;

	public void addStarApt(StarHouseDto dto) {
		sqlSession.insert(ns + "saveStarApt",dto);
	}
	
	public StarHouseDto getOneStarApt(StarHouseDto dto) {
		return sqlSession.selectOne(ns + "getOneStarApt", dto);
	}

	public List<HouseDealInfoDto> getStarAptList(String userId) {
		return sqlSession.selectList(ns + "getStarApt", userId);
	}
	
	public void deleteStarApt(StarHouseDto dto) {
		sqlSession.delete(ns + "deleteStarApt",dto);
	}
}

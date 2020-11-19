package com.ssafy.edu.vue.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.edu.vue.dto.HouseDealInfoDto;

@Repository
public class HouseDealInfoDaoImpl {

	String ns = "com.ssafy.housedealinfo.";
	@Autowired
	private SqlSession sqlSession;

	public List<HouseDealInfoDto> getDealInfoDongName(String dongName) throws Exception {
		return sqlSession.selectList(ns + "dongName", dongName);
	}

	public List<HouseDealInfoDto> getDealInfoHouseName(String houseName) throws Exception {
		return sqlSession.selectList(ns + "houseName", houseName);
	}
}

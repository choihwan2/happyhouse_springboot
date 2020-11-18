package com.ssafy.edu.vue.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.edu.vue.dto.CoronaDto;

@Repository
public class CoronaDaoImpl{
	
	String ns="com.ssafy.coronadao.";
	@Autowired
	private SqlSession sqlSession;
	
	public List<CoronaDto> getcoronaInfo(String gugun) throws Exception {
		return sqlSession.selectList(ns + "getcoronaInfo", gugun);
	}

}

package com.ssafy.edu.vue.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.edu.vue.dto.HouseInfoDto;
import com.ssafy.edu.vue.dto.SidoGugunCodeDto;

@Repository
public class HouseMapDaoImpl {

	String ns = "com.ssafy.housemapdao.";
	@Autowired
	private SqlSession sqlSession;

	public List<SidoGugunCodeDto> getSido() throws Exception {
		return sqlSession.selectList(ns + "sidoList");
	}

	public List<SidoGugunCodeDto> getGugunInSido(String sido) throws Exception {
		return sqlSession.selectList(ns + "gugunList", sido);
	}

	public List<HouseInfoDto> getDongInGugun(String gugun) throws Exception {
		return sqlSession.selectList(ns + "dongList", gugun);
	}

	public List<HouseInfoDto> getHouseInDong(String dong) throws Exception {
		return sqlSession.selectList(ns + "houseList", dong);
	}

	public List<HouseInfoDto> getHouseName(String houseName) throws Exception {
		return sqlSession.selectList(ns + "houseNameList", houseName);
	}

}

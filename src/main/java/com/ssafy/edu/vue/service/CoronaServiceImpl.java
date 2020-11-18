package com.ssafy.edu.vue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.edu.vue.dao.CoronaDaoImpl;
import com.ssafy.edu.vue.dto.CoronaDto;

@Service
public class CoronaServiceImpl implements CoronaService{

	@Autowired
	CoronaDaoImpl dao;
	
	@Override
	public List<CoronaDto> getcoronaInfo(String gugun) throws Exception{
		System.out.println("coronaService");
		return dao.getcoronaInfo(gugun);
	}
}
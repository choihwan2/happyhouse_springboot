package com.ssafy.edu.vue.service;

import java.util.List;

import com.ssafy.edu.vue.dto.CoronaDto;

public interface CoronaService {
	List<CoronaDto> getcoronaInfo(String gugun)throws Exception;
}

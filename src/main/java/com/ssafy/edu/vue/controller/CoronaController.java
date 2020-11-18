package com.ssafy.edu.vue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.edu.vue.dto.CoronaDto;
import com.ssafy.edu.vue.service.CoronaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Servlet implementation class coronaController
 */
@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/api/corona")
@Api(value = "HappyHouse", description = "HappyHouse Resouces Management 2020")
public class CoronaController {

	@Autowired
	private CoronaService service;

	@ApiOperation(value = "모든 코로나 병원의 정보를 반환한다.", response = List.class)
	@GetMapping(value = "/gugun/{gugun}")
	public ResponseEntity<List<CoronaDto>> getCoronaList(@PathVariable("gugun") String gugun) {
		List<CoronaDto> list = null;
		try {
			list = service.getcoronaInfo(gugun);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<List<CoronaDto>>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<CoronaDto>>(list, HttpStatus.OK);

	}

}
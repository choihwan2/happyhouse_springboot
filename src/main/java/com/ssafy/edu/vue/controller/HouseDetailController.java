package com.ssafy.edu.vue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.edu.vue.dto.HouseDealInfoDto;
import com.ssafy.edu.vue.service.HouseDealInfoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/api/detail")
@Api(value = "HappyHouse", description = "HappyHouse Resouces Management 2020")
public class HouseDetailController {

	@Autowired
	private HouseDealInfoService service;

	@ApiOperation(value = "dong내의 아파트의 세부정보를 반환한다.", response = List.class)
	@GetMapping(value = "/dong/{dong}")
	public ResponseEntity<List<HouseDealInfoDto>> getDetailDong(@PathVariable("dong") String dong) {
		List<HouseDealInfoDto> list = null;
		try {
			list = service.getDealInfoDongName(dong);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<List<HouseDealInfoDto>>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<HouseDealInfoDto>>(list, HttpStatus.OK);
	}

	@ApiOperation(value = "이름이 포함된 아파트의 세부정보를 반환한다.", response = List.class)
	@GetMapping(value = "/name/{name}")
	public ResponseEntity<List<HouseDealInfoDto>> getDetailName(@PathVariable("name") String name) {
		List<HouseDealInfoDto> list = null;
		try {
			list = service.getDealInfoHouseName(name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<List<HouseDealInfoDto>>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<HouseDealInfoDto>>(list, HttpStatus.OK);
	}

}
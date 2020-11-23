package com.ssafy.edu.vue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.edu.vue.dto.HouseDealInfoDto;
import com.ssafy.edu.vue.dto.StarHouseDto;
import com.ssafy.edu.vue.help.NumberResult;
import com.ssafy.edu.vue.service.StarHouseService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/api/star")
@Api(value = "HappyHouse", description = "HappyHouse Resouces Management 2020")
public class StarHouseController {

	@Autowired
	private StarHouseService service;

	@ApiOperation(value = "관심매물을 등록한다.", response = NumberResult.class)
	@PostMapping(value = "/add")
	public ResponseEntity<NumberResult> addStarApt(@RequestBody StarHouseDto apt) {
		NumberResult ns = null;
		try {
			service.addStarApt(apt);
			ns = new NumberResult();
			ns.setName("addStar");
			ns.setState("succ");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<NumberResult>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<NumberResult>(ns,HttpStatus.OK);
	}

	@ApiOperation(value = "아이디에 해당하는 관심매물 목록을 가져온", response = List.class)
	@GetMapping(value = "/id/{id}")
	public ResponseEntity<List<HouseDealInfoDto>> getDetailName(@PathVariable("id") String id) {
		
		return new ResponseEntity<List<HouseDealInfoDto>>(HttpStatus.OK);
	}

}
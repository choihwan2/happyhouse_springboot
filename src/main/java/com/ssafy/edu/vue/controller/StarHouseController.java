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
		StarHouseDto tempHouse = null;
		try {
			ns = new NumberResult();
			tempHouse = service.getOneStarApt(apt);
			if(tempHouse != null) {
				ns.setState("이미 관심목록에 추가되어있는 아파트입니다.");
				return new ResponseEntity<NumberResult>(ns,HttpStatus.BAD_REQUEST);
			}
			service.addStarApt(apt);
			ns.setName("addStar");
			ns.setState("succ");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<NumberResult>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<NumberResult>(ns,HttpStatus.OK);
	}

	@ApiOperation(value = "아이디에 해당하는 관심매물 목록을 가져온다", response = List.class)
	@GetMapping(value = "/id/{userId}")
	public ResponseEntity<List<HouseDealInfoDto>> getDetailName(@PathVariable("userId") String userId) {
		List<HouseDealInfoDto> list = null;
		try {
			list = service.getStarApt(userId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<List<HouseDealInfoDto>>(list,HttpStatus.OK);
	}
	
	@ApiOperation(value = "관심 매물을 삭제한다", response = NumberResult.class)
	@PostMapping(value = "/delete")
	public ResponseEntity<NumberResult> deleteStarApt(@RequestBody StarHouseDto dto) {
		NumberResult ns = null;
		try {
			service.deleteStarApt(dto);
			ns = new NumberResult();
			ns.setName("deleteStarApt");
			ns.setState("succ");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<NumberResult>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<NumberResult>(ns,HttpStatus.OK);
	}
	

}
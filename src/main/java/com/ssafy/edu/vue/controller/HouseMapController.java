package com.ssafy.edu.vue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.edu.vue.dto.HouseInfoDto;
import com.ssafy.edu.vue.dto.SidoGugunCodeDto;
import com.ssafy.edu.vue.service.HouseMapService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/api/map")
@Api(value = "HappyHouse", description = "HappyHouse Resouces Management 2020")
public class HouseMapController {

	@Autowired
	public HouseMapService service;

	@ApiOperation(value = "시에 해당하는 SidoGugunCode 를 반환한다.", response = List.class)
	@RequestMapping(value = "/sido", method = RequestMethod.GET)
	public ResponseEntity<List<SidoGugunCodeDto>> sidoList() {
		List<SidoGugunCodeDto> list = null;
		try {
			list = service.getSido();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<List<SidoGugunCodeDto>>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<List<SidoGugunCodeDto>>(list, HttpStatus.OK);
	}

	@ApiOperation(value = "gugun에 해당하는 SidoGugunCode 를 반환한다.", response = List.class)
	@GetMapping(value = "/gugun/{sido}")
	public ResponseEntity<List<SidoGugunCodeDto>> gugunList(@PathVariable("sido") String sido) {
		List<SidoGugunCodeDto> list = null;
		try {
			list = service.getGugunInSido(sido);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<List<SidoGugunCodeDto>>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<SidoGugunCodeDto>>(list, HttpStatus.OK);
	}

	@ApiOperation(value = "gugun에 해당하는 HouseInfoDto 를 반환한다.", response = List.class)
	@GetMapping(value = "/dong/{gugun}")
	public ResponseEntity<List<HouseInfoDto>> dongList(@PathVariable("gugun") String gugun) {
		List<HouseInfoDto> list = null;
		try {
			list = service.getDongInGugun(gugun);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<List<HouseInfoDto>>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<HouseInfoDto>>(list, HttpStatus.OK);
	}

	@ApiOperation(value = "dong에 해당하는 HouseInfoDto 를 반환한다.", response = List.class)
	@GetMapping(value = "/house/{dong}")
	public ResponseEntity<List<HouseInfoDto>> houseList(@PathVariable("dong") String dong) {
		List<HouseInfoDto> list = null;
		try {
			list = service.getHouseInDong(dong);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<List<HouseInfoDto>>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<HouseInfoDto>>(list, HttpStatus.OK);
	}

	@ApiOperation(value = "{name}를 포함하는 HouseInfoDto를 반환한다.", response = List.class)
	@GetMapping(value = "/name/{name}")
	public ResponseEntity<List<HouseInfoDto>> houseNameList(@PathVariable("name") String name) {
		List<HouseInfoDto> list = null;
		try {
			list = service.getHouseName(name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<List<HouseInfoDto>>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<HouseInfoDto>>(list, HttpStatus.OK);
	}

}
package com.ssafy.edu.vue.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.edu.vue.dto.MemberDto;
import com.ssafy.edu.vue.help.NumberResult;
import com.ssafy.edu.vue.service.MemberService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/api/admin")
@Api(value = "HappyHouse", description = "HappyHouse Resouces Management 2020")
public class AdminController {

	public static final Logger logger = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	private MemberService memberService;

	@ApiOperation(value = "회원가입된 유저 정보를 모두 반환한다.", response = List.class)
	@RequestMapping(value = "/member", method = RequestMethod.GET)
	public ResponseEntity<List<MemberDto>> member() {
		List<MemberDto> list = null;
		try {
			list = memberService.allMember();
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<List<MemberDto>>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<List<MemberDto>>(list, HttpStatus.OK);
	}

	@ApiOperation(value = "회원가입된 유저를 강제로 삭제한다.", response = NumberResult.class)
	@RequestMapping(value = "/del/{id}", method = RequestMethod.GET)
	public ResponseEntity<NumberResult> del(@PathVariable("id") String id) {
		NumberResult ns = new NumberResult();
		ns.setName("adminDel");
		try {
			memberService.deleteMember(id);
			ns.setCount(1);
			ns.setState("succ");
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (ns.getCount() != 1) {
			return new ResponseEntity<NumberResult>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<NumberResult>(ns, HttpStatus.OK);
	}
}

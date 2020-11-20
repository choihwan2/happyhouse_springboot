package com.ssafy.edu.vue.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.edu.vue.dto.MemberDto;
import com.ssafy.edu.vue.help.NumberResult;
import com.ssafy.edu.vue.service.JwtService;
import com.ssafy.edu.vue.service.MemberService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/api/member")
@Api(value = "HappyHouse", description = "HappyHouse Resouces Management 2020")
public class MemberController {

	@Autowired
	private JwtService jwtService;

	@Autowired
	private MemberService memberService;

	public static final Logger logger = LoggerFactory.getLogger(MemberController.class);

//	@Autowired
//	private PostService postService;

	/*
	 * 수정이 필요한 페이지
	 */

	@ApiOperation(value = "로그인을 시도해보고 그에 맞는 토큰을 Map형태로 받아온다", response = Map.class)
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> login(@RequestBody MemberDto memberDto) {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		try {
			MemberDto loginUser = memberService.login(memberDto);

			if (loginUser != null) {
//				jwt.io에서 확인
//				로그인 성공했다면 토큰을 생성한다.
				String token = jwtService.create(loginUser);
				logger.trace("로그인 토큰정보 : {}", token);

//				토큰 정보는 response의 헤더로 보내고 나머지는 Map에 담는다.
//				response.setHeader("auth-token", token);
				resultMap.put("auth-token", token);
				resultMap.put("user-id", loginUser.getId());
				resultMap.put("user-name", loginUser.getName());
				resultMap.put("user-type", loginUser.getIsAdmin());
//				resultMap.put("status", true);
//				resultMap.put("data", loginUser);
				status = HttpStatus.ACCEPTED;
			} else {
				resultMap.put("message", "로그인 실패");
				status = HttpStatus.ACCEPTED;
			}
		} catch (Exception e) {
			logger.error("로그인 실패 : {}", e);
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}

	@ApiOperation(value = "유저 정보를 Map형태로 받아온다", response = Map.class)
	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> getInfo(HttpServletRequest req) {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		System.out.println(">>>>>> " + jwtService.get(req.getHeader("auth-token")));
		try {
			// 사용자에게 전달할 정보이다.
//			String info = memberService.getServerInfo();

			resultMap.putAll(jwtService.get(req.getHeader("auth-token")));
//
//			resultMap.put("status", true);
//			resultMap.put("info", info);
			status = HttpStatus.ACCEPTED;
		} catch (RuntimeException e) {
			logger.error("정보조회 실패 : {}", e);
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}

	@ApiOperation(value = "유저 정보를 입력하여 가입한다.", response = NumberResult.class)
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	private ResponseEntity<NumberResult> join(@RequestBody MemberDto memberDto) throws SQLException {
		NumberResult ns = new NumberResult();
		try {
			memberDto.setIsAdmin(0);
			memberService.regiMember(memberDto);
			ns.setCount(1);
			ns.setState("succ");
			System.out.println(memberDto);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<NumberResult>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<NumberResult>(ns, HttpStatus.OK);

	}

	@ApiOperation(value = "유저 정보 토큰을 가지고 회원 탈퇴를 진행한다.", response = NumberResult.class)
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ResponseEntity<NumberResult> delete(HttpServletRequest req) throws SQLException {
		Map<String, Object> resultMap = new HashMap<>();
		String id = "";
		NumberResult ns = new NumberResult();

		try {
			resultMap.putAll(jwtService.get(req.getHeader("auth-token")));
			id = (String) resultMap.get("id");
			memberService.deleteMember(id);
			ns.setName("memebrDelete");
			ns.setCount(1);
			ns.setState("succ");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<NumberResult>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<NumberResult>(ns,HttpStatus.OK);
	}
	
	
	@ApiOperation(value = "수정할 유저의 정보를 받게되면 그에 맞게 수정하고 새로운 토큰을 반환한다.", response = Map.class)
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> modify(@RequestBody MemberDto memberDto) {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		try {
			memberService.modifyMember(memberDto);

			if (memberDto != null) {
//				jwt.io에서 확인
//				로그인 성공했다면 토큰을 생성한다.
				String token = jwtService.create(memberDto);
				logger.trace("로그인 토큰정보 : {}", token);

//				토큰 정보는 response의 헤더로 보내고 나머지는 Map에 담는다.
//				response.setHeader("auth-token", token);
				resultMap.put("auth-token", token);
				resultMap.put("user-id", memberDto.getId());
				resultMap.put("user-name", memberDto.getName());
				resultMap.put("user-type", memberDto.getIsAdmin());
//				resultMap.put("status", true);
//				resultMap.put("data", loginUser);
				status = HttpStatus.ACCEPTED;
			} else {
				resultMap.put("message", "유저 수정 실패");
				status = HttpStatus.ACCEPTED;
			}
		} catch (Exception e) {
			logger.error("유저 수정 실패 : {}", e);
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}

//	@RequestMapping(value = "/boardList", method = RequestMethod.GET)
//	public String boardList(@RequestParam Map<String, String> map, Model model) {
//		String spp = map.get("spp");
//		map.put("spp", spp != null ? spp : "10");//sizePerPage
//		try {
//			List<PostDto> list = postService.listPost(map);
//			PageNavigation pageNavigation = postService.makePageNavigation(map);
//			model.addAttribute("postlist", list);
//			model.addAttribute("navigation", pageNavigation);
//			return "board";
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println(e.toString());
//			model.addAttribute("msg", "글목록을 얻어오는 중 문제가 발생했습니다.");
//			return "error/error";
//		}
//	}

//	@RequestMapping(value = "/NewsList", method = RequestMethod.GET)
//	public String NewsList(HttpSession session) {
//		return "newsInfo";
//	}

//	@RequestMapping(value = "/delPost/{num}", method = RequestMethod.GET)
//	public String delPost(@PathVariable("num") int num, Model model) {
//		
//		try {
//			postService.deletePost(num);
//			
//			return "redirect:/user/boardList?pg=1&key=&word=";
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//			model.addAttribute("msg", "글 삭제 문제가 발생했습니다.");
//			return "error/error";
//		}
//	}

}

package com.ssafy.edu.vue.controller;

import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.edu.vue.dto.MemberDto;
import com.ssafy.edu.vue.service.MemberService;

import io.swagger.annotations.Api;

@CrossOrigin(origins = {"*"}, maxAge = 6000)
@RestController
@RequestMapping("/api")
@Api(value="HappyHouse", description="HappyHouse Resouces Management 2020")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
//	@Autowired
//	private PostService postService;
	
	/*
	 * 수정이 필요한 페이지
	 */
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam Map<String, String> map, Model model, HttpSession session, HttpServletResponse response) {
		try {
			MemberDto memberDto = memberService.login(map);
			if(memberDto != null) {
				session.setAttribute("userInfo", memberDto);
				
				System.out.println("id ---------> " + memberDto.getId());
				
				MemberDto userInfoDetail = memberService.getMember(memberDto.getId());
				session.setAttribute("userInfoDetail", userInfoDetail);
				
				if (memberDto.getIsAdmin() == 1) {
					return "redirect:/admin";
				}
				return "redirect:/";
			} else {
				model.addAttribute("msg", "아이디 또는 비밀번호 확인 후 로그인해 주세요.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "로그인 중 문제가 발생했습니다.");
			return "error/error";
		}
		return "redirect:/";
	}
	
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(Model model, HttpSession session) throws SQLException  {
		
		MemberDto mem = (MemberDto) session.getAttribute("userInfo");
		
		String id = mem.getId();
		System.out.println("id -----> " + id);
		
		try {
			memberService.deleteMember(id);
			
			session.invalidate();
			return "redirect:/";
			
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "회원탈퇴 문제가 발생했습니다.");
			return "error/error";
		}
		
	}
	
	@RequestMapping(value = "/joinForm", method = RequestMethod.GET)
	public String joinForm(HttpSession session) {
		return "register";
	}
	
	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public String find(HttpSession session) {
		return "find";
	}
	
	@RequestMapping(value = "/mypage", method = RequestMethod.GET)
	public String mypage(HttpSession session) {
		return "mypage";
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	private String join(MemberDto memberDto, Model model) throws SQLException  {
		try {
			memberDto.setIsAdmin(0);
			
			memberService.regiMember(memberDto);
			
			System.out.println("------ [member] ------");
			System.out.println(memberDto);
			
			return "redirect:/";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "회원가입 문제가 발생했습니다.");
			return "error/error";
		}
		
	}
       
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	private String modify(MemberDto memberDto, Model model, HttpSession session) throws SQLException  {
		
		MemberDto mem = (MemberDto) session.getAttribute("userInfo");
		
		try {
			memberDto.setId(mem.getId());
			memberDto.setIsAdmin(0);
			
			memberService.modifyMember(memberDto);
			
			System.out.println("------ [member] ------");
			System.out.println(memberDto);
			
			
			session.setAttribute("userInfo", memberDto);
			
			
			MemberDto userInfoDetail = memberService.getMember(memberDto.getId());
			session.setAttribute("userInfoDetail", userInfoDetail);
			
			return "redirect:/user/mypage";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "회원 수정 문제가 발생했습니다.");
			return "error/error";
		}
		
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

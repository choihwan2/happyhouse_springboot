package com.ssafy.edu.vue.service;

import java.util.List;
import java.util.Map;

import com.ssafy.edu.vue.dto.MemberDto;
import com.ssafy.edu.vue.util.PageNavigation;

public interface MemberService {

	public MemberDto login(MemberDto dto) throws Exception;
	String findPassword(String id);			// 비밀번호 찾기
	void regiMember(MemberDto member) throws Exception;		// 회원 가입
	void deleteMember(String id) throws Exception;			// 회원 삭제
	void modifyMember(MemberDto member) throws Exception;			// 회원 정보 수정
	public List<MemberDto> listMember(Map<String, String> map) throws Exception;
	public List<MemberDto> allMember() throws Exception;
	public MemberDto getMember(String id);
	public PageNavigation makePageNavigation(Map<String, String> map) throws Exception;
	
}

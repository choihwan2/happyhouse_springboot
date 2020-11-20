package com.ssafy.edu.vue.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.edu.vue.dao.MemberDaoImpl;
import com.ssafy.edu.vue.dto.MemberDto;
import com.ssafy.edu.vue.util.PageNavigation;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDaoImpl memberDao;

	@Override
	public MemberDto login(MemberDto dto) throws Exception {
		if (dto == null)
			return null;
		return memberDao.login(dto);
	}

	@Override
	public void regiMember(MemberDto member) throws Exception {
		if (member.getId() == null || member.getPw() == null) {
			throw new Exception();
		}
		memberDao.regiMember(member);
	}

	@Override
	public void deleteMember(String id) throws Exception {
		memberDao.deleteMember(id);
	}

	@Override
	public String findPassword(String id) {
		return memberDao.findPassword(id);
	}

	@Override
	public void modifyMember(MemberDto member) throws Exception {
		if (member.getPw() == null) {
			throw new Exception();
		}
		memberDao.modifyMember(member);
	}

	@Override
	public MemberDto getMember(String id) {
		return memberDao.getMember(id);
	}

	@Override
	public List<MemberDto> listMember(Map<String, String> map) throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("key", map.get("key") == null ? "" : map.get("key"));
		param.put("word", map.get("word") == null ? "" : map.get("word"));
		
		System.out.println("=================");
		System.out.println(map.get("pg"));
		System.out.println("=================");
		int pg = 0;
		if (map.get("pg") != null) {
			pg = Integer.parseInt(map.get("pg"));
		}
		
		int currentPage = pg;
		int sizePerPage = Integer.parseInt(map.get("spp"));
		int start = (currentPage - 1) * sizePerPage;
		param.put("start", start);
		param.put("spp", sizePerPage);
		return memberDao.listMember(param);
	}

	@Override
	public PageNavigation makePageNavigation(Map<String, String> map) throws Exception {
		int naviSize = 10;
		int currentPage = Integer.parseInt(map.get("pg"));
		int sizePerPage = Integer.parseInt(map.get("spp"));
		PageNavigation pageNavigation = new PageNavigation();
		pageNavigation.setCurrentPage(currentPage);
		pageNavigation.setNaviSize(naviSize);
		int totalCount = memberDao.getTotalCount(map);
		pageNavigation.setTotalCount(totalCount);
		int totalPageCount = (totalCount - 1) / sizePerPage + 1;
		pageNavigation.setTotalPageCount(totalPageCount);
		boolean startRange = currentPage <= naviSize;
		pageNavigation.setStartRange(startRange);
		boolean endRange = (totalPageCount - 1) / naviSize * naviSize < currentPage;
		pageNavigation.setEndRange(endRange);
		pageNavigation.makeNavigator();
		return pageNavigation;
	}

	@Override
	@Transactional
	public List<MemberDto> allMember() throws Exception {
		return memberDao.allMember();
	}

}

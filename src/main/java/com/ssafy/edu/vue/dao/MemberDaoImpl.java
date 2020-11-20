package com.ssafy.edu.vue.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.edu.vue.dto.MemberDto;

@Repository
public class MemberDaoImpl {

	String ns = "com.ssafy.memberdao.";
	@Autowired
	private SqlSession sqlSession;

	public MemberDto login(MemberDto dto) throws SQLException {
		return sqlSession.selectOne(ns + "login", dto);
	}

	public void regiMember(MemberDto member) throws SQLException {
		sqlSession.insert(ns + "regiMember", member);
	}

	public void modifyMember(MemberDto member) throws SQLException {
		sqlSession.update(ns + "modMember", member);
	}

	public void deleteMember(String id) {
		sqlSession.delete(ns + "deleteMember", id);
	}

	public String findPassword(String id) {
		String sql = "select pw from member where id=?";
		return null;
	}

	public MemberDto getMember(String id) {
		MemberDto member = null;
		String sql = " select id, name, phoneNum, email, address, addressDetail from member where id=?";
		return null;
	}

	public List<MemberDto> listMember(Map<String, Object> map) throws SQLException {
		return sqlSession.selectList(ns + "listMember", map);
	}
	
	public List<MemberDto> allMember() throws SQLException {
		return sqlSession.selectList(ns + "allMember");
	}

	public int getTotalCount(Map<String, String> map) throws SQLException {
		return sqlSession.selectOne(ns + "getTotalCount", map);
	}

}

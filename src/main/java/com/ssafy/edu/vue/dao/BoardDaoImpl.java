package com.ssafy.edu.vue.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.edu.vue.dto.BoardDto;


@Repository
public class BoardDaoImpl {
	
	String ns="com.ssafy.board.";
	@Autowired
	private SqlSession sqlSession;
	
	public List<BoardDto> getBoardList (){
		return sqlSession.selectList(ns+"getBoardList");
	}
	
	public List<BoardDto> searchBoard(String title){
		return sqlSession.selectList(ns + "searchBoard", title);
	}
	
	public BoardDto getBoard(int num) {
		return sqlSession.selectOne(ns + "getBoard",num);
	}
	
	public int updateBoard(BoardDto b) {
		return sqlSession.update(ns+"updateBoard",b);
	}
	
	public int deleteBoard(BoardDto b) {
		return sqlSession.delete(ns+"deleteBoard",b);
	}
	public void saveBoard(BoardDto b) {
		sqlSession.insert(ns+"saveBoard",b);
	}
	
}

package com.ssafy.edu.vue.service;

import java.util.List;

import com.ssafy.edu.vue.dto.BoardDto;


//OCP -> ISP 
public interface BoardService {
	List<BoardDto> getBoardList ();
	
	BoardDto getBoard(int num);

	List<BoardDto> searchBoard(String title);
	

	void saveBoard(BoardDto b);
	
	int updateBoard(BoardDto b);
	
	int deleteBoard(BoardDto b);
	
}

package com.ssafy.edu.vue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.edu.vue.dao.BoardDaoImpl;
import com.ssafy.edu.vue.dto.BoardDto;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardDaoImpl boardDao;

	@Override
	public List<BoardDto> getBoardList() {
		return boardDao.getBoardList();
	}

	@Override
	public List<BoardDto> searchBoard(String title) {
		return boardDao.searchBoard(title);
	}

	@Override
	public void saveBoard(BoardDto b) {
		boardDao.saveBoard(b);
	}

	@Override
	public int updateBoard(BoardDto b) {
		return boardDao.updateBoard(b);
	}

	@Override
	public BoardDto getBoard(int num) {
		return boardDao.getBoard(num);
	}

	@Override
	public int deleteBoard(BoardDto b) {
		return boardDao.deleteBoard(b);
	}

}

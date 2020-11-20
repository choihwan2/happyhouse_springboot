package com.ssafy.edu.vue.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.edu.vue.dto.BoardDto;
import com.ssafy.edu.vue.help.NumberResult;
import com.ssafy.edu.vue.service.BoardService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

//http://localhost:8197/humans/swagger-ui.html
@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/api")
@Api(value = "HappyHouse", description = "HappyHouse Resouces Management 2020")
public class BoardController {

	public static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	private BoardService boardService;

	@ApiOperation(value = "모든 게시물의 정보를 반환한다.", response = List.class)
	@RequestMapping(value = "/findAllBoards", method = RequestMethod.GET)
	public ResponseEntity<List<BoardDto>> boards() throws Exception {
		logger.info("1-------------boards-----------------------------" + new Date());
		List<BoardDto> boards = boardService.getBoardList();
		if (boards.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<BoardDto>>(boards, HttpStatus.OK);
	}

	@ApiOperation(value = "선택한 게시물의 정보를 반환한다.", response = BoardDto.class)
	@RequestMapping(value = "/detailboard/{num}", method = RequestMethod.GET)
	public ResponseEntity<BoardDto> getBoard(@PathVariable String num) throws Exception {
		logger.info("1-------------getBoard-----------------------------" + new Date());
		BoardDto board = null;
		board = boardService.getBoard(Integer.valueOf(num));
		if (board == null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<BoardDto>(board, HttpStatus.OK);
	}

	@ApiOperation(value = "title에 해당하는 게시물들을 반환한다.", response = List.class)
	@RequestMapping(value = "/board/{title}", method = RequestMethod.GET)
	public ResponseEntity<List<BoardDto>> searchBoard(@PathVariable String title) throws Exception {
		logger.info("1-------------searchBoard-----------------------------" + new Date());
		List<BoardDto> boards = boardService.searchBoard(title);
		if (boards == null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<BoardDto>>(boards, HttpStatus.OK);
	}

	@ApiOperation(value = " 새로운 게시물을 정보를 입력한다.", response = NumberResult.class)
	@RequestMapping(value = "/addBoard", method = RequestMethod.POST)
	public ResponseEntity<NumberResult> saveBoard(@RequestBody BoardDto dto) throws Exception {
		logger.info("5-------------saveBoard-----------------------------" + new Date());
		logger.info("5-------------saveBoard-----------------------------" + dto);
		boardService.saveBoard(dto);
		NumberResult nr = new NumberResult();
		nr.setName("saveBoard");
		nr.setState("succ");
		return new ResponseEntity<NumberResult>(nr, HttpStatus.OK);
	}

	@ApiOperation(value = "게시물을 수정한다", response = NumberResult.class)
	@RequestMapping(value = "/modifyBoard", method = RequestMethod.POST)
	public ResponseEntity<NumberResult> updateEmployee(@RequestBody BoardDto dto) throws Exception {
		logger.info("1-------------updateBoard-----------------------------" + new Date());
		logger.info("1-------------updateBoard-----------------------------" + dto);
		int result = boardService.updateBoard(dto);
		NumberResult nr = new NumberResult();
		nr.setName("updateBoard");
		nr.setState("succ");
		if(result == 0) {
			return new ResponseEntity<NumberResult>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<NumberResult>(nr, HttpStatus.OK);
	}
	
	@ApiOperation(value = "해당 게시글을 삭제한다.", response = NumberResult.class)
	@RequestMapping(value = "/deleteBoard", method = RequestMethod.POST)
	public ResponseEntity<NumberResult> deleteBoard(@RequestBody BoardDto dto) throws Exception {
		logger.info("1-------------deleteBoard-----------------------------"+new Date());
		logger.info("1-------------deleteBoard-----------------------------"+dto.getNum());
		
		int result = boardService.deleteBoard(dto);
		NumberResult nr=new NumberResult();
		nr.setCount(result);
		nr.setName("deleteBoard");
		nr.setState("succ");
		if (result == 0) {
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<NumberResult>(nr, HttpStatus.OK);
	}
}

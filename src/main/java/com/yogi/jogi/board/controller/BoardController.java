package com.yogi.jogi.board.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yogi.jogi.board.model.BoardModel;
import com.yogi.jogi.board.service.BoardService;



@Controller
@RequestMapping("board")
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	ModelAndView mv = new ModelAndView();
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("board1")
	public void board1() throws Exception {
		BoardModel boardModel = new BoardModel();
		boardModel.setBoardid("1");
		List<BoardModel> list = boardService.selectBoardList(boardModel);
		int a = list.size();
		System.out.println(list);
		System.out.println(a);
	}
	
}

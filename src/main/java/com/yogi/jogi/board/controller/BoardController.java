package com.yogi.jogi.board.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yogi.jogi.board.dao.BoardDao;
import com.yogi.jogi.board.model.BoardModel;
import com.yogi.jogi.board.service.BoardService;

@Controller
@RequestMapping("board")
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	ModelAndView mv = new ModelAndView();
	private String boardid;
	private int pageNum;

	@Autowired
	private BoardService boardService;

	@ModelAttribute public void setAttr(HttpServletRequest request) { HttpSession
	  session = request.getSession(); String reqboardid =
	  request.getParameter("boardid");
	 
	 if 
	   (reqboardid != null) session.setAttribute("boardid", reqboardid); 
	 if
	  (session.getAttribute("boardid") == null) boardid = "1";
	 else boardid = (String) session.getAttribute("boardid"); 
	 try { pageNum = Integer.parseInt(request.getParameter("pageNum")); } 
	 catch (Exception e) { 
	  pageNum = 1; 
	 } }

	@RequestMapping("list")
	public ModelAndView list() throws Exception {
		BoardModel boardModel = new BoardModel();
		boardid = "1";
		boardModel.setBoardid(boardid);
		System.out.println(boardModel);
		List<BoardModel> AllList = boardService.selectBoardList(boardModel);

		mv.setViewName("board/list");
		mv.addObject("AllList", AllList);

		return mv;
	}

	@RequestMapping("writeForm")
	public ModelAndView writeForm(BoardModel boardModel) throws Exception {
		mv.clear();
		BoardModel a = new BoardModel();

		mv.addObject("num", boardModel.getBoardNum());
		mv.addObject("ref", boardModel.getRef());
		mv.addObject("reStep", boardModel.getReStep());
		mv.addObject("reLevel", boardModel.getReLevel());
		mv.setViewName("board/writeUploadForm");

		return mv;
	}

	@RequestMapping("writePro")
	public String writePro(BoardModel boardModel) throws Exception {
		
		boardService.insertBoard(boardModel, boardid);
		return "redirect:list";
	}

}

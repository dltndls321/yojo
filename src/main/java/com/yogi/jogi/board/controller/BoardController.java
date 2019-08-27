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
<<<<<<< HEAD
import org.springframework.web.bind.annotation.RequestParam;
=======
>>>>>>> 58807e42f796fa06f0a504f84566e3a8c8561a74
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.yogi.jogi.board.dao.BoardDao;
import com.yogi.jogi.board.model.BoardModel;
import com.yogi.jogi.board.model.NoticeModel;
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

<<<<<<< HEAD
	 
=======
	@ModelAttribute // 이 어노테이션을 사용하면 메소드에서 선언한 객체가 뷰로 넘어감 글구 가장먼저 실행됨
	public void setAttr(HttpServletRequest request) {

		// boardid와 pageNum 세팅하는 메소드

		HttpSession session = request.getSession();
		String reqboardid = request.getParameter("boardid"); // boardid가 넘어오는지

		if (reqboardid != null)
			session.setAttribute("boardid", reqboardid); // boardid가 있으면 session에 boardid 체크
		if (session.getAttribute("boardid") == null)
			boardid = "1"; // null 이면 boardid = 1
		else
			boardid = (String) session.getAttribute("boardid"); // 오브젝트로 받아오기떄문에 String으로 형변환

		try {
			pageNum = Integer.parseInt(request.getParameter("pageNum")); // pageNum을 세팅하는데 넘어오지않으면 1을 집어넣음
		} catch (Exception e) {
			// TODO: handle exception
			pageNum = 1;
		}

	}

>>>>>>> 58807e42f796fa06f0a504f84566e3a8c8561a74
	@RequestMapping("boardlist")
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
>>>>>>> parent of ec3ca44... 커밋 08-27
	public ModelAndView list() throws Exception {
		BoardModel boardModel = new BoardModel();
		boardid = "1";
		boardModel.setBoardid(boardid);
		System.out.println(boardModel);
		List<BoardModel> AllList = boardService.selectBoardList(boardModel);

		mv.setViewName("board/list");
		mv.addObject("AllList", AllList);
		System.out.println(AllList);
<<<<<<< HEAD

=======
	
>>>>>>> 58807e42f796fa06f0a504f84566e3a8c8561a74
		return mv;
	}

	@RequestMapping("writeUploadForm")
<<<<<<< HEAD
	public ModelAndView writeForm(BoardModel boardModel,@RequestParam String boardid) throws Exception {
		System.out.println("1" + boardModel);
		mv.clear(); 
		System.out.println(boardid);
		mv.setViewName("board/writeUploadForm");
		mv.addObject("boardid",boardid);
=======
	public ModelAndView writeForm(BoardModel boardModel) throws Exception {
		mv.clear();
		BoardModel a = new BoardModel();
		mv.clear(); // ModelAndView 초기화
		
		
		
		/*
		 * mv.addObject("memNum", boardModel.getMemNum()); mv.addObject("fname",
		 * boardModel.getFname()); mv.addObject("fsize", boardModel.getFsize());
		 * mv.addObject("readcount", boardModel.getReadcount()); mv.addObject("regdate",
		 * boardModel.getRegdate()); mv.setViewName("board/writeUploadForm");
		 */

>>>>>>> 58807e42f796fa06f0a504f84566e3a8c8561a74
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
<<<<<<< HEAD
		System.out.println("2" + boardModel);
		boardService.insertBoard(boardModel);
		return "redirect:/board/list";

		// return "redirect:/board/list?pageNum=" + pageNum;

	}

	@RequestMapping("writeUploadPro")
	public String writeUploadPro(MultipartHttpServletRequest multipart, BoardModel boardModel) throws Exception {
		
		MultipartFile multi = multipart.getFile("uploadfile");
		String fname = multi.getOriginalFilename();
		System.out.println(fname);
		if (fname != null && !fname.equals("")) {

			String uploadPath = multipart.getRealPath("/") + "WEB-INF/views/board/fileSave";
			System.out.println(uploadPath);

			FileCopyUtils.copy(multi.getInputStream(),
					new FileOutputStream(uploadPath + "/" + multi.getOriginalFilename()));
			System.out.println("in : "+fname);
			boardModel.setFname(fname);
			boardModel.setFsize((int) multi.getSize());
		} else {
			boardModel.setFname("");
			boardModel.setFsize(0);
		}
		System.out.println("3" + boardModel);
		boardService.insertBoard(boardModel);
		return "redirect:/board/boardlist";
		// return "redirect:list?pageNum=" + pageNum;
	}

	@RequestMapping("content")
	public ModelAndView content(BoardModel boardModel, HttpServletRequest request) throws Exception {
		int boardNum = Integer.parseInt(request.getParameter("boardNum"));
		mv.clear();
		boardModel.setBoardNum(boardNum);
		BoardModel list = boardService.selectBoard(boardModel);
		mv.addObject("list", list);
		mv.addObject("pageNum", pageNum);
		mv.setViewName("board/content"); // 가야할 페이지
		return mv;

	}

	@RequestMapping("update")
	public ModelAndView update(BoardModel boardModel) throws Exception {
		mv.clear();
		BoardModel list = boardService.updateBoard(boardModel);
		mv.addObject("list", list);
		mv.addObject("pageNum", pageNum);
		mv.setViewName("board/updateForm");
		return mv;
	}

	@RequestMapping("updatePro")
	public ModelAndView updatePro(BoardModel boardModel) throws Exception {
		mv.clear();

		int check = boardService.selectPasswdOneNum(boardModel);
		mv.addObject("check", check);
		mv.addObject("pageNum", pageNum);

		mv.setViewName("board/updatePro");
		return mv;
	}

	@RequestMapping("delete")
	public ModelAndView delete(int boarNum) throws Exception {
		mv.clear();

		mv.addObject("boarNum", boarNum);
		mv.addObject("pageNum", pageNum);

		mv.setViewName("board/deleteForm");
		return mv;
	}

	@RequestMapping("deletePro")
	public ModelAndView deletePro(BoardModel boardModel) throws Exception {
		// private passwd 선언하면 안됨
		int check = boardService.deleteBoard(boardModel);
		mv.clear();
		mv.addObject("check", check);
		mv.addObject("pageNum", pageNum);
		mv.setViewName("board/deletePro");
		return mv;

	}
	
=======
		System.out.println("*************"+boardModel);
		boardService.insertBoard(boardModel);
		return "redirect:/board/list?pageNum=" + pageNum;
		
	}
	@RequestMapping("writeUploadPro")
	 public String writeUploadPro(MultipartHttpServletRequest multipart,BoardModel boardModel) throws Exception{
	      MultipartFile multi = multipart.getFile("uploadfile");
	      String filename = multi.getOriginalFilename();
	      if(filename != null && !filename.equals("")) {
	    	  
	    	  String uploadPath = multipart.getRealPath("/") + "WEB-INF/views/board/fileSave";
	    	  System.out.println(uploadPath);
	    	  FileCopyUtils.copy(multi.getInputStream(), new FileOutputStream(uploadPath + "/" + multi.getOriginalFilename()));
	    	  boardModel.setFname(filename);
	    	  boardModel.setFsize((int)multi.getSize());
	      }else {
	    	  boardModel.setFname("");
	    	  boardModel.setFsize(0);
	      }
	      boardService.insertBoard(boardModel);
	      return "redirect:list?pageNum=" + pageNum; 
	   }
	@RequestMapping("content")
	public ModelAndView content(BoardModel boardModel, HttpServletRequest request) throws Exception {
		int boardNum = Integer.parseInt(request.getParameter("boardNum"));
		mv.clear();
		boardModel.setBoardNum(boardNum);
		BoardModel list = boardService.selectBoard(boardModel);
		mv.addObject("list", list);
		mv.addObject("pageNum", pageNum);
		mv.setViewName("board/content"); // 가야할 페이지
		return mv;
>>>>>>> 58807e42f796fa06f0a504f84566e3a8c8561a74

	}

	@RequestMapping("update")
	public ModelAndView update(BoardModel boardModel) throws Exception {
		mv.clear();
		BoardModel list = boardService.updateBoard(boardModel);
		mv.addObject("list", list);
		mv.addObject("pageNum", pageNum);
		mv.setViewName("board/updateForm");
		return mv;
	}

	@RequestMapping("updatePro")
	public ModelAndView updatePro(BoardModel boardModel) throws Exception {
		mv.clear();

		int check = boardService.selectPasswdOneNum(boardModel);
		mv.addObject("check", check);
		mv.addObject("pageNum", pageNum);

		mv.setViewName("board/updatePro");
		return mv;
	}

	@RequestMapping("delete")
	public ModelAndView delete(int boarNum) throws Exception {
		mv.clear();

		mv.addObject("boarNum", boarNum);
		mv.addObject("pageNum", pageNum);

		mv.setViewName("board/deleteForm");
		return mv;
	}

	@RequestMapping("deletePro")
	public ModelAndView deletePro(BoardModel boardModel) throws Exception {
		// private passwd 선언하면 안됨
		int check = boardService.deleteBoard(boardModel);
		mv.clear();
		mv.addObject("check", check);
		mv.addObject("pageNum", pageNum);
		mv.setViewName("board/deletePro");
		return mv;

	}
	
		
		boardService.insertBoard(boardModel, boardid);
		return "redirect:list";
	}

}

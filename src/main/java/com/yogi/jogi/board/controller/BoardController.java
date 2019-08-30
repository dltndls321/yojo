package com.yogi.jogi.board.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.yogi.jogi.board.model.BoardModel;
import com.yogi.jogi.board.service.BoardService;
import com.yogi.jogi.member.dao.MemberDao;
import com.yogi.jogi.member.model.MemberModel;
import com.yogi.jogi.member.service.MemberService;

@Controller
@RequestMapping("board")
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	ModelAndView mv = new ModelAndView();
	private String boardid;
	private int pageNum;

	@Autowired
	private BoardService boardService;
	@Autowired
	private MemberService memberService;

	@ModelAttribute // 이 어노테이션을 사용하면 메소드에서 선언한 객체가 뷰로 넘어감 글구 가장먼저 실행됨
	public void setAttr(HttpServletRequest request) {

		// boardid와 pageNum 세팅하는 메소드

		HttpSession session = request.getSession();
		String reqboardid = request.getParameter("boardid"); // boardid가 넘어오는지

		if (reqboardid != null)
			session.setAttribute("boardid", reqboardid); // boardid가 있으면 session에 boardid 체크
		if (session.getAttribute("boardid") != null) {

			boardid = (String) session.getAttribute("boardid"); // 오브젝트로 받아오기떄문에 String으로 형변환
		}

		try {
			pageNum = Integer.parseInt(request.getParameter("pageNum")); // pageNum을 세팅하는데 넘어오지않으면 1을 집어넣음
		} catch (Exception e) {
			// TODO: handle exception
			pageNum = 1;
		}

	}

	@RequestMapping("boardlist")
	public ModelAndView list() throws Exception {
		mv.clear();
		int pageSize = 5;// 한 페이지에 최대로 띄울 갯수
		int currentPage = pageNum;
		int count = memberService.selectMemberList().size(); // BoardDBBeanMyBatis에 설정해놓은 boardid
		int startRow = ((currentPage - 1) * pageSize);
		int endRow = currentPage * pageSize;
		if (count < endRow) {
			endRow = count;
		}
		int number = count - ((currentPage - 1) * pageSize);
		int bottomLine = 3; // 페이징 처리시 페이징 최대 갯수
		int pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
		int startPage = 1 + (currentPage - 1) / bottomLine * bottomLine;
		int endPage = startPage + bottomLine - 1;
		if (endPage > pageCount) {
			endPage = pageCount;
		}
		List<BoardModel> boardlist = boardService.selectBoardListPaging(startRow + 1, endRow);

		mv.addObject("boardlist", boardlist);

		mv.addObject("pageCount", pageCount);
		mv.addObject("count", count);
		mv.addObject("pageNum", pageNum);
		mv.addObject("number", number);
		mv.addObject("startPage", startPage);
		mv.addObject("bottomLine", bottomLine);
		mv.addObject("endPage", endPage);
		BoardModel boardModel = new BoardModel();
		boardid = "1";
		
		boardModel.setBoardid(boardid);
		List<BoardModel> AllList = boardService.selectBoardList();
		mv.setViewName("board/boardlist.do");
		mv.addObject("AllList", AllList);

		return mv;
	}

	@RequestMapping("list")
	public ModelAndView list2() throws Exception {
		BoardModel boardModel = new BoardModel();
		boardid = "2";
		boardModel.setBoardid(boardid);
		List<BoardModel> AllList = boardService.selectBoardList();
		mv.setViewName("board/list.do");
		mv.addObject("AllList", AllList);

		return mv;
	}

	@RequestMapping("writeUploadForm")

	public ModelAndView writeForm(BoardModel boardModel,
			@RequestParam(value = "boardid", required = false) String boardid) throws Exception {
		mv.clear();
		boardid="1";
		mv.setViewName("board/writeUploadForm.do");
		mv.addObject("boardid", boardid);
		return mv;
	}
	@RequestMapping("writeUploadForm2")
	public ModelAndView writeForm2(BoardModel boardModel,
			@RequestParam(value = "boardid", required = false) String boardid) throws Exception {
		mv.clear();
		boardid="2";
		mv.setViewName("board/writeUploadForm.do");
		mv.addObject("boardid", boardid);
		return mv;
	}

	@RequestMapping("writePro")
	public String writePro(BoardModel boardModel, HttpSession session) throws Exception {

		boardModel.setMemNum((Integer) session.getAttribute("SessionMemberMemnum"));
		System.out.println(boardModel);
		System.out.println("2" + boardModel);
		boardService.insertBoard(boardModel);
		return "redirect:/board/list";

		// return "redirect:/board/list?pageNum=" + pageNum;

	}

	@RequestMapping("writeUploadPro")
	public String writeUploadPro(MultipartHttpServletRequest multipart, BoardModel boardModel, HttpSession session)
			throws Exception {

		MultipartFile multi = multipart.getFile("uploadfile");
		String fname = multi.getOriginalFilename();
		boardModel.setMemNum((Integer) session.getAttribute("SessionMemberMemnum"));
		System.out.println(boardModel);
		if (fname != null && !fname.equals("")) {

			String uploadPath = multipart.getRealPath("/") + "WEB-INF/views/board/fileSave";

			FileCopyUtils.copy(multi.getInputStream(),
					new FileOutputStream(uploadPath + "/" + multi.getOriginalFilename()));

			boardModel.setFname(fname);
			boardModel.setFsize((int) multi.getSize());
		} else {
			boardModel.setFname("");
			boardModel.setFsize(0);
		}

		boardService.insertBoard(boardModel);
		return "redirect:/board/boardlist";
		// return "redirect:list?pageNum=" + pageNum;
	}

	@RequestMapping("content")
	public ModelAndView content(int boardNum,HttpServletRequest request) throws Exception {
		String id = request.getParameter("id");
		try {
			BoardModel boardModel = new BoardModel();
			if(!boardModel.getWriter().equals(id)) {
				boardService.updateBoard(boardModel);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		mv.clear();
		mv.setViewName("board/content.do"); // 가야할 페이지
		
		mv.addObject("list", boardService.selectBoard(boardNum));
		return mv;

	}

	/*
	 * @RequestMapping("content") public ModelAndView content(BoardModel
	 * boardModel, @RequestParam(value="boardNum", required=false) int boardNum)
	 * throws Exception { System.out.println(boardNum); mv.clear();
	 * mv.setViewName("board/content"); // 가야할 페이지 mv.addObject("list",
	 * boardService.selectBoard(boardNum)); return mv;
	 * 
	 * }
	 */

	@RequestMapping("update/{boardNum}")
	public ModelAndView update(BoardModel boardModel, @PathVariable("boardNum") int boardNum) throws Exception {
		System.out.println(boardModel);
		boardService.updateBoard(boardModel);
		mv.setViewName("board/updateForm.do");
		return mv;
	}

	@RequestMapping("updatePro")
	public ModelAndView updatePro(BoardModel boardModel) throws Exception {
		mv.clear();

		int check = boardService.updateBoard(boardModel);
		System.out.println(check);
		mv.addObject("check", check);
		mv.addObject("pageNum", pageNum);

		mv.setViewName("board/updatePro.do");
		return mv;
	}

	@RequestMapping("delete/{boardNum}")
	public ModelAndView delete(@PathVariable("boardNum") int boardNum) throws Exception {
		mv.clear();

		mv.addObject("boarNum", boardNum);
		mv.addObject("pageNum", pageNum);

		mv.setViewName("board/deleteForm.do");
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



}

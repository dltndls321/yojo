package com.yogi.jogi.board.controller;

import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.SessionScope;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.yogi.jogi.board.model.BoardModel;
import com.yogi.jogi.board.service.BoardService;
import com.yogi.jogi.board.service.ReplyService;
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
	
	@Autowired
	private ReplyService replyService;

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

	@RequestMapping("list")
	public ModelAndView list2(HttpServletRequest request, HttpSession session, MemberModel memberModel,
			@RequestParam(defaultValue = "subject") String searchOption,
			@RequestParam( defaultValue = "") String keyword) throws Exception {
	

		int pageSize = 5;// 한 페이지에 최대로 띄울 갯수
		int currentPage = pageNum;
		int count = boardService.selectBoardListWidhBoardid("1").size(); // BoardDBBeanMyBatis에 설정해놓은 boardid
		int scount = boardService.selectListGetCount(searchOption, keyword,"1");
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

		int start = startRow;
		int end = endRow;
		
		List<BoardModel> list = boardService.selectSearchBoardList(startRow +1, endRow, "1", searchOption, keyword);
		
		/*
		 * List<BoardModel> boardlist = boardService.selectBoardListPaging(startRow + 1,
		 * endRow, "1");
		 */
		
		/*
		 * session = request.getSession(true);
		 * 
		 * String memNum = request.getParameter("memNum");
		 * request.getSession().setAttribute("memNum", memNum);
		 */
		int memNum = (Integer) session.getAttribute("SessionMemberMemnum");
		session.setAttribute("memNum", memNum);
		session.setAttribute("boardid",boardid);
		mv.addObject("boardlist", list);
		mv.addObject("pageCount", pageCount);
		mv.addObject("count", scount);
		mv.addObject("pageNum", pageNum);
		mv.addObject("number", number);
		mv.addObject("startPage", startPage);
		mv.addObject("bottomLine", bottomLine);
		mv.addObject("endPage", endPage);

		List<BoardModel> AllList = boardService.selectBoardList();
		mv.setViewName("board/list.do");
		mv.addObject("AllList", AllList);
		System.out.println(boardid);
		

		return mv;
	}
	@RequestMapping("boardlist")
	public ModelAndView list(HttpServletRequest request, HttpSession session, MemberModel memberModel,
			@RequestParam(defaultValue = "subject") String searchOption,
			@RequestParam(defaultValue = "") String keyword) throws Exception {
		
			
	
			
		
		int pageSize = 5;// 한 페이지에 최대로 띄울 갯수
		int currentPage = pageNum;
		//int count = boardService.selectBoardListWidhBoardid("2").size(); // BoardDBBeanMyBatis에 설정해놓은 boardid
		int count = boardService.selectBoardListWidhBoardid("2").size(); // BoardDBBeanMyBatis에 설정해놓은 boardid
		int scount = boardService.selectListGetCount(searchOption, keyword,"2");
		
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

		int start = startRow;
		int end = endRow;
		
		
		List<BoardModel> list = boardService.selectSearchBoardList(startRow +1, endRow, "2", searchOption, keyword);
		System.out.println("++++"+list);
		
		/*
		 * List<BoardModel> boardlist = boardService.selectBoardListPaging(startRow + 1,
		 * endRow, "2");
		 */

		
		/*
		 * session = request.getSession(true);
		 * 
		 * String memNum = request.getParameter("memNum");
		 * request.getSession().setAttribute("memNum", memNum);
		 */
		int memNum = (Integer) session.getAttribute("SessionMemberMemnum");
		session.setAttribute("memNum", memNum);
		session.setAttribute("boardid",boardid);
		mv.addObject("boardlist", list);  //boardlist list
		mv.addObject("pageCount", pageCount);
		mv.addObject("scount", scount);
		mv.addObject("pageNum", pageNum);
		mv.addObject("number", number);
		mv.addObject("startPage", startPage);
		mv.addObject("bottomLine", bottomLine);
		mv.addObject("endPage", endPage);

		List<BoardModel> AllList = boardService.selectBoardList();
		mv.setViewName("board/boardlist.do");
		mv.addObject("AllList", AllList);
		
		

		return mv;
	}


	@RequestMapping("writeForm")

	public ModelAndView writeForm(BoardModel boardModel,
			@RequestParam(value = "boardid", required = false) String boardid) throws Exception {
		mv.clear();
		boardid = "1";
		mv.setViewName("board/writeForm.do");
		mv.addObject("boardid", boardid);
		return mv;
	}

	@RequestMapping("writeUploadForm")
	public ModelAndView writeForm2(BoardModel boardModel,
			@RequestParam(value = "boardid", required = false) String boardid) throws Exception {
		mv.clear();
		boardid = "2";
		mv.setViewName("board/writeUploadForm.do");
		mv.addObject("boardid", boardid);
		return mv;
	}

	@RequestMapping("writePro")
	public String writePro(MultipartHttpServletRequest multipart, BoardModel boardModel, HttpSession session)
			throws Exception {

		MultipartFile multi = multipart.getFile("uploadfile");
		String fname = "http://211.63.89.83:8888/resources/fileSave/" + multi.getOriginalFilename();
//		String fname = "http://211.63.89.29:31235/resources/fileSave/" + multi.getOriginalFilename();
		boardModel.setMemNum((Integer) session.getAttribute("SessionMemberMemnum"));
		System.out.println(boardModel);
		if (fname != null && !fname.equals("http://211.63.89.83:8888/resources/fileSave/")) {
//		if (fname != null && !fname.equals("http://211.63.89.29:31235/resources/fileSave/")) {
			String uploadPath = "D:/workspace/yojo/src/main/webapp/resources/fileSave/";
//			String uploadPath = "C:/Users/PC/Desktop/soosoo/yogijogi/workspace/yojo/src/main/webapp/resources/fileSave/";
			
			FileCopyUtils.copy(multi.getInputStream(),
					new FileOutputStream(uploadPath + "/" + multi.getOriginalFilename()));

			boardModel.setFname(fname);
			boardModel.setFsize((int) multi.getSize());
		} else {
			boardModel.setFname("");
			boardModel.setFsize(0);
		}

		boardService.insertBoard(boardModel);
		return "redirect:/board/list";
		// return "redirect:list?pageNum=" + pageNum;
	}



	@RequestMapping("writeUploadPro")
	public String writeUploadPro(MultipartHttpServletRequest multipart, BoardModel boardModel, HttpSession session)
			throws Exception {

		MultipartFile multi = multipart.getFile("uploadfile");
		String fname = "http://211.63.89.75:9080/resources/fileSave/" + multi.getOriginalFilename();
//		String fname = "http://211.63.89.29:31235/resources/fileSave/" + multi.getOriginalFilename();
		boardModel.setMemNum((Integer) session.getAttribute("SessionMemberMemnum"));
		System.out.println(boardModel);
		if (fname != null && !fname.equals("http://211.63.89.75:9080/resources/fileSave/")) {
//		if (fname != null && !fname.equals("http://211.63.89.29:31235/resources/fileSave/")) {
			String uploadPath = "C:/hyeyeon/Java/WorkSpace/yojo/src/main/webapp/resources/fileSave/";
//			String uploadPath = "C:/Users/PC/Desktop/soosoo/yogijogi/workspace/yojo/src/main/webapp/resources/fileSave/";
			
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

	@RequestMapping(value = "content", method = RequestMethod.GET)
	public ModelAndView content(@RequestParam("boardNum") int boardNum, MemberModel memberModel, HttpSession session)
			throws Exception {

		mv.clear();
		int count = replyService.replyCount();
		int memNum = (Integer) session.getAttribute("SessionMemberMemnum");
		session.setAttribute("memNum", memNum);
		session.setAttribute("boardNum", boardNum);
		mv.addObject("memNum", memNum);
		mv.addObject("count",replyService.replyCount());
		mv.addObject("list", boardService.selectBoard(boardNum));
		System.out.println(boardNum);
		mv.addObject("memberModel", new MemberModel());
		mv.setViewName("board/content.do"); // 가야할 페이지

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
	@RequestMapping("updatePro2")
	public ModelAndView updatePro2(BoardModel boardModel) throws Exception {
		mv.clear();

		int check = boardService.updateBoard(boardModel);
		System.out.println(check);
		mv.addObject("check", check);
		mv.addObject("pageNum", pageNum);

		mv.setViewName("board/updatePro2.do");
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
		mv.setViewName("board/deletePro.do");
		return mv;

	}
	@RequestMapping("deletePro2")
	public ModelAndView deletePro2(BoardModel boardModel) throws Exception {
		// private passwd 선언하면 안됨
		int check = boardService.deleteBoard(boardModel);
		mv.clear();
		mv.addObject("check", check);
		mv.addObject("pageNum", pageNum);
		mv.setViewName("board/deletePro2.do");
		return mv;

	}
	@RequestMapping("nextboard")
	public ModelAndView nextboard(BoardModel boardModel,int boardNum) throws Exception{
		
		boardService.nextboard(boardNum);
		return mv;
	}
}

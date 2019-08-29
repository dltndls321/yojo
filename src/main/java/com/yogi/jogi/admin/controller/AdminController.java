package com.yogi.jogi.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yogi.jogi.board.model.BoardModel;
import com.yogi.jogi.board.service.BoardService;
import com.yogi.jogi.common.model.NowUserModel;
import com.yogi.jogi.common.service.FestReviewService;
import com.yogi.jogi.common.service.FestService;
import com.yogi.jogi.common.service.SpotService;
import com.yogi.jogi.member.model.MemberDetailModel;
import com.yogi.jogi.member.model.MemberModel;
import com.yogi.jogi.member.service.MemberService;

@Controller
@RequestMapping(value = "admin")
public class AdminController {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	private static NowUserModel nowUser;
	ModelAndView mv = new ModelAndView();
	
	private int pageNum;
	private String boardid;

	MemberDetailModel memberDetailModel = new MemberDetailModel();

	@Autowired
	private MemberService memberService;
	@Autowired
	private BoardService boardService;
	@Autowired
	private FestService festService;
	@Autowired
	private FestReviewService festReviewService;
	@Autowired
	private SpotService spotService;

	@ModelAttribute
	public void setAttr(HttpServletRequest request) {

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
			pageNum = 1;
		}
	}

	@RequestMapping(value = "main")
	public ModelAndView moveMain(HttpSession session) throws Exception{
		mv.clear();
		mv.setViewName("admin/main.admin");
		int nowuser = nowUser.getNowUser();//현재 접속중인 인원
		int totalmember = memberService.selectMemberList().size();//가입한 총 회원수
//		int totalboard = boardService.selectBoardList(boardModel);
		mv.addObject("totalmember",totalmember);
		mv.addObject("nowuser",nowuser);
		return mv;
	}

	@RequestMapping(value = "board")
	public ModelAndView moveBoard() throws Exception {

		mv.clear();

		BoardModel boardModel = new BoardModel();

		boardid = "1";
		boardModel.setBoardid(boardid);

		int pageSize = 6;
		int currentPage = pageNum;
		int count = boardService.selectBoardList().size(); // BoardDBBeanMyBatis에 설정해놓은 boardid
		int startRow = (currentPage - 1) * pageSize;
		int endRow = currentPage * pageSize;
		if (count < endRow)
			endRow = count;

		List<BoardModel> boardlist = boardService.selectBoardList();

		int number = count - ((currentPage - 1) * pageSize);

		int bottomLine = 3; // 5 page
		int pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
		int startPage = 1 + (currentPage - 1) / bottomLine * bottomLine;
		int endPage = startPage + bottomLine - 1;
		if (endPage > pageCount)
			endPage = pageCount;

		mv.addObject("count", count);
		mv.addObject("pageNum", pageNum);

		mv.addObject("boardlist", boardlist);

		mv.addObject("number", number);
		mv.addObject("startPage", startPage);
		mv.addObject("bottomLine", bottomLine);
		mv.addObject("endPage", endPage);

		mv.setViewName("admin/board.admin");

		return mv;

	}

	@RequestMapping(value = "boardContent/{boardNum}")
	public ModelAndView moveBoardContent(BoardModel boardModel, @PathVariable("boardNum") int boardNum)
			throws Exception {

		mv.clear();

		boardModel.setBoardNum(boardNum);
		boardModel = boardService.selectBoard(boardNum);

		mv.addObject("boardModel", boardModel);
		mv.setViewName("admin/boardContent");

		return mv;
	}

	@RequestMapping(value = "boardDelete/{boardNum}")
	public ModelAndView moveBoardDelete(BoardModel boardModel, @PathVariable("boardNum") int boardNum)
			throws Exception {

		mv.clear();

		boardModel.setBoardNum(boardNum);
		boardModel = boardService.selectBoard(boardNum);
		boardService.deleteBoard(boardModel);

		List<BoardModel> boardlist = boardService.selectBoardList();

		mv.addObject("boardlist", boardlist);
		mv.setViewName("admin/board.admin");

		return mv;
	}

	@RequestMapping(value = "memberList")
	public ModelAndView moveMemberList() throws Exception {

		mv.clear();

		int pageSize = 11;
		int currentPage = pageNum;
		int count = memberService.selectMemberList().size(); // BoardDBBeanMyBatis에 설정해놓은 boardid
		int startRow = (currentPage - 1) * pageSize;
		int endRow = currentPage * pageSize;
		if (count < endRow)
			endRow = count;

		List memberList = memberService.selectMemberList();

		int number = count - ((currentPage - 1) * pageSize);

		int bottomLine = 3; // 5 page
		int pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
		int startPage = 1 + (currentPage - 1) / bottomLine * bottomLine;
		int endPage = startPage + bottomLine - 1;
		if (endPage > pageCount)
			endPage = pageCount;

		mv.addObject("count", count);
		mv.addObject("pageNum", pageNum);

		mv.addObject("memberList", memberList);

		mv.addObject("number", number);
		mv.addObject("startPage", startPage);
		mv.addObject("bottomLine", bottomLine);
		mv.addObject("endPage", endPage);

		mv.setViewName("admin/memberList.admin");

		return mv;
	}

	@RequestMapping(value = "memberProfile/{memnum}")
	public ModelAndView moveMemberProfile(MemberModel memberModel, @PathVariable("memnum") int memnum)
			throws Exception {

		mv.clear();

		memberModel.setMemnum(memnum);
		memberModel = memberService.selectMemberWithMemNum(memberModel);

		String[] splitAddress = memberModel.getAddress().split("/");
		String[] splitPhone = memberModel.getPhone().split("-");
		String[] splitJumin = memberModel.getJumin().split("-");

		for (int i = 0; i < 3; i++) {
			if (i == 0) {
				memberDetailModel.setPostcode(splitAddress[i]);
			} else if (i == 1) {
				memberDetailModel.setAddress1(splitAddress[i]);
			} else {
				memberDetailModel.setDetailAddress(splitAddress[i]);
			}
		}

		for (int i = 0; i < 3; i++) {
			if (i == 0) {
				memberDetailModel.setPhone1(splitPhone[i]);
			} else if (i == 1) {
				memberDetailModel.setPhone2(splitPhone[i]);
			} else {
				memberDetailModel.setPhone3(splitPhone[i]);
			}
		}

		for (int i = 0; i < 2; i++) {
			if (i == 0) {
				memberDetailModel.setJumin1(splitJumin[i]);
			} else if (i == 1) {
				memberDetailModel.setJumin2(splitJumin[i]);
			}
		}

		mv.addObject("memberInfo", memberModel);
		mv.addObject("memberDetailInfo", memberDetailModel);
		mv.setViewName("admin/memberProfile.admin");

		return mv;
	}

	@RequestMapping(value = "updateMember/{memnum}")
	public ModelAndView moveUpdateMember(MemberDetailModel memberDetailModel, @PathVariable("memnum") int memnum)
			throws Exception {

		mv.clear();

		MemberModel memberModel = new MemberModel();
		memberModel.setMemnum(memnum);
		memberModel = memberService.selectMemberWithMemNum(memberModel);

		memberModel.setId(memberDetailModel.getId());
		memberModel.setPasswd(memberDetailModel.getPasswd());

		memberModel.setName(memberDetailModel.getName());
		memberModel.setEmail(memberDetailModel.getEmail());
		memberModel.setPhone(memberDetailModel.getPhone1() + "-" + memberDetailModel.getPhone2() + "-"
				+ memberDetailModel.getPhone3());
		memberModel.setAddress(memberDetailModel.getPostcode() + "/" + memberDetailModel.getAddress1() + "/"
				+ memberDetailModel.getDetailAddress());
		memberModel.setJumin(memberDetailModel.getJumin1() + "-" + memberDetailModel.getJumin2());

		memberService.updateMember(memberModel);

		mv.addObject("memberInfo", memberModel);
		mv.addObject("memberDetailInfo", memberDetailModel);
		mv.setViewName("admin/memberProfile.admin");

		return mv;
	}

	@RequestMapping(value = "deleteMember/{memnum}")
	public ModelAndView moveDeleteMember(MemberModel memberModel, @PathVariable("memnum") int memnum) throws Exception {

		mv.clear();

		memberModel.setMemnum(memnum);
		memberModel = memberService.selectMemberWithMemNum(memberModel);
		memberService.deleteMember(memberModel);

		List memberList = memberService.selectMemberList();
		mv.addObject("memberList", memberList);
		mv.setViewName("admin/memberList.admin");

		return mv;
	}

	@RequestMapping(value = "customerCenter")
	public String moveCustomerCenter() {
		return "admin/customerCenter.admin";
	}

	@RequestMapping(value = "customerCenterMessage")
	public String moveCustomerCenterMessage() {
		return "admin/customerCenterMessage.admin";
	}

	@RequestMapping(value = "booking")
	public String moveBookings() {
		return "admin/booking.admin";
	}

	@RequestMapping(value = "reviews")
	public String moveReviews() {
		return "admin/reviews.admin";
	}

}

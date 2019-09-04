package com.yogi.jogi.admin.controller;


import java.io.PrintWriter;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.yogi.jogi.admin.model.AdminCourseModel;
import com.yogi.jogi.admin.service.AdminCourseService;
import com.yogi.jogi.board.model.BoardModel;
import com.yogi.jogi.board.service.BoardService;
import com.yogi.jogi.common.model.FestivalModel;
import com.yogi.jogi.common.model.FoodModel;
import com.yogi.jogi.common.model.NowUserModel;
import com.yogi.jogi.common.model.SpotModel;
import com.yogi.jogi.common.service.FestReviewService;
import com.yogi.jogi.common.service.FestService;
import com.yogi.jogi.common.service.FoodService;
import com.yogi.jogi.common.service.SpotReviewService;
import com.yogi.jogi.common.service.SpotService;
import com.yogi.jogi.member.model.MemberDetailModel;
import com.yogi.jogi.member.model.MemberModel;
import com.yogi.jogi.member.service.MemberService;

import net.sf.json.JSONArray;

@Controller
@RequestMapping(value = "admin")
public class AdminController {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	static NowUserModel nowUser;
	
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
	@Autowired
	private SpotReviewService spotReviewService;
	@Autowired
	private FoodService foodService;
	@Autowired
	private AdminCourseService adminCourseService;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

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
		MemberModel memberModel = new MemberModel(); 
		memberModel.setMemnum((Integer)session.getAttribute("SessionMemberMemnum"));
		memberModel = memberService.selectMemberWithMemNum(memberModel);
		Date start = Date.from(LocalDateTime.now().minusDays(1).atZone(ZoneId.of("Asia/Seoul").systemDefault()).toInstant());
		Date end = Date.from(LocalDateTime.now().atZone(ZoneId.of("Asia/Seoul").systemDefault()).toInstant());
		System.out.println(start+ " and " +end);
		List<MemberModel> dateMembermodel = memberService.selectMemberbetweenDate(start, end);
		int nowuser = nowUser.getNowUser();//현재 접속중인 인원
		int totalmember = memberService.selectMemberList().size();//가입한 총 회원수
		int totalboard = boardService.selectBoardList().size();
		int totalreview = festReviewService.selectFestReviewList().size() + spotReviewService.selectSpotReviewList().size();
		
		mv.addObject("adminInfo", memberModel);
		mv.addObject("totalmember",totalmember);
		mv.addObject("nowuser",nowuser);
		mv.addObject("totalboard",totalboard);
		mv.addObject("totalreview",totalreview);
		mv.addObject("dateMembermodel",dateMembermodel);
		return mv;
	}

	@RequestMapping(value = "board")
	public ModelAndView moveBoard() throws Exception {

		mv.clear();

		BoardModel boardModel = new BoardModel();

		boardid = "1";
		boardModel.setBoardid(boardid);

		int pageSize = 2;
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
		
		
		
		int pageSize = 5;//한 페이지에 최대로 띄울 갯수
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
		List<MemberModel> memberList = memberService.selectMemberListPaging(startRow +1, endRow);
		LocalDateTime now = LocalDateTime.now();//로컬데이트타임 현재
		List<LocalDateTime> regdate =  new ArrayList<LocalDateTime>();//새 리스트
		for(int i=0;i<memberList.size();i++) {
			regdate.add(memberList.get(i).getRegdate().toInstant().atZone(ZoneId.of("Asia/Seoul").systemDefault()).toLocalDateTime());
		}//db에 있는 regdate를 로컬데이트로 타입 변환 후 삽입
		LocalDateTime startdate = now.minusDays(1);//현재 시간보다 하루 적은 날짜
		
		mv.addObject("memberList", memberList);
		
		
		mv.addObject("pageCount",pageCount);
		mv.addObject("count", count);
		mv.addObject("pageNum", pageNum);
		mv.addObject("number", number);
		mv.addObject("startPage", startPage);
		mv.addObject("bottomLine", bottomLine);
		mv.addObject("endPage", endPage);
		mv.addObject("now",now);
		mv.addObject("regdate",regdate);
		mv.addObject("startdate",startdate);
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
	@RequestMapping(value = "course")
	public String addCourse() {
		return "admin/addCourse.admin";
	}
	@RequestMapping(value = "adminfood")
	public void selectFood(HttpServletRequest request, HttpServletResponse response, @RequestParam int areaCode, @RequestParam String foodCode) throws Exception {
		request.setCharacterEncoding("utf-8");
		FoodModel foodModel = new FoodModel();
		foodModel.setCategory(foodCode);
		foodModel.setZcode(areaCode);
		System.out.println(foodModel);
		
		JSONArray jsonArray = new JSONArray();
		try {
			List<FoodModel> foodList = foodService.selectFoodAdmin(foodModel);
			if(foodList != null && foodList.size() >0) {
				for (int i = 0; i < foodList.size(); i++) {
					jsonArray.add(foodList.get(i));
				}
			}
			response.setContentType("text/xml;charset=utf-8");
			PrintWriter printWriter = response.getWriter();
			printWriter.print(jsonArray.toString());
			printWriter.flush();
			printWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		System.out.println(jsonArray);
	}
	
	@RequestMapping(value = "adminfest")
	
	public void selectFest(HttpServletRequest request, HttpServletResponse response, @RequestParam int areaCode, @RequestParam Date date) throws Exception {
		request.setCharacterEncoding("utf-8");
		System.out.println(date);
		FestivalModel festivalModel = new FestivalModel();
		festivalModel.setFdate2(date);
		festivalModel.setZcode(areaCode);
		System.out.println(festivalModel);
		
		JSONArray jsonArray = new JSONArray();
		try {
			List<FestivalModel> festList = festService.selectFestAdmin(festivalModel);
			System.out.println("여기"+festList);
			if(festList != null && festList.size() >0) {
				for (int i = 0; i < festList.size(); i++) {
					jsonArray.add(festList.get(i));
				}
			}
			response.setContentType("text/xml;charset=utf-8");
			PrintWriter printWriter = response.getWriter();
			printWriter.print(jsonArray.toString());
			printWriter.flush();
			printWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		System.out.println(jsonArray);
		
	}
	@RequestMapping(value = "adminspot")
	public void selectSpot(HttpServletRequest request, HttpServletResponse response, @RequestParam int areaCode, @RequestParam String spotCode) throws Exception {
		request.setCharacterEncoding("utf-8");
		SpotModel spotModel = new SpotModel();
		spotModel.setCategory(spotCode);
		spotModel.setZcode(areaCode);
		System.out.println(spotModel);
		
		JSONArray jsonArray = new JSONArray();
		try {
			List<SpotModel> spotList = spotService.selectSpotAdmin(spotModel);
			if(spotList != null && spotList.size() >0) {
				for (int i = 0; i < spotList.size(); i++) {
					jsonArray.add(spotList.get(i));
				}
			}
			response.setContentType("text/xml;charset=utf-8");
			PrintWriter printWriter = response.getWriter();
			printWriter.print(jsonArray.toString());
			printWriter.flush();
			printWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		System.out.println(jsonArray);
	}
	@RequestMapping(value = "chkCourse")
	public ModelAndView chkCourse(HttpServletRequest request, HttpServletResponse response,AdminCourseModel adminCourseModel,
			@RequestParam String title, @RequestParam String theme, @RequestParam String arrayspot,@RequestParam String arrayfood,
			@RequestParam String food, @RequestParam int area, @RequestParam String spot,@RequestParam String fest,
			@RequestParam Date startdate, @RequestParam Date enddate ) throws Exception  {
		
	
		String[] foodList = food.split(",");
		String[] spotList = spot.split(",");

		adminCourseModel.setSubject(title);
		adminCourseModel.setTheme(theme);
		adminCourseModel.setStartDate(startdate);
		adminCourseModel.setEndDate(enddate);
		adminCourseModel.setAreaCode(area);
		adminCourseModel.setFoodCode(arrayfood);
		adminCourseModel.setSpotCode(arrayspot);
		adminCourseModel.setCourse1(foodList[0]);
		adminCourseModel.setCourse2(spotList[0]);
		adminCourseModel.setCourse3(foodList[1]);
		adminCourseModel.setCourse4(spotList[1]);
		adminCourseModel.setCourse5(foodList[2]);
		adminCourseModel.setCourse6(fest);
		
		System.out.println(adminCourseModel);
		
		adminCourseService.insertCourse(adminCourseModel);

		mv.clear();
		mv.addObject("title", title);
		mv.addObject("theme", theme);
		mv.addObject("arrayspot", arrayspot);
		mv.addObject("arrayfood", arrayfood);
		mv.addObject("food", foodList);
		mv.addObject("area", area);
		mv.addObject("spot", spotList);
		mv.addObject("fest", fest);
		mv.addObject("startdate", startdate);
		mv.addObject("enddate", enddate);
		
		mv.setViewName("admin/chkCourse.admin");
		return mv;
	}
	

}

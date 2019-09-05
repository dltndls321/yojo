package com.yogi.jogi.member.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.yogi.jogi.board.model.BoardModel;
import com.yogi.jogi.board.service.BoardService;
import com.yogi.jogi.common.model.FestReviewModel;
import com.yogi.jogi.common.model.FestivalModel;
import com.yogi.jogi.common.model.NowUserModel;
import com.yogi.jogi.common.model.SpotModel;
import com.yogi.jogi.common.model.SpotReviewModel;
import com.yogi.jogi.common.service.FestReviewService;
import com.yogi.jogi.common.service.FestService;
import com.yogi.jogi.common.service.MailService;
import com.yogi.jogi.common.service.OauthService;
import com.yogi.jogi.common.service.SpotReviewService;
import com.yogi.jogi.common.service.SpotService;
import com.yogi.jogi.member.model.MemberDetailModel;
import com.yogi.jogi.member.model.MemberModel;
import com.yogi.jogi.member.service.MemberService;

@Controller
@RequestMapping(value = "member")
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	ModelAndView model = new ModelAndView();
	static NowUserModel nowUser;
	@Autowired
	private MemberService memberService;
	@Autowired
	private FestReviewService festReviewService;
	@Autowired
	private FestService festService;
	@Autowired
	private SpotService spotService;
	@Autowired
	private SpotReviewService spotReviewService;
	@Autowired
	private BoardService boardSerivce;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private OauthService oauthService;
	@Autowired
	private MailService mailService;
	/* 회원가입/로그인/로그아웃 */
	@RequestMapping(value = "registemember")
	public ModelAndView registemember(MemberDetailModel memberDetailModel, HttpSession session) throws Exception {
		System.out.println("registemember : 시작");
		model.clear();
		String[] tokkenItems = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
		String tokken = "";
		for(int i = 0 ; i<5 ; i++) {
			int index = (int)(Math.random()*tokkenItems.length);
			tokken = tokken + tokkenItems[index];
		}
		int nowuser = 0;
		if(nowUser.getNowUser() <=0) {
			nowuser = 0;
		}else {
			nowuser = nowUser.getNowUser();
		} 
		MemberModel memberModel = new MemberModel();
		memberModel.setId(memberDetailModel.getId());
		memberModel.setEmail(memberDetailModel.getEmail());
		memberModel.setName(memberDetailModel.getName());
		memberModel.setPhone(memberDetailModel.getPhone1() + "-" + memberDetailModel.getPhone2() + "-"
				+ memberDetailModel.getPhone3());
		memberModel.setPasswd(memberDetailModel.getPasswd());
		memberModel.setAddress(memberDetailModel.getPostcode() + "/" + memberDetailModel.getAddress1() + "/"
				+ memberDetailModel.getDetailAddress());
		memberModel.setJumin(memberDetailModel.getJumin1() + "-" + memberDetailModel.getJumin2());
		memberModel.setStatus("1");
		memberModel.setTokken(tokken);
		memberService.insertMember(memberModel);
		mailService.send("요기조기 인증 메일 입니다.", "귀하의 인증 번호는 " + tokken + "입니다.","d178961@gmail.com",memberModel.getEmail(), null);
		memberModel = memberService.selectMemberWithEmail(memberModel);
		System.out.println("맴버 번호 >>" + memberModel.getMemnum());
		System.out.println("아이디 >>" + memberModel.getId());
		System.out.println("비밀번호 >>" + memberModel.getPasswd());
		session.setAttribute("SessionMemberMemnum", memberModel.getMemnum());
		session.setAttribute("SessionMemberId", memberModel.getId());
		session.setAttribute("SessionMemberName", memberModel.getName());
		session.setAttribute("SessionMemberStatus", memberModel.getStatus());
		nowUser.setNowUser(nowuser);
		if(memberModel.getId().equals("admin")) {
			memberModel.setStatus("2");
			memberService.updateMemberStatus(memberModel);
			model.setViewName("redirect:/admin/main");
		}else {
			model.setViewName("redirect:/main/main");
		}
		model.addObject("InfoMember", memberModel);
		return model;
	}
	@RequestMapping(value = "kakaoregisterDone")
	public ModelAndView kakaoregisterDone(MemberDetailModel memberDetailModel, HttpSession session) throws Exception {
		System.out.println("registemember : 시작");
		model.clear();
		int nowuser = 0;
		if(nowUser.getNowUser() <=0) {
			nowuser = 0;
		}else {
			nowuser = nowUser.getNowUser();
		} 
		MemberModel memberModel = new MemberModel();
		memberModel.setId(memberDetailModel.getId());
		memberModel.setEmail(memberDetailModel.getEmail());
		memberModel.setName(memberDetailModel.getName());
		memberModel.setPhone(memberDetailModel.getPhone1() + "-" + memberDetailModel.getPhone2() + "-"
				+ memberDetailModel.getPhone3());
		memberModel.setPasswd(memberDetailModel.getPasswd());
		memberModel.setAddress(memberDetailModel.getPostcode() + "/" + memberDetailModel.getAddress1() + "/"
				+ memberDetailModel.getDetailAddress());
		memberModel.setJumin(memberDetailModel.getJumin1() + "-" + memberDetailModel.getJumin2());
		memberModel.setStatus(memberDetailModel.getStatus());
		memberModel.setTokken(memberDetailModel.getTokken());
		memberService.insertMember(memberModel);
		memberModel = memberService.selectMemberWithEmail(memberModel);
		System.out.println("맴버 번호 >>" + memberModel.getMemnum());
		System.out.println("아이디 >>" + memberModel.getId());
		System.out.println("비밀번호 >>" + memberModel.getPasswd());
		session.setAttribute("SessionMemberMemnum", memberModel.getMemnum());
		session.setAttribute("SessionMemberId", memberModel.getId());
		session.setAttribute("SessionMemberName", memberModel.getName());
		session.setAttribute("SessionMemberStatus", memberModel.getStatus());
		nowUser.setNowUser(nowuser);
		model.setViewName("redirect:/main/main");
		model.addObject("InfoMember", memberModel);
		return model;
	}
	
	

	@RequestMapping(value = "loginmember")
	public ModelAndView loginmember(MemberModel memberModel, HttpSession session) throws Exception {
		System.out.println("loginmember : 시작");
		model.clear();
		int nowuser = 0;
		if(nowUser.getNowUser() <=0) {
			nowuser = 0;
		}else {
			nowuser = nowUser.getNowUser();
		}
		memberModel = memberService.selectMemberWithId(memberModel);
		System.out.println("맴버 번호 >>" + memberModel.getMemnum());
		System.out.println("아이디 >>" + memberModel.getId());
		System.out.println("비밀번호 >>" + memberModel.getPasswd());
		session.setAttribute("SessionMemberMemnum", memberModel.getMemnum());
		session.setAttribute("SessionMemberId", memberModel.getId());
		session.setAttribute("SessionMemberName", memberModel.getName());
		session.setAttribute("SessionMemberStatus", memberModel.getStatus());
		if (memberModel.getId().equals("admin")) {
			model.setViewName("redirect:/admin/main");
		} else {
			model.setViewName("redirect:/main/main");
		}
		model.addObject("InfoMember", memberModel);
		nowUser.setNowUser(nowuser);
		return model;
	}

	@RequestMapping(value = "logout")
	public String logout(HttpSession session) throws Exception{
		if(session.getAttribute("SessionMemberMemnum")!=null){
			MemberModel memberModel = new MemberModel();
			memberModel.setMemnum((Integer)session.getAttribute("SessionMemberMemnum"));
			memberModel= memberService.selectMemberWithMemNum(memberModel);
			if(memberModel.getStatus().equals("3")) {
				System.out.println(memberModel.getTokken());
				oauthService.logoutKakaoInfo(memberModel.getTokken());
			}
		}
		session.invalidate();
		int nowuser = nowUser.getNowUser();
		nowUser.setNowUser(nowuser-2);
		return "redirect:/main/main";
	}

	/* 멤버프로필 */
	@RequestMapping(value = "profile")
	public ModelAndView profile(HttpSession session) throws Exception {
		System.out.println("member/profile  : 시작");
		model.clear();
		MemberModel memberModel = new MemberModel();
		FestReviewModel festReviewModel = new FestReviewModel();
		FestivalModel festivalModel = new FestivalModel();
		SpotReviewModel spotReviewModel = new SpotReviewModel();
		BoardModel boardModel = new BoardModel();
		SpotModel spotModel = new SpotModel();
		spotReviewModel.setMemNum((Integer) session.getAttribute("SessionMemberMemnum"));
		festReviewModel.setMemNum((Integer) session.getAttribute("SessionMemberMemnum"));
		boardModel.setMemNum((Integer) session.getAttribute("SessionMemberMemnum"));
		List<FestReviewModel> reviewList = festReviewService.selectFestReviewWithMemNum(festReviewModel);
		List<FestivalModel> festList = new ArrayList<FestivalModel>();
		List<BoardModel> boardList = boardSerivce.selectBoardListWidhMemnum(boardModel);
		int reviewListsize = reviewList.size();
		int star = 0;
		double avg=0;
		if(reviewListsize!=0) {
			for(int i = 0 ; i<reviewListsize;i++) {
				star = star + reviewList.get(i).getStar();
				int festnum = reviewList.get(i).getFestNum();
				festivalModel.setFestNum(festnum);
				festivalModel = festService.selectFestWithFestNum(festivalModel);
				festList.add(festivalModel);
			}
			avg =((double)((star*10)/reviewListsize))/10;
		}
		List<SpotReviewModel> spotReviewList = spotReviewService.selectSpotReviewWithMemNum(spotReviewModel);
		List<SpotModel> spotList = new ArrayList<SpotModel>();
		int spotreviewListsize = spotReviewList.size();
		int spotstar = 0;
		double spotavg=0;
		if(spotreviewListsize!=0) {
			for(int i = 0 ; i<spotreviewListsize;i++) {
				spotstar = spotstar + spotReviewList.get(i).getStar();
				int spotNum = spotReviewList.get(i).getSpotNum();
				spotModel.setSpotNum(spotNum);
				spotModel = spotService.selectSpotWithSpotNum(spotModel);
				spotList.add(spotModel);
			}
			spotavg =((double)((spotstar*10)/spotreviewListsize))/10;
		}
		if(avg != 0 && spotavg != 0) {
			avg = (double)(((int)((avg+spotavg)*10))/2)/10;
		}else if(avg==0 && spotavg != 0 ) {
			avg=spotavg;
		}
		System.out.println(avg);
		System.out.println(spotavg);
		System.out.println("세션번호  : " + (Integer) session.getAttribute("SessionMemberMemnum"));
		memberModel.setMemnum((Integer) session.getAttribute("SessionMemberMemnum"));
		System.out.println("memberModel셋 memNum  : " + memberModel);
		memberModel = memberService.selectMemberWithMemNum(memberModel);
		System.out.println("memberModel 다시 : " + memberModel);
		
		model.addObject("memberInfo", memberModel);
		model.addObject("reviewListsize",reviewListsize);
		model.addObject("avg",avg);
		model.addObject("reviewList",reviewList);
		model.addObject("festList",festList);
		model.addObject("spotReviewList",spotReviewList);
		model.addObject("spotList",spotList);
		model.addObject("spotreviewListsize",spotreviewListsize);
		model.addObject("boardList",boardList);
		System.out.println("memberprofile 최종");
		model.setViewName("member/memberprofile.do");
		return model;
	}
	
	@RequestMapping(value = "updateMember")
	public ModelAndView updateMember(MemberModel memberModel,HttpSession session) throws Exception {
		System.out.println("member/updateMember  : 시작");
		model.clear();
		MemberDetailModel memberDetailModel = new MemberDetailModel();
		System.out.println("세션번호  : " + (Integer) session.getAttribute("SessionMemberMemnum"));
		memberModel.setMemnum((Integer) session.getAttribute("SessionMemberMemnum"));
		System.out.println("memberModel셋 memNum  : " + memberModel);
		memberModel = memberService.selectMemberWithMemNum(memberModel);
		System.out.println("memberModel 다시 : " + memberModel);

		String[] splitAddress = memberModel.getAddress().split("/");
		String[] splitPhone = memberModel.getPhone().split("-");
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
		model.addObject("memberInfo", memberModel);
		model.addObject("memberDetailInfo", memberDetailModel);
		model.setViewName("member/updateMember.do");
		return model;
	}

	@RequestMapping(value = "updateMemberDone")
	public ModelAndView updateMemberDone(MemberDetailModel memberDetailModel, HttpSession session) throws Exception {
		model.clear();
		MemberModel memberModel = new MemberModel();
		memberModel.setMemnum((Integer) session.getAttribute("SessionMemberMemnum"));
		memberModel = memberService.selectMemberWithMemNum(memberModel);
		memberModel.setName(memberDetailModel.getName());
		memberModel.setEmail(memberDetailModel.getEmail());
		memberModel.setPhone(memberDetailModel.getPhone1() + "-" + memberDetailModel.getPhone2() + "-"
				+ memberDetailModel.getPhone3());
		memberModel.setAddress(memberDetailModel.getPostcode() + "/" + memberDetailModel.getAddress1() + "/"
				+ memberDetailModel.getDetailAddress());
		System.out.println(memberModel);
		memberService.updateMember(memberModel);
		model.setViewName("member/updateMember.do");
		model.addObject("memberInfo", memberModel);
		model.addObject("memberDetailInfo", memberDetailModel);
		return model;
	}
	@RequestMapping(value = "changePasswdDone")
	public ModelAndView changePasswdDone(@RequestParam String passwd, HttpSession session) throws Exception {
		model.clear();
		MemberModel memberModel = new MemberModel();
		memberModel.setMemnum((Integer) session.getAttribute("SessionMemberMemnum"));
		memberModel = memberService.selectMemberWithMemNum(memberModel);
		memberModel.setPasswd(passwd);
		System.out.println(memberModel);
		memberService.updateMember(memberModel);
		model.setViewName("redirect:/member/updateMember.do");
		return model;
	}
	@RequestMapping(value = "deleteMember")
	public ModelAndView deleteMember(HttpSession session)throws Exception{
		model.clear();
		MemberModel memberModel = new MemberModel();
		memberModel.setMemnum((Integer) session.getAttribute("SessionMemberMemnum"));
		memberModel = memberService.selectMemberWithMemNum(memberModel);
		if(memberModel.getStatus().equals("3")) {
			Map<String, Object> resultMap = oauthService.selectKakaoInfo(memberModel.getTokken());
			oauthService.deleteKakaoInfo(resultMap);
		}
		memberService.deleteMember(memberModel);
		session.invalidate();
		int nowuser = nowUser.getNowUser();
		nowUser.setNowUser(nowuser-2);
		model.setViewName("redirect:/main/main");
		return model;
	}
	@RequestMapping(value = "kakaoRegister")
	public ModelAndView kakaoRegister(HttpSession session) throws Exception {
		model.clear();
		MemberModel memberModel = new MemberModel();
		memberModel.setName((String) session.getAttribute("kakaoName"));
		memberModel.setEmail((String) session.getAttribute("kakaoEmail"));
		memberModel.setPasswd((String)session.getAttribute("kakaoPasswd"));
		memberModel.setTokken((String)session.getAttribute("kakaoTokken"));
		memberModel.setStatus((String)session.getAttribute("kakaoStatus"));
		memberModel.setId((String)session.getAttribute("kakaoId"));
		System.out.println(memberModel);
		model.setViewName("member/kakaoRegister.do");
		model.addObject("memberInfo", memberModel);
		return model;
	}
	
	

	// ajax 컨트롤러들
	@RequestMapping(value = "IDOverlapCheck", method = RequestMethod.POST)
	public void IDOverlapCheck(@RequestParam String id, HttpServletResponse response) throws Exception {
		System.out.println("IDOverlapCheck : 시작");
		PrintWriter out = response.getWriter();
		MemberModel memberModel = new MemberModel();
		memberModel.setId(id);
		System.out.println("IDOverlapCheck : " + memberService.selectMemberWithId(memberModel));
		if (memberService.selectMemberWithId(memberModel) == null) {
			System.out.println("IDOverlapCheck :NotOverlap");
			out.append("0");
			out.flush();
		} else {
			System.out.println("IDOverlapCheck :Overlap");
			out.append("1");
			out.flush();
		}
		out.close();
	}

	@RequestMapping(value = "EmailOverlapCheck", method = RequestMethod.POST)
	public void EmailOverlapCheck(@RequestParam String email, HttpServletResponse response) throws Exception {
		System.out.println("EmailOverlapCheck : 시작");
		PrintWriter out = response.getWriter();
		MemberModel memberModel = new MemberModel();
		memberModel.setEmail(email);
		System.out.println("EmailOverlapCheck : " + memberService.selectMemberWithEmail(memberModel));
		if (memberService.selectMemberWithEmail(memberModel) == null) {
			System.out.println("EmailOverlapCheck :NotOverlap");
			out.append("2");
			System.out.println(2);
			out.flush();
		} else {
			System.out.println("EmailOverlapCheck :Overlap");
			out.append("3");
			System.out.println(3);
			out.flush();
		}
		out.close();
	}

	@RequestMapping(value = "loginCheck", method = RequestMethod.POST)
	public void loginCheck(@RequestParam String id, @RequestParam String passwd, HttpServletResponse response)
			throws Exception {
		System.out.println("loginCheck : 시작");
		PrintWriter out = response.getWriter();
		MemberModel memberModel = new MemberModel();
		memberModel.setId(id);
		MemberModel dataModel = memberService.selectMemberWithId(memberModel);
		System.out.println("loginCheck  : " + dataModel);
		if (memberService.selectMemberWithId(memberModel) == null) {
			System.out.println("loginCheck :id null");
			out.append("0");
			System.out.println(0);
			out.flush();
		} else if (!dataModel.getPasswd().equals(passwd)) {
			System.out.println("loginCheck :passwdWrong");
			out.append("1");
			System.out.println(1);
			out.flush();
		} else {
			System.out.println("loginCheck :success");
			out.append("2");
			System.out.println(2);
			out.flush();
		}
		out.close();
	}
	@RequestMapping(value = "deleteCheck", method = RequestMethod.POST)
	public void deleteCheck(@RequestParam String passwd, HttpServletResponse response, HttpSession session)
			throws Exception {
		System.out.println("deleteCheck : 시작");
		PrintWriter out = response.getWriter();
		MemberModel memberModel = new MemberModel();
		memberModel.setMemnum((Integer) session.getAttribute("SessionMemberMemnum"));
		MemberModel dataModel = memberService.selectMemberWithMemNum(memberModel);
		System.out.println("deleteCheck  : " + dataModel);
		if (!dataModel.getPasswd().equals(passwd)) {
			System.out.println("deleteCheck :passwdWrong");
			out.append("1");
			System.out.println(1);
			out.flush();
		} else {
			System.out.println("deleteCheck :success");
			out.append("2");
			System.out.println(2);
			out.flush();
		}
		out.close();
	}
	@RequestMapping(value = "Kakaologin")
	public void Kakaologin(@RequestBody String params, HttpServletResponse response, HttpSession session)
			throws Exception {
		PrintWriter out = response.getWriter();
		MemberModel memberModel = new MemberModel();
		JSONParser paser = new JSONParser();
		JSONObject obj = (JSONObject)paser.parse(params);
		String token = (String) obj.get("access_token");
		System.out.println(token);
		//엑세스 토큰을 이용한 카카오 정보 조회 서비스
		Map<String, Object> resultMap = oauthService.selectKakaoInfo(token);
		System.out.println(resultMap);
		//계정 정보
		Map<String, Object> kakaoAccount = (Map<String, Object>) resultMap.get("kakao_account");
		Map<String, Object> kakaoNickName = (Map<String, Object>) resultMap.get("properties");
		String id = (Integer)resultMap.get("id")+"";
		System.out.println(id);
		System.out.println(kakaoAccount);
		System.out.println(kakaoNickName.get("nickname"));
		if(kakaoAccount.containsKey("email")&&kakaoNickName.containsKey("nickname")) {
			memberModel.setEmail((String) kakaoAccount.get("email"));
			if(memberService.selectMemberWithEmail(memberModel)!=null) {
				memberModel= memberService.selectMemberWithEmail(memberModel);
				memberModel.setTokken(token);
				memberService.updateMemberTokken(memberModel);
				session.setAttribute("SessionMemberMemnum", memberModel.getMemnum());
				session.setAttribute("SessionMemberId", memberModel.getId());
				session.setAttribute("SessionMemberName", memberModel.getName());
				session.setAttribute("kakaoTokken", token);
				out.append("1");
				out.flush();
			}else {
				session.setAttribute("kakaoId", id);
				session.setAttribute("kakaoName", (String) kakaoNickName.get("nickname"));
				session.setAttribute("kakaoPasswd", (String) kakaoAccount.get("email"));
				session.setAttribute("kakaoTokken", token);
				session.setAttribute("kakaoStatus", "3");
				session.setAttribute("kakaoEmail", (String) kakaoAccount.get("email"));
				memberModel.setId(id);
				memberModel.setName((String) kakaoNickName.get("nickname"));
				memberModel.setPasswd((String) kakaoAccount.get("email"));
				memberModel.setTokken(token);
				memberModel.setStatus("3");
				out.append("2");
				out.flush();
			}
		}else {
			oauthService.logoutKakaoInfo(token);
			oauthService.deleteKakaoInfo(resultMap);
			out.append("3");
			out.flush();
		}
		out.close();
	}
	@RequestMapping(value = "emailok", method = RequestMethod.POST)
	public void emailok(@RequestParam String emailok,HttpServletResponse response, HttpSession session)
			throws Exception {
		System.out.println("emailok : 시작");
		PrintWriter out = response.getWriter();
		MemberModel memberModel = new MemberModel();
		memberModel.setMemnum((Integer)session.getAttribute("SessionMemberMemnum"));
		memberModel = memberService.selectMemberWithMemNum(memberModel);
		if (!memberModel.getTokken().equals(emailok)) {
			System.out.println("emailok :tokken not eq");
			out.append("0");
			System.out.println(0);
			out.flush();
		} else if (memberModel.getTokken().equals(emailok)) {
			System.out.println("emailok :tokken eq");
			memberModel.setStatus("2");
			memberService.updateMemberStatus(memberModel);
			session.setAttribute("SessionMemberStatus", memberModel.getStatus());
			out.append("1");
			System.out.println(1);
			out.flush();
		} 
		out.close();
	}
	

}

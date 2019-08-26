package com.yogi.jogi.member.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.yogi.jogi.member.model.MemberDetailModel;
import com.yogi.jogi.member.model.MemberModel;
import com.yogi.jogi.member.service.MemberService;



@Controller
@RequestMapping(value = "member")
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	ModelAndView model = new ModelAndView();
	
	@Autowired
	private MemberService memberService;

	/* 회원가입/로그인/로그아웃 */
	@RequestMapping(value = "registemember")
	public ModelAndView registemember(MemberDetailModel memberDetailModel,HttpSession session) throws Exception{
		System.out.println("registemember : 시작");
		model.clear();
		MemberModel memberModel = new MemberModel();
		memberModel.setId(memberDetailModel.getId());
		memberModel.setEmail(memberDetailModel.getEmail());
		memberModel.setName(memberDetailModel.getName());
		memberModel.setPhone(memberDetailModel.getPhone1() + "-"+memberDetailModel.getPhone2() + "-" + memberDetailModel.getPhone3());
		memberModel.setPasswd(memberDetailModel.getPasswd());
		memberModel.setAddress(memberDetailModel.getPostcode() + "/" + memberDetailModel.getAddress1() + "/" + memberDetailModel.getDetailAddress());
		memberModel.setJumin(memberDetailModel.getJumin1() + "-" + memberDetailModel.getJumin2());
		memberService.insertMember(memberModel);
		memberModel = memberService.selectMemberWithEmail(memberModel);
		System.out.println("맴버 번호 >>" + memberModel.getMemnum());
		System.out.println("아이디 >>" + memberModel.getId());
		System.out.println("비밀번호 >>" + memberModel.getPasswd());
		session.setAttribute("SessionMemberMemnum", memberModel.getMemnum());
		session.setAttribute("SessionMemberId", memberModel.getId());
		session.setAttribute("SessionMemberName", memberModel.getName());
		model.setViewName("redirect:/main/main");
		model.addObject("InfoMember",memberModel);
		return model;
	}
	@RequestMapping(value = "loginmember")
	public ModelAndView loginmember(MemberModel memberModel,HttpSession session) throws Exception{
		System.out.println("loginmember : 시작");
		model.clear();
		memberModel = memberService.selectMemberWithId(memberModel);
		System.out.println("맴버 번호 >>" + memberModel.getMemnum());
		System.out.println("아이디 >>" + memberModel.getId());
		System.out.println("비밀번호 >>" + memberModel.getPasswd());
		session.setAttribute("SessionMemberMemnum", memberModel.getMemnum());
		session.setAttribute("SessionMemberId", memberModel.getId());
		session.setAttribute("SessionMemberName", memberModel.getName());
		if(memberModel.getId().equals("admin")) {
			model.setViewName("redirect:/admin/main");
		}else {
			model.setViewName("redirect:/main/main");
		}
		model.addObject("InfoMember",memberModel);
		return model;
	}
	@RequestMapping(value = "logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:/main/main";
	}
	
	/* 멤버프로필 */
	@RequestMapping(value = "profile")
	public ModelAndView profile(HttpSession session) throws Exception{
		System.out.println("member/profile  : 시작");
		model.clear();
		MemberModel memberModel = new MemberModel();
		System.out.println("세션번호  : " + (Integer)session.getAttribute("SessionMemberMemnum"));
		memberModel.setMemnum((Integer)session.getAttribute("SessionMemberMemnum"));
		System.out.println("memberModel셋 memNum  : " + memberModel);
		memberModel = memberService.selectMemberWithMemNum(memberModel);
		System.out.println("memberModel 다시 : " + memberModel);
		model.addObject("memberInfo",memberModel);
		model.setViewName("member/memberprofile.do");
		return model;
	}
	
	//ajax 컨트롤러들
	@RequestMapping(value = "IDOverlapCheck",method = RequestMethod.POST)
	public void IDOverlapCheck(@RequestParam String id,HttpServletResponse response)throws Exception{
		System.out.println("IDOverlapCheck : 시작" );
		PrintWriter out = response.getWriter();
		MemberModel memberModel = new MemberModel();
		memberModel.setId(id);
		System.out.println("IDOverlapCheck : "+memberService.selectMemberWithId(memberModel));
		if(memberService.selectMemberWithId(memberModel)==null) {
			System.out.println("IDOverlapCheck :NotOverlap");
			out.append("0");
			out.flush();
		}else {
			System.out.println("IDOverlapCheck :Overlap");
			out.append("1");
			out.flush();
		}
		out.close();
	}
	@RequestMapping(value = "EmailOverlapCheck",method = RequestMethod.POST)
	public void EmailOverlapCheck(@RequestParam String email,HttpServletResponse response)throws Exception{
		System.out.println("EmailOverlapCheck : 시작");
		PrintWriter out = response.getWriter();
		MemberModel memberModel = new MemberModel();
		memberModel.setEmail(email);
		System.out.println("EmailOverlapCheck : "+memberService.selectMemberWithEmail(memberModel));
		if(memberService.selectMemberWithEmail(memberModel)==null) {
			System.out.println("EmailOverlapCheck :NotOverlap");
			out.append("2");
			System.out.println(2);
			out.flush();
		}else {
			System.out.println("EmailOverlapCheck :Overlap");
			out.append("3");
			System.out.println(3);
			out.flush();
		}
		out.close();
	}
	@RequestMapping(value = "loginCheck",method = RequestMethod.POST)
	public void loginCheck(@RequestParam String id,@RequestParam String passwd,HttpServletResponse response)throws Exception{
		System.out.println("loginCheck : 시작");
		PrintWriter out = response.getWriter();
		MemberModel memberModel = new MemberModel();
		memberModel.setId(id);
		MemberModel dataModel = memberService.selectMemberWithId(memberModel);
		System.out.println("loginCheck  : "+dataModel);
		if(memberService.selectMemberWithId(memberModel)==null) {
			System.out.println("loginCheck :id null");
			out.append("0");
			System.out.println(0);
			out.flush();
		}else if(!dataModel.getPasswd().equals(passwd)){
			System.out.println("loginCheck :passwdWrong");
			out.append("1");
			System.out.println(1);
			out.flush();
		}else {
			System.out.println("loginCheck :success");
			out.append("2");
			System.out.println(2);
			out.flush();
		}
		out.close();
	}
	
}

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

import com.yogi.jogi.member.model.MemberModel;
import com.yogi.jogi.member.service.MemberService;



@Controller
@RequestMapping(value = "member")
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	ModelAndView model = new ModelAndView();
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value = "registemember")
	public ModelAndView registemember(MemberModel memberModel,HttpSession session) throws Exception{
		System.out.println("registemember : 시작");
		
		
		model.clear();
		memberService.insertMember(memberModel);
		memberModel = memberService.selectMemberWithEmail(memberModel);
		System.out.println("맴버 번호 >>" + memberModel.getMemnum());
		System.out.println("아이디 >>" + memberModel.getId());
		System.out.println("비밀번호 >>" + memberModel.getPasswd());
		session.setAttribute("SessionMemberMemnum", memberModel.getMemnum());
		session.setAttribute("SessionMemberId", memberModel.getId());
		session.setAttribute("SessionMemberName", memberModel.getName());
		model.setViewName("redirect:/main/main");
		
		return model;
	}
	@RequestMapping(value = "IDOverlapCheck",method = RequestMethod.POST)
	public void IDOverlapCheck(@RequestParam String id,HttpServletResponse response)throws Exception{
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
	
}

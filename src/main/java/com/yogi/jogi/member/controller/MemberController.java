package com.yogi.jogi.member.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

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
	public ModelAndView registemember(MemberModel memberModel) throws Exception{
		System.out.println("registemember : 정보확인");
		model.clear();
		memberService.insertMember(memberModel);

		model.setViewName("index/index.do");
		return model;
	}
	@RequestMapping(value = "IDOverlapCheck",method = RequestMethod.POST)
	public void IDOverlapCheck(@RequestParam String id,HttpServletResponse response)throws Exception{
		PrintWriter out = response.getWriter();
		MemberModel memberModel = new MemberModel();
		memberModel.setId(id);
		System.out.println("IDOverlapCheck에서 출력 : "+memberService.selectMemberWithId(memberModel));
		if(memberService.selectMemberWithId(memberModel)==null) {
			System.out.println("유효성 검사 :NotOverlap");
			out.append("0");
			out.flush();
		}else {
			System.out.println("유효성 검사 :Overlap");
			out.append("1");
			out.flush();
		}
		out.close();
	}
	@RequestMapping(value = "EmailOverlapCheck",method = RequestMethod.POST)
	public void EmailOverlapCheck(@RequestParam String email,HttpServletResponse response)throws Exception{
		System.out.println("EmailOverlapCheck : 구동");
		PrintWriter out = response.getWriter();
		MemberModel memberModel = new MemberModel();
		memberModel.setEmail(email);
		System.out.println("EmailOverlapCheck에서 출력 : "+memberService.selectMemberWithEmail(memberModel));
		if(memberService.selectMemberWithEmail(memberModel)==null) {
			System.out.println("유효성 검사 :NotOverlap");
			out.append("0");
			out.flush();
		}else {
			System.out.println("유효성 검사 :Overlap");
			out.append("1");
			out.flush();
		}
		out.close();
	}
	
}

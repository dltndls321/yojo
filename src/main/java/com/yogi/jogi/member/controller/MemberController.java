package com.yogi.jogi.member.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
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
}

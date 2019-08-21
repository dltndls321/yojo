package com.yogi.jogi.admin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping(value="admin")
public class AdminController {
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@RequestMapping(value = "main")
	public String moveMain() {
		return "admin/board.admin";
	}
	
	@RequestMapping(value = "memberProfile")
	public String moveMemberProfile() {
		return "admin/memberProfile.admin";
	}
	
	
}


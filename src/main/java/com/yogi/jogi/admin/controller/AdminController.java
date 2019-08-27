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
		return "admin/main.admin";
	}
	
	@RequestMapping(value = "board")
	public String moveBoard() {
		return "admin/board.admin";
	}
	
	@RequestMapping(value = "memberList")
	public String moveMemberList() {
		return "admin/memberList.admin";
	}
	
	@RequestMapping(value = "memberProfile")
	public String moveMemberProfile() {
		return "admin/memberProfile.admin";
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


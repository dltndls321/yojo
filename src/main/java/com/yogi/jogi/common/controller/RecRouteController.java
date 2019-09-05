package com.yogi.jogi.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "course")
public class RecRouteController {
	@RequestMapping(value = "recommend")
	public String moveFest() {
		return "course/preferChoice.do";
	}
	
	
	
}

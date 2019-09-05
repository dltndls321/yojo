package com.yogi.jogi.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "main")
public class MainController {

	@RequestMapping(value = "main")
	public String moveMain() {
		return "index/index.do";
	}
	@RequestMapping(value = "index3")
	public String moveMain2() {
		return "index/index3.do";
	}

	
}

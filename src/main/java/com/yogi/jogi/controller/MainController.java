package com.yogi.jogi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "main")
public class MainController {
	@RequestMapping(value = "main")
	public String moveMain() {
		return "main/index";
	}
}

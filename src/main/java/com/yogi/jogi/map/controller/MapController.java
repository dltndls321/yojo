package com.yogi.jogi.map.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yogi.jogi.map.service.MapService;




@Controller
public class MapController {
	private static final Logger logger = LoggerFactory.getLogger(MapController.class);
	ModelAndView mv = new ModelAndView();
	
	@Autowired
	private MapService mapService;
	
	@RequestMapping("test") //2. url에 board/test를 치면
	public ModelAndView test() throws Exception {
		mv.clear();
		System.out.println(mapService.getFoodList());
		mv.addObject("foodList",mapService.getFoodList());
		mv.setViewName("maptest/maptest.do"); //3. board폴더아래의 test.jsp를 찾음
		
		return mv;
	}
}

package com.yogi.jogi.map.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yogi.jogi.map.service.MapService;

import net.sf.json.JSON;
import net.sf.json.JSONArray;




@Controller
@RequestMapping("map")
public class MapController {
	private static final Logger logger = LoggerFactory.getLogger(MapController.class);
	ModelAndView mv = new ModelAndView();
	
	@Autowired
	private MapService mapService;
	
	@RequestMapping("test") //
	public ModelAndView test() throws Exception {
		
		mv.clear();
		System.out.println(mapService.getFoodList());
	
		mv.addObject("foodList",mapService.getFoodList());
		mv.setViewName("maptest/maptest.do"); //
		
		return mv;
	}
}

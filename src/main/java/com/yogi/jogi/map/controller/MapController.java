package com.yogi.jogi.map.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.yogi.jogi.map.model.MapModel;
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

		mv.addObject("foodList", mapService.getFoodList());
		mv.setViewName("maptest/maptest.do"); //

		return mv;
	}

	@RequestMapping("test2") //
	public ModelAndView test2(@RequestParam("startX") float startX,@RequestParam("startY") float startY
			, @RequestParam("endX") float endX, @RequestParam("endY") float endY)
			throws Exception {

		mv.clear();
		 
		System.out.println("startX : " + startX +" : startY : " + startY+" : endX : " + endX +" : endY : " + endY);

		if(startX > endX && startY > endY) {
			mv.addObject("foodList", mapService.getFoodList2(endX,endY,startX,startY));
		}else if(startX < endX && startY > endY) {
			mv.addObject("foodList", mapService.getFoodList2(startX,endY,endX,startY));
		}else if(startX < endX && startY < endY) {
			mv.addObject("foodList", mapService.getFoodList2(startX,startY,endX,endY));
		}else {
			mv.addObject("foodList", mapService.getFoodList2(endX,startY,startX,endY));
		}

		mv.setViewName("maptest/maptest.do"); //

		return mv;
	}

	@RequestMapping("search") //
	public ModelAndView search() throws Exception {

		mv.clear();

		mv.setViewName("maptest/mapSearch.do"); //

		return mv;
	}



}

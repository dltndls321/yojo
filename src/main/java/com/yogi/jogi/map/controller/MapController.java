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

import com.yogi.jogi.common.service.FestService;
import com.yogi.jogi.common.service.SpotService;
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
	
	@Autowired
	private FestService festService;
	
	@Autowired
	private SpotService spotService;

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
		
		float centerX = (startX + endX)/2;
		float centerY = (startY + endY)/2;
		
		mv.addObject("centerX",centerX);
		mv.addObject("centerY",centerY);
		
		
		
		if(startX > endX && startY > endY) {
			mv.addObject("foodList", mapService.getFoodList2(endX,endY,startX,startY));
			mv.addObject("festList", festService.selectFestListXY(endX,endY,startX,startY));
			mv.addObject("spotList", spotService.selectSpotListXY(endX,endY,startX,startY));
			System.out.println(mapService.getFoodList2(endX,endY,startX,startY));
			mv.addObject("swX",endY);
			mv.addObject("swY",endX);
			mv.addObject("neX",startY);
			mv.addObject("neY",startX);
		}else if(startX < endX && startY > endY) {
			
			mv.addObject("foodList", mapService.getFoodList2(startX,endY,endX,startY));
			mv.addObject("festList", festService.selectFestListXY(startX,endY,endX,startY));
			mv.addObject("spotList", spotService.selectSpotListXY(startX,endY,endX,startY));
			System.out.println(mapService.getFoodList2(startX,endY,endX,startY));
			mv.addObject("swX",endY);
			mv.addObject("swY",startX);
			mv.addObject("neX",startY);
			mv.addObject("neY",endX);
		}else if(startX < endX && startY < endY) {
			
			mv.addObject("foodList", mapService.getFoodList2(startX,startY,endX,endY));
			mv.addObject("festList", festService.selectFestListXY(startX,startY,endX,endY));
			mv.addObject("spotList", spotService.selectSpotListXY(startX,startY,endX,endY));
			System.out.println(mapService.getFoodList2(startX,startY,endX,endY));
			mv.addObject("swX",startY);
			mv.addObject("swY",startX);
			mv.addObject("neX",endY);
			mv.addObject("neY",endX);
		}else { 
			//startX - 126.8  startY - 37.5 endX - 127.1 endY - 37.4
			mv.addObject("foodList", mapService.getFoodList2(startY,endX,endY,startX));
			mv.addObject("festList", festService.selectFestListXY(startY,endX,endY,startX));
			mv.addObject("spotList", spotService.selectSpotListXY(startY,endX,endY,startX));
			System.out.println(mapService.getFoodList2(startY,endX,endY,startX));
			mv.addObject("swX",startY);
			mv.addObject("swY",endX);
			mv.addObject("neX",endY);
			mv.addObject("neY",startX); 
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

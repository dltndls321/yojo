package com.yogi.jogi.map.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.yogi.jogi.admin.model.AdminCourseModel;
import com.yogi.jogi.admin.service.AdminCourseService;
import com.yogi.jogi.common.service.FestService;
import com.yogi.jogi.common.service.SpotService;
import com.yogi.jogi.map.service.MapService;

@Controller
@RequestMapping("course")
public class CourseController {
	private static final Logger logger = LoggerFactory.getLogger(MapController.class);
	
	
	ModelAndView mv = new ModelAndView();
	
	@Autowired
	private AdminCourseService adminCourseService;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	@Autowired
	private MapService mapService;
	
	@Autowired
	private FestService festService;
	
	@Autowired
	private SpotService spotService;

	@RequestMapping(value ="findCourse") 
	public ModelAndView findCourse(HttpServletRequest request, HttpServletResponse response,AdminCourseModel adminCourseModel,
			@RequestParam String theme, @RequestParam int areaCode, @RequestParam Date date,@RequestParam String foodCode,@RequestParam String spotCode) throws Exception {
		mv.clear();
		adminCourseModel.setTheme(theme);
		adminCourseModel.setAreaCode(areaCode);
		adminCourseModel.setFoodCode(foodCode);
		adminCourseModel.setSpotCode(spotCode);
		adminCourseModel.setStartDate(date);
		System.out.println(adminCourseModel);
		
		adminCourseModel = adminCourseService.selectCourse(adminCourseModel);
		System.out.println(adminCourseModel);
		mv.addObject("adminCourse", adminCourseModel);
		mv.setViewName("course/findCourse.do"); 

		return mv;
	}

	
	


}

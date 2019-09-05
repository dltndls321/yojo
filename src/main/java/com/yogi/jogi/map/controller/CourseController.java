package com.yogi.jogi.map.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
import com.yogi.jogi.common.model.FestReviewModel;
import com.yogi.jogi.common.model.FestivalModel;
import com.yogi.jogi.common.model.FoodModel;
import com.yogi.jogi.common.model.FoodReviewModel;
import com.yogi.jogi.common.model.SpotModel;
import com.yogi.jogi.common.model.SpotReviewModel;
import com.yogi.jogi.common.service.FestReviewService;
import com.yogi.jogi.common.service.FestService;
import com.yogi.jogi.common.service.FoodReviewService;
import com.yogi.jogi.common.service.FoodService;
import com.yogi.jogi.common.service.SpotReviewService;
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
	
	@Autowired
	private FoodService foodService;
	
	@Autowired
	private FoodReviewService foodReviewService;
	
	@Autowired
	private FestReviewService festReviewService;
	
	@Autowired
	private SpotReviewService spotReviewService;

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
		//각각의 정보찾기
		//음식점 (1,3,5)
		FoodModel foodModel = new FoodModel();
		foodModel.setName(adminCourseModel.getCourse1());
		FoodModel food1 = foodService.selectFoodWithname(foodModel);
		foodModel.setName(adminCourseModel.getCourse3());
		FoodModel food2 = foodService.selectFoodWithname(foodModel);
		foodModel.setName(adminCourseModel.getCourse5());
		FoodModel food3 = foodService.selectFoodWithname(foodModel);
		System.out.println(food3);
		//관광지 (2,4)
		SpotModel spotModel = new SpotModel();
		spotModel.setName(adminCourseModel.getCourse2());
		SpotModel spot1 = spotService.selectSpotWithname(spotModel);
		spotModel.setName(adminCourseModel.getCourse4());
		SpotModel spot2 = spotService.selectSpotWithname(spotModel);
		System.out.println(spot2);
		//축제 (6)
		FestivalModel festivalModel = new FestivalModel();
		festivalModel.setName(adminCourseModel.getCourse6());
		FestivalModel fest1 = festService.selectFestWithsubject(festivalModel);
		System.out.println(fest1);
		
		//리뷰찾기
		//음식점1

		FoodReviewModel foodReviewModel = new FoodReviewModel();
		foodReviewModel.setFoodNum(food1.getFoodNum());
		List<FoodReviewModel> foodReview = foodReviewService.selectFoodReviewListWithFoodNum(foodReviewModel);
		int star1 = 0;
	    int size1 = foodReview.size();
	    for(int i = 0 ; i <size1;i++) {
        	star1 = star1 + foodReview.get(i).getStar();
	    }
	    if(size1 > 0) {
        	int avg11 = (star1*10)/foodReview.size();   
	        double avg1 = ((double)avg11)/10;
	        
	        mv.addObject("size1", size1);
			mv.addObject("avg1", avg1);
	    }
	  //음식점2

		foodReviewModel.setFoodNum(food2.getFoodNum());
		List<FoodReviewModel> foodReview2 = foodReviewService.selectFoodReviewListWithFoodNum(foodReviewModel);
		int star2 = 0;
	    int size2 = foodReview2.size();
	    for(int i = 0 ; i <size2;i++) {
        	star2 = star2 + foodReview2.get(i).getStar();
	    }
	    if(size2 > 0) {
        	int avg21 = (star2*10)/foodReview2.size();   
	        double avg2 = ((double)avg21)/10;
	        
	        mv.addObject("size2", size2);
			mv.addObject("avg2", avg2);
	    }
	//음식점3

	    foodReviewModel.setFoodNum(food3.getFoodNum());
		List<FoodReviewModel> foodReview3 = foodReviewService.selectFoodReviewListWithFoodNum(foodReviewModel);
		int star3 = 0;
		int size3 = foodReview3.size();
		for(int i = 0 ; i <size3;i++) {
	       	star3 = star3 + foodReview3.get(i).getStar();
		}
		if(size3 > 0) {
	        int avg31 = (star3*10)/foodReview3.size();   
		    double avg3 = ((double)avg31)/10;
		    
		    mv.addObject("size3", size3);
			mv.addObject("avg3", avg3);
		}
	//관광지

		SpotReviewModel spotReviewModel = new SpotReviewModel();
		spotReviewModel.setSpotNum(spot1.getSpotNum());
		List<SpotReviewModel> spotReview = spotReviewService.selectSpotReviewListWithSpotNum(spotReviewModel);
		int star4 = 0;
		int size4 = spotReview.size();
		for(int i = 0 ; i <size4;i++) {
	        star4 = star4 + spotReview.get(i).getStar();
		 }
		if(size4 > 0) {
	        int avg41 = (star4*10)/spotReview.size();   
		    double avg4 = ((double)avg41)/10;
		    
		    mv.addObject("size4", size4);
			mv.addObject("avg4", avg4);
		}
		//관광지
		spotReviewModel.setSpotNum(spot2.getSpotNum());
		List<SpotReviewModel> spotReview2 = spotReviewService.selectSpotReviewListWithSpotNum(spotReviewModel);
		int star5 = 0;
		int size5 = spotReview2.size();
		for(int i = 0 ; i <size5;i++) {
	        star5 = star5 + spotReview2.get(i).getStar();
		 }
		if(size5 > 0) {
	        int avg51 = (star5*10)/spotReview2.size();   
		    double avg5 = ((double)avg51)/10;
		    
		    mv.addObject("size5", size5);
			mv.addObject("avg5", avg5);
		}
		//축제

		FestReviewModel festReviewModel = new FestReviewModel();
		festReviewModel.setFestNum(fest1.getFestNum());
		List<FestReviewModel> festReview = festReviewService.selectFestReviewListWithFestNum(festReviewModel);
		int star6 = 0;
		int size6 = festReview.size();
		for(int i = 0 ; i <size6;i++) {
	        star6 = star6 + festReview.get(i).getStar();
		}
		 if(size6 > 0) {
	        int avg61 = (star6*10)/festReview.size();   
		    double avg6 = ((double)avg61)/10;
		    
			mv.addObject("size6", size6);
			mv.addObject("avg6", avg6);
		}
		 
		mv.addObject("adminCourse", adminCourseModel);
		//승해얌 여기서 x,y뽑으면 돼!!!!!!!!!!!!!! food1.x !!!!!!!!!!!!!!!!  
		mv.addObject("food1", food1);           
		mv.addObject("food2", food2);
		mv.addObject("food3", food3);
		mv.addObject("spot1", spot1);
		mv.addObject("spot2", spot2);
		mv.addObject("fest1", fest1);
		mv.setViewName("course/findCourse.do"); 

		return mv;
	}

	
	


}

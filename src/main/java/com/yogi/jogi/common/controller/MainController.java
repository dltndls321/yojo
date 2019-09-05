package com.yogi.jogi.common.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yogi.jogi.admin.service.AdminCourseService;
import com.yogi.jogi.board.service.BoardService;
import com.yogi.jogi.common.model.FestReviewModel;
import com.yogi.jogi.common.model.FoodReviewModel;
import com.yogi.jogi.common.model.SpotReviewModel;
import com.yogi.jogi.common.service.FestReviewService;
import com.yogi.jogi.common.service.FestService;
import com.yogi.jogi.common.service.FoodReviewService;
import com.yogi.jogi.common.service.FoodService;
import com.yogi.jogi.common.service.SpotReviewService;
import com.yogi.jogi.common.service.SpotService;
import com.yogi.jogi.map.service.MapService;
import com.yogi.jogi.member.model.MemberModel;
import com.yogi.jogi.member.service.MemberService;

@Controller
@RequestMapping(value = "main")
public class MainController {
	@Autowired
	MemberService memberService;
	@Autowired
	FestReviewService festReviewService;
	@Autowired
	FoodReviewService foodReviewService;
	@Autowired
	SpotReviewService spotReviewServiece;
	@Autowired
	FoodService foodService;
	@Autowired
	BoardService boardService;
	@Autowired
	SpotService spotService;
	@Autowired
	FestService festService;
	@Autowired
	MapService courseService;
	@Autowired
	AdminCourseService adminCourseService;
	
	ModelAndView model = new ModelAndView();
	
	@RequestMapping(value = "main")
	public ModelAndView moveMain() throws Exception {
		model.clear();
		List<FestReviewModel> festreviewlist = festReviewService.selectFestReviewList();
		List<FoodReviewModel> foodreviewlist = foodReviewService.selectFoodReviewList();
		List<SpotReviewModel> spotreviewlist = spotReviewServiece.selectSpotReviewList();
		FestReviewModel festreviewinfo = new FestReviewModel();
		MemberModel festmember=new MemberModel();
		FoodReviewModel foodreviewinfo =  new FoodReviewModel();
		MemberModel foodmember = new MemberModel();
		SpotReviewModel spotreviewinfo = new SpotReviewModel();
		MemberModel spotmember = new MemberModel();
		try {
			festreviewinfo = festreviewlist.get(0);
			festmember.setMemnum(festreviewinfo.getMemNum());
			festmember = memberService.selectMemberWithMemNum(festmember);
		}catch (Exception e) {
		}
		
		try {
			foodreviewinfo = foodreviewlist.get(0);
			foodmember.setMemnum(foodreviewinfo.getMemNum());
			foodmember = memberService.selectMemberWithMemNum(foodmember);
		} catch (Exception e) {
		}
		try {
			spotreviewinfo = spotreviewlist.get(0);
			spotmember.setMemnum(spotreviewinfo.getMemNum());
			spotmember = memberService.selectMemberWithMemNum(spotmember);
		} catch (Exception e) {
		}
		int foodCount = foodService.selectFoodList().size();
		int boardCount = boardService.selectBoardListWidhBoardid("1").size();
		int festCount = festService.selectFestList().size();
		int spotCount = spotService.selectSpotList().size();
		
		
		model.addObject("festreviewinfo",festreviewinfo);
		model.addObject("festmember",festmember);
		
		model.addObject("foodreviewinfo",foodreviewinfo);
		model.addObject("foodmember",foodmember);
		
		model.addObject("spotreviewinfo",spotreviewinfo);
		model.addObject("spotmember",spotmember);
		model.setViewName("index/index.do");
		
		model.addObject("foodCount",foodCount);
		model.addObject("boardCount",boardCount);
		model.addObject("festCount",festCount);
		model.addObject("spotCount",spotCount);
		return model;
	}
	@RequestMapping(value = "index3")
	public String moveMain2() {
		return "index/index3.do";
	}

	
}

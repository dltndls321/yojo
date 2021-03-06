package com.yogi.jogi.map.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yogi.jogi.common.service.FestService;
import com.yogi.jogi.common.service.SpotService;
import com.yogi.jogi.map.model.CourseModel;
import com.yogi.jogi.map.model.MapModel;
import com.yogi.jogi.map.service.MapService;

import net.sf.json.JSON;
import net.sf.json.JSONArray;

@Controller
@RequestMapping("map")
public class MapController {
	private static final Logger logger = LoggerFactory.getLogger(MapController.class);
	
	
	ModelAndView mv = new ModelAndView();
	private int pageNum;
	private String boardid;
	@Autowired
	private MapService mapService;
	
	@Autowired
	private FestService festService;
	
	@Autowired
	private SpotService spotService;

	
	@ModelAttribute
	public void setAttr(HttpServletRequest request) {

		HttpSession session = request.getSession();
		String reqboardid = request.getParameter("boardid"); // boardid가 넘어오는지

		if (reqboardid != null)
			session.setAttribute("boardid", reqboardid); // boardid가 있으면 session에 boardid 체크
		if (session.getAttribute("boardid") == null)
			boardid = "1"; // null 이면 boardid = 1
		else
			boardid = (String) session.getAttribute("boardid"); // 오브젝트로 받아오기떄문에 String으로 형변환

		try {
			pageNum = Integer.parseInt(request.getParameter("pageNum")); // pageNum을 세팅하는데 넘어오지않으면 1을 집어넣음
		} catch (Exception e) {
			pageNum = 1;
		}
	}
	@RequestMapping("test") //
	public ModelAndView test() throws Exception {

		mv.clear();
		System.out.println(mapService.getFoodList());

		mv.addObject("foodList", mapService.getFoodList());
		mv.setViewName("index/index6.do"); //

		return mv;
	}

	@RequestMapping("result") //
	public ModelAndView test2(@RequestParam("startX") float startX,@RequestParam("startY") float startY
			, @RequestParam("endX") float endX, @RequestParam("endY") float endY,
			@RequestParam("startPoint") String startPoint,  @RequestParam("endPoint") String endPoint)
			throws Exception {

		mv.clear();
		 
		System.out.println("startX : " + startX +" : startY : " + startY+" : endX : " + endX +" : endY : " + endY);
		
		float centerX = (startX + endX)/2;
		float centerY = (startY + endY)/2;
		mv.addObject("centerX",centerX);
		mv.addObject("centerY",centerY);
		mv.addObject("startPoint",startPoint);
		mv.addObject("endPoint",endPoint);
		
		
		if(startX > endX && startY > endY) {
			
			//startX - 126.8  startY - 37.5 endX - 127.1 endY - 37.4
			mv.addObject("foodList", mapService.getFoodList2(endX,endY,startX,startY));
			mv.addObject("festList", festService.selectFestListXY(endX,endY,startX,startY));
			mv.addObject("spotList", spotService.selectSpotListXY(endX,endY,startX,startY));
			System.out.println(mapService.getFoodList2(endX,endY,startX,startY));
			mv.addObject("swX",endY);
			mv.addObject("swY",endX);
			mv.addObject("neX",startY);
			mv.addObject("neY",startX);
			mv.addObject("seX",startY);
			mv.addObject("seY",endX);
			mv.addObject("nwX",endY);
			mv.addObject("nwY",startX);
			
		}else if(startX < endX && startY > endY) {
			
			//startX - 126.8  startY - 37.5 endX - 127.1 endY - 37.4
			mv.addObject("foodList", mapService.getFoodList2(startX,endY,endX,startY));
			mv.addObject("festList", festService.selectFestListXY(startX,endY,endX,startY));
			mv.addObject("spotList", spotService.selectSpotListXY(startX,endY,endX,startY));
			System.out.println(mapService.getFoodList2(startX,endY,endX,startY));
			mv.addObject("swX",endY);
			mv.addObject("swY",startX);
			mv.addObject("neX",startY);
			mv.addObject("neY",endX);
			mv.addObject("seX",startY); //x가 큰값
			mv.addObject("seY",startX); // y가 작은값
			mv.addObject("nwX",endY); // x가 작은값
			mv.addObject("nwY",endX); //y가 큰값
		}else if(startX < endX && startY < endY) {
			//startX - 126.8  startY - 37.5 endX - 127.1 endY - 37.4
			mv.addObject("foodList", mapService.getFoodList2(startX,startY,endX,endY));
			mv.addObject("festList", festService.selectFestListXY(startX,startY,endX,endY));
			mv.addObject("spotList", spotService.selectSpotListXY(startX,startY,endX,endY));
			System.out.println(mapService.getFoodList2(startX,startY,endX,endY));
			mv.addObject("swX",startY);
			mv.addObject("swY",startX);
			mv.addObject("neX",endY);
			mv.addObject("neY",endX);
			mv.addObject("seX",endY); //x가 큰값
			mv.addObject("seY",startX); // y가 작은값
			mv.addObject("nwX",startY); // x가 작은값
			mv.addObject("nwY",endX); //y가 큰값
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
			mv.addObject("seX",endY); //x가 큰값
			mv.addObject("seY",endX); // y가 작은값
			mv.addObject("nwX",startY); // x가 작은값
			mv.addObject("nwY",startX); //y가 큰값
		}

		mv.setViewName("maptest/mapResult.do"); //

		return mv;
	}

	@RequestMapping("search") //
	public ModelAndView search() throws Exception {

		mv.clear();

		mv.setViewName("maptest/mapSearch.do"); //

		return mv;
		
	}
	
	@RequestMapping("route")
	public ModelAndView route(@RequestParam("course1") String course1,@RequestParam("course2") String course2,@RequestParam("course3") String course3,
			@RequestParam("course4") String course4,@RequestParam("course5") String course5,@RequestParam("course6") String course6
			,@RequestParam("startPoint") String starting,  @RequestParam("endPoint") String destination,HttpSession session) throws Exception {

		
		int[] index = new int[6];
		String[] course = new String[6];
		index[0] = course1.indexOf("-");
		index[1] = course2.indexOf("-");
		index[2] = course3.indexOf("-");
		index[3] = course4.indexOf("-");
		index[4] = course5.indexOf("-");
		index[5] = course6.indexOf("-");
		
		course[0] = course1;
		course[1] = course2;
		course[2] = course3;
		course[3] = course4;
		course[4] = course5;
		course[5] = course6;

		mv.clear();
		System.out.println("course1 : " + course1 + "course2 : " + course2 + "course3 : " + course3 
				+ "course4 : " + course4+ "course5 : " + course5+ "course6 : " + course6   );
		CourseModel courseModel = new CourseModel();
		
		courseModel.setCourse1(course1);
		courseModel.setCourse2(course2);
		courseModel.setCourse3(course3);
		courseModel.setCourse4(course4);
		courseModel.setCourse5(course5);
		courseModel.setCourse6(course6);
		courseModel.setStarting(starting);
		courseModel.setDestination(destination);
		courseModel.setSubject((String)session.getAttribute("SessionMemberId"));
		mapService.insertCourse(courseModel);
		mv.addObject("CourseInfo",mapService.getCourseListOne((String)session.getAttribute("SessionMemberId")));
		
		
		
		for(int i = 0 ; i<index.length;i++) {
			
		if(course[i].substring(index[i]+2).equals("맛집")) {
				 mv.addObject("Area"+i,mapService.getFoodArea(course[i].substring(0,index[i])));
				 mv.addObject("AreaF"+i,"맛집");
			System.out.println("맛집");
		}else if(course[i].substring(index[i]+2).equals("축제")) {
				 mv.addObject("Area"+i,festService.getFestArea(course[i].substring(0,index[i]))); 
				 mv.addObject("AreaF"+i,"축제");
			System.out.println("축제");
		}else {
				 mv.addObject("Area"+i,spotService.getSpotArea(course[i].substring(0,index[i]))); 
				 mv.addObject("AreaF"+i,"관광지");
			System.out.println("관광지");
		}
		}
		
		mv.setViewName("maptest/mapRoute.do"); //

		return mv;
	}

	@RequestMapping("Log") //
	public ModelAndView Log(HttpSession session) throws Exception {

		mv.clear();
		int pageSize = 5;//한 페이지에 최대로 띄울 갯수
		int currentPage = pageNum;
		int count = mapService.getCourseList((String)session.getAttribute("SessionMemberId")).size(); // BoardDBBeanMyBatis에 설정해놓은 boardid
		int startRow = ((currentPage - 1) * pageSize);
		int endRow = currentPage * pageSize;
		if (count < endRow) {
			endRow = count;
		}
		int number = count - ((currentPage - 1) * pageSize);
		int bottomLine = 3; // 페이징 처리시 페이징 최대 갯수
		int pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
		int startPage = 1 + (currentPage - 1) / bottomLine * bottomLine;
		int endPage = startPage + bottomLine - 1;
		if (endPage > pageCount) {
			endPage = pageCount;
		}	
		
		mv.addObject("CLog",mapService.getCourseListPaging(startRow +1, endRow, (String)session.getAttribute("SessionMemberId")));
		mv.addObject("pageCount",pageCount);
		mv.addObject("count", count);
		mv.addObject("pageNum", pageNum);
		mv.addObject("number", number); 
		mv.addObject("startPage", startPage);
		mv.addObject("bottomLine", bottomLine);
		mv.addObject("endPage", endPage);
		mv.setViewName("maptest/mapRouteLog.do"); //

		return mv;
		
	}

	@RequestMapping("route1/{courseNum}/{course1}/{course2}/{course3}/{course4}/{course5}/{course6}")
	public ModelAndView route1(@PathVariable("courseNum") int courseNum,@PathVariable("course1") String course1,@PathVariable("course2") String course2,@PathVariable("course3") String course3,
			@PathVariable("course4") String course4,@PathVariable("course5") String course5,@PathVariable("course6") String course6,HttpSession session) throws Exception {

		int[] index = new int[6];
		String[] course = new String[6];
		index[0] = course1.indexOf("-");
		index[1] = course2.indexOf("-");
		index[2] = course3.indexOf("-");
		index[3] = course4.indexOf("-");
		index[4] = course5.indexOf("-");
		index[5] = course6.indexOf("-");
		
		course[0] = course1;
		course[1] = course2;
		course[2] = course3;
		course[3] = course4;
		course[4] = course5;
		course[5] = course6;
		
		mv.addObject("CourseInfo",mapService.getCourseListNumOne(courseNum));
		
		for(int i = 0 ; i<index.length;i++) {
			
			if(course[i].substring(index[i]+2).equals("맛집")) {
					 mv.addObject("Area"+i,mapService.getFoodArea(course[i].substring(0,index[i])));
					 mv.addObject("AreaF"+i,"맛집");
				System.out.println("맛집");
			}else if(course[i].substring(index[i]+2).equals("축제")) {
					 mv.addObject("Area"+i,festService.getFestArea(course[i].substring(0,index[i]))); 
					 mv.addObject("AreaF"+i,"축제");
				System.out.println("축제");
			}else {
					 mv.addObject("Area"+i,spotService.getSpotArea(course[i].substring(0,index[i]))); 
					 mv.addObject("AreaF"+i,"관광지");
				System.out.println("관광지");
			}
			}
		
		mv.setViewName("maptest/mapRoute.do"); //

		return mv;
	}
}

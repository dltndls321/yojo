package com.yogi.jogi.common.controller;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.apache.ibatis.mapping.FetchType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.yogi.jogi.common.model.FestReviewModel;
import com.yogi.jogi.common.model.FestivalModel;
import com.yogi.jogi.common.service.FestReviewService;
import com.yogi.jogi.common.service.FestService;
import com.yogi.jogi.member.model.MemberModel;
import com.yogi.jogi.member.service.MemberService;

@Controller
@RequestMapping(value = "festival")
public class FestController {
	@Autowired
	private FestService festService;
	@Autowired
	private FestReviewService festReviewService;
	@Autowired
	private MemberService memberService;
	ModelAndView model = new ModelAndView();
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	@RequestMapping(value = "list")
	public String moveFest() {
		return "tripInfo/festival.do";
	}
	//축제리스트뽑기
	@RequestMapping(value = "festival.do")	
	public void test(FestivalModel festivalModel, HttpServletRequest request, HttpServletResponse response,@RequestParam String areaCode, @RequestParam String eventStartDate) throws Exception {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
       
        String addr = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/searchFestival?serviceKey=";
        String serviceKey = "Tua5fEDly3iKvvzpx%2F7OOnK7t6QMYcBuGsaiBl%2BQalNS5gZamN1jCFjTpyrafwkC4dhvs4vd59C4cMGKikSx1g%3D%3D";
        String parameter = "";
        PrintWriter out = response.getWriter();    
        
 
        parameter = parameter + "&" + "MobileOS=ETC";
        parameter = parameter + "&" + "MobileApp=AppTest";
        parameter = parameter + "&" + "arrange=O";       
        parameter = parameter + "&" + "listYN=Y" ;
        parameter = parameter + "&" + "eventEndDate=" + eventStartDate ;
        parameter = parameter + "&" + "areaCode=" + areaCode ;
        parameter = parameter + "&" + "numOfRows=9";
        parameter = parameter + "&" + "_type=json";
        
        addr = addr + serviceKey + parameter;
        URL url = new URL(addr);
 
        System.out.println(addr);
 
        InputStream in = url.openStream();                           
 
        ByteArrayOutputStream bos1 = new ByteArrayOutputStream();     
        IOUtils.copy(in, bos1);           
        in.close();
        bos1.close();
 
        String mbos = bos1.toString("UTF-8");
 
        byte[] b = mbos.getBytes("UTF-8");
        String s = new String(b, "UTF-8"); 
        //out.println(s);
        
        JSONParser paser = new JSONParser();
        JSONObject obj = (JSONObject) paser.parse(s);
        System.out.println(obj.toString());
        
        JSONObject parse_response = (JSONObject) obj.get("response"); 
        JSONObject parse_body = (JSONObject) parse_response.get("body");
        JSONObject parse_items = (JSONObject) parse_body.get("items"); 
        JSONArray parse_item = (JSONArray) parse_items.get("item");
		/*
		 * JSONObject totalCount = (JSONObject) parse_body.get("totalCount");
		 * System.out.println(totalCount.toString());
		 */
		 
        String finaldata="";
        for (int i = 0; i < parse_item.size(); i++) { 
        	JSONObject imsi = (JSONObject) parse_item.get(i);
        	String addr1 = (String) imsi.get("addr1"); 
        	String firstimage = (String) imsi.get("firstimage"); 
        	String title = (String) imsi.get("title"); 
        	Object contenttypeId = imsi.get("contenttypeid");
        	Object contentId = imsi.get("contentid");
        	int typeid = Integer.parseInt(contenttypeId.toString());
        	int contid = Integer.parseInt(contentId.toString());
        	
        	
        	finaldata =finaldata+ "<div class=\"col-lg-4 col-md-6\" >"+
        			"<input type =\"hidden\" id=\"contentTypeId\" value=\""+ typeid +"\"/>" +
        			"<input type =\"hidden\" id=\"contentId\" value=\""+ contid +"\"/>" +
        			"<a href=\"content/"+typeid+"/"+contid+"\"class=\"listing-item-container compact\" >"+
        			"<div class=\"listing-item\">"+
        			"<img src=\"" +firstimage+"\" alt=\"\">"+
        			"<div class=\"listing-item-content\">"+
        			"<h3>"+title+"</h3>"+
        			"<span>"+addr1+"</span>"+
        			"</div>"+
        			"<span class=\"like-icon\"></span>"+
        			"</div>"+
        			"</a>"+
        			"</div>";
        	
//        	//데이터넣기위해 jsonparsing하는 애들
//        	Object mapX = imsi.get("mapx");
// 	        Object mapY = imsi.get("mapy");
// 	        float fmapx;
// 	        float fmapy;
// 	        if(mapX == null || mapY == null) {
// 	        	fmapx = 0;
// 	        	fmapy = 0;
// 	        }else {
// 	        	fmapx = Float.parseFloat(mapX.toString());
// 	 	        fmapy = Float.parseFloat(mapY.toString());
// 	        }
// 	         
// 
// 	        Object eventstartdate = imsi.get("eventstartdate"); 
//	        Object eventenddate = imsi.get("eventenddate");
//	        String date1 = eventstartdate.toString();
//	        String date2 = eventenddate.toString();
//	        
//	        Date fdate1 = new SimpleDateFormat("yyyyMMdd").parse(date1);
//	        Date fdate2 = new SimpleDateFormat("yyyyMMdd").parse(date2);
//	        
//	        Object areacode = imsi.get("areacode"); 
//	        int zcode = Integer.parseInt(areacode.toString());
//   
//        	//데이터넣기	
//        	festivalModel.setSubject(title);
//        	festivalModel.setFdate1(fdate1);
//        	festivalModel.setArea(addr1);
//        	festivalModel.setFdate2(fdate2);
//        	festivalModel.setFmapx(fmapx);
//        	festivalModel.setFmapy(fmapy);
//        	festivalModel.setZcode(zcode);
//        	
//        	
//        	System.out.println(i+"번째"+festivalModel);
//        	addData(festivalModel);
//        	Thread.sleep(100);
        	}	
        out.append(finaldata);
        out.flush();
        out.close();

    }
	public void addData(FestivalModel festivalModel) throws Exception {
		festService.insertFest(festivalModel);
	}
	
	// @RequestParam String areaCode, @RequestParam String eventStartDate
	@RequestMapping(value = "content/{typeid}/{contid}")
	public ModelAndView festContent(FestivalModel festivalModel, FestReviewModel festReviewModel, MemberModel memberModel, HttpServletRequest request, HttpServletResponse response,@PathVariable("typeid") int typeid,@PathVariable("contid") int contid) throws Exception {
		 request.setCharacterEncoding("utf-8");
	     response.setContentType("text/html; charset=utf-8");
	        model.clear();
	        List img = new ArrayList();
	        //축제 정보
	        for(int i=0;i<=2;i++) {
	        	if(i==0) {
	        		String addr = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/detailCommon?ServiceKey=";
	    	        String serviceKey = "Tua5fEDly3iKvvzpx%2F7OOnK7t6QMYcBuGsaiBl%2BQalNS5gZamN1jCFjTpyrafwkC4dhvs4vd59C4cMGKikSx1g%3D%3D";
	    	        String parameter = "";
	    	       
	    	        parameter = parameter + "&" + "MobileOS=ETC";
	    	        parameter = parameter + "&" + "MobileApp=AppTest";     
	    	        parameter = parameter + "&" + "defaultYN=Y&firstImageYN=Y&areacodeYN=Y&catcodeYN=Y&addrinfoYN=Y&mapinfoYN=Y&overviewYN=Y&transGuideYN=Y" ;
	    	        parameter = parameter + "&" + "contentTypeId=" + typeid ;
	    	        parameter = parameter + "&" + "contentId=" + contid ;
	    	        parameter = parameter + "&" + "_type=json";
	    	        
	    	        addr = addr + serviceKey + parameter;
	    	        URL url = new URL(addr);
	    	 
	    	        System.out.println(addr);
	    	 
	    	        InputStream in = url.openStream();                           
	    	 
	    	        ByteArrayOutputStream bos1 = new ByteArrayOutputStream();     
	    	        IOUtils.copy(in, bos1);           
	    	        in.close();
	    	        bos1.close();
	    	 
	    	        String mbos = bos1.toString("UTF-8");
	    	 
	    	        byte[] b = mbos.getBytes("UTF-8");
	    	        String s = new String(b, "UTF-8"); 
	    	        //out.println(s);
	    	        
	    	        JSONParser paser = new JSONParser();
	    	        JSONObject obj = (JSONObject) paser.parse(s);
	    	        JSONObject parse_response = (JSONObject) obj.get("response"); 
	    	        JSONObject parse_body = (JSONObject) parse_response.get("body");
	    	        JSONObject parse_items = (JSONObject) parse_body.get("items"); 
	    	        JSONObject parse_item = (JSONObject) parse_items.get("item");

	    	        String addr1 = (String) parse_item.get("addr1"); 
	    	        String title = (String) parse_item.get("title");
	    	        String firstimage = (String) parse_item.get("firstimage"); 
	    	        String overview = (String) parse_item.get("overview"); 
	    	        String tel = (String) parse_item.get("tel"); 
	    	        String telname = (String) parse_item.get("telname"); 
	    	        Object mapX = parse_item.get("mapx");
	    	        Object mapY = parse_item.get("mapy");
	    	        float mapx = Float.parseFloat(mapX.toString());
	    	        float mapy = Float.parseFloat(mapY.toString());
	    	        String link = (String) parse_item.get("homepage");	
	    	        String addr2 = addr1;
	    	        int lastIdx = addr1.lastIndexOf(",");
	    	        if(lastIdx!=0 && lastIdx != -1) {
	    	        	addr2 = addr1.substring(0,lastIdx-2);
	    	        	model.addObject("addr2",addr2);
	    	        }
	    	        
	    	        
	    	        
	    	        festivalModel.setName(title);
	    	        model.addObject("title",title);
	    	        model.addObject("addr1",addr1);
	    	        model.addObject("addr2",addr2);
	    	        model.addObject("firstimage",firstimage);
	    	        model.addObject("overview",overview);
	    	        model.addObject("tel",tel);
	    	        model.addObject(""
	    	        		+ ""
	    	        		+ "telname",telname);
	    	        model.addObject("mapx",mapx);
	    	        model.addObject("mapy",mapy);
	    	        model.addObject("link",link);
	    	        
	        	}else if(i==1) { //이미지를 출력하기 위한 다른 api
	        		String addr = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/detailImage?ServiceKey=";
	    	        String serviceKey = "Tua5fEDly3iKvvzpx%2F7OOnK7t6QMYcBuGsaiBl%2BQalNS5gZamN1jCFjTpyrafwkC4dhvs4vd59C4cMGKikSx1g%3D%3D";
	    	        String parameter = "";
	    	       
	    	        parameter = parameter + "&" + "MobileOS=ETC";
	    	        parameter = parameter + "&" + "MobileApp=AppTest";     
	    	        parameter = parameter + "&" + "imageYN=Y" ;
	    	        parameter = parameter + "&" + "contentTypeId=" + typeid ;
	    	        parameter = parameter + "&" + "contentId=" + contid ;
	    	        parameter = parameter + "&" + "_type=json";
	    	        
	    	        addr = addr + serviceKey + parameter;
	    	        URL url = new URL(addr);
	    	 
	    	        System.out.println(addr);
	    	 
	    	        InputStream in = url.openStream();                           
	    	 
	    	        ByteArrayOutputStream bos1 = new ByteArrayOutputStream();     
	    	        IOUtils.copy(in, bos1);           
	    	        in.close();
	    	        bos1.close();
	    	 
	    	        String mbos = bos1.toString("UTF-8");
	    	 
	    	        byte[] b = mbos.getBytes("UTF-8");
	    	        String s = new String(b, "UTF-8"); 
	    	        //out.println(s);
	    	        
	    	        JSONParser paser = new JSONParser();
	    	        JSONObject obj = (JSONObject) paser.parse(s);
	    	        System.out.println(obj.toString());
	    	        
	    	        JSONObject parse_response = (JSONObject) obj.get("response"); 
	    	        JSONObject parse_body = (JSONObject) parse_response.get("body");
	    	        JSONObject parse_items = (JSONObject) parse_body.get("items"); 
	    	        JSONArray parse_item = (JSONArray) parse_items.get("item");

	    	        for (int j = 0; j < parse_item.size(); j++) { 
	    	        	JSONObject imsi = (JSONObject) parse_item.get(j);
	    	        	String originimgurl = (String) imsi.get("originimgurl"); 
	    	        	img.add(originimgurl);
	    	        	
	    	        }
	    	        model.addObject("img",img);
	    	        
	        	}else {
	        		String addr = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/detailIntro?ServiceKey=";
	    	        String serviceKey = "Tua5fEDly3iKvvzpx%2F7OOnK7t6QMYcBuGsaiBl%2BQalNS5gZamN1jCFjTpyrafwkC4dhvs4vd59C4cMGKikSx1g%3D%3D";
	    	        String parameter = "";
	    	       
	    	        parameter = parameter + "&" + "MobileOS=ETC";
	    	        parameter = parameter + "&" + "MobileApp=AppTest";     
	    	        parameter = parameter + "&" + "introYN=Y" ;
	    	        parameter = parameter + "&" + "contentTypeId=" + typeid ;
	    	        parameter = parameter + "&" + "contentId=" + contid ;
	    	        parameter = parameter + "&" + "_type=json";
	    	        
	    	        addr = addr + serviceKey + parameter;
	    	        URL url = new URL(addr);
	    	 
	    	        System.out.println(addr);
	    	 
	    	        InputStream in = url.openStream();                           
	    	 
	    	        ByteArrayOutputStream bos1 = new ByteArrayOutputStream();     
	    	        IOUtils.copy(in, bos1);           
	    	        in.close();
	    	        bos1.close();
	    	 
	    	        String mbos = bos1.toString("UTF-8");
	    	 
	    	        byte[] b = mbos.getBytes("UTF-8");
	    	        String s = new String(b, "UTF-8"); 
	    	        //out.println(s);
	    	        
	    	        JSONParser paser = new JSONParser();
	    	        JSONObject obj = (JSONObject) paser.parse(s);
	    	        System.out.println(obj.toString());
	    	        
	    	        JSONObject parse_response = (JSONObject) obj.get("response"); 
	    	        JSONObject parse_body = (JSONObject) parse_response.get("body");
	    	        JSONObject parse_items = (JSONObject) parse_body.get("items"); 
	    	        JSONObject parse_item = (JSONObject) parse_items.get("item");
	    	        
	    	        Object eventstartdate = parse_item.get("eventstartdate"); 
	    	        Object eventenddate = parse_item.get("eventenddate");
	    	        String fdate1 = eventstartdate.toString();
	    	        String fdate2 = eventenddate.toString();
	    	
    	        	String fee = (String) parse_item.get("usetimefestival"); 
    	        	String agelimit = (String) parse_item.get("agelimit"); 
    	        	String playtime = (String) parse_item.get("playtime");
    	        	
    	        	model.addObject("fdate1",fdate1);
    		        model.addObject("fdate2",fdate2);
    		        model.addObject("fee",fee);
    		        model.addObject("agelimit",agelimit);
    		        model.addObject("playtime",playtime);
    		        model.addObject("typeid", typeid);
    		        model.addObject("contid", contid);
	        	}
	        }
	        if(festService.selectFestWithsubject(festivalModel) != null) {
	        	festivalModel = festService.selectFestWithsubject(festivalModel);
		        int festNum = festivalModel.getFestNum();
		        festReviewModel.setFestNum(festNum);  
		        List<FestReviewModel> reviewList = festReviewService.selectFestReviewListWithFestNum(festReviewModel);
		        int star = 0;
		        int size = reviewList.size();
		        int memNum = 0;
		        List<String> memList = new ArrayList<String>();
		        String id = "";
		        for(int i = 0 ; i <reviewList.size();i++) {
		        	star = star + reviewList.get(i).getStar();
		        	memNum = reviewList.get(i).getMemNum();
		        	memberModel.setMemnum(memNum);
				    memberModel = memberService.selectMemberWithMemNum(memberModel);
				    id = memberModel.getId();
				    memList.add(id);
		        }
		        
		        if(size > 0) {
		        	int avg1 = (star*10)/reviewList.size();
			        
			        double avg = ((double)avg1)/10;
			        
			        String emotion = "";
			        if(avg >= 4.5) {
			        	emotion = "Humor";
			        }else if(avg >= 3.5) {
			        	emotion = "Humor";
			        }else if(avg >= 2.5) {
			        	emotion = "Confused";
			        }else {
			        	emotion = "Angry ";
			        }
			        model.addObject("memList", memList);
			        model.addObject("avg", avg);
			        model.addObject("size", size);
			        model.addObject("emotion", emotion);
			        model.addObject("reviewList", reviewList);
		        }      
	        }
	        model.setViewName("tripInfo/festCont.do");	
	        return model;
    }
	@RequestMapping(value = "/review")
	public String setFestival(FestivalModel festmodel,FestReviewModel festReviewModel, HttpSession session,@RequestParam int typeid,@RequestParam int contid)throws Exception {	
		
		festmodel = festService.selectFestWithsubject(festmodel);
		int festNum = festmodel.getFestNum();
		// 축제 고유번호, memnum select
		int memNum = (Integer) session.getAttribute("SessionMemberMemnum");
		festReviewModel.setFestNum(festNum);
		festReviewModel.setMemNum(memNum);
		if(festReviewService.selectFestReviewOne(festReviewModel) == null) {
			festReviewService.insertFestReview(festReviewModel);
			System.out.println("됐을거아니야");
		} else {
			festReviewService.updateFestReview(festReviewModel);
		}
		
		return "redirect:/festival/content/" + typeid +"/"+ contid;

	}
	
	
}

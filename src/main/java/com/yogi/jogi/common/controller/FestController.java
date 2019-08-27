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

@Controller
@RequestMapping(value = "festival")
public class FestController {
	@Autowired
	private FestService festService;
	@Autowired
	private FestReviewService festReviewService;
	
	ModelAndView model = new ModelAndView();
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	@RequestMapping(value = "list")
	public String moveFest() {
		return "euny/festival.do";
	}
	//축제리스트뽑기
	@RequestMapping(value = "festival.do")	
	public void test(HttpServletRequest request, HttpServletResponse response,@RequestParam String areaCode, @RequestParam String eventStartDate) throws Exception {
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
        parameter = parameter + "&" + "eventStartDate=" + eventStartDate ;
        parameter = parameter + "&" + "areaCode=" + areaCode ;
        //parameter = parameter + "&" + "numOfRows=9999999";
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
        System.out.println("1"+parse_response.toString());
        System.out.println("2"+parse_body.toString());
        System.out.println("3"+parse_items.toString());
        System.out.println("5"+parse_item.size());
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
        	//String ddd = (String) a;
        	//System.out.println("뽑히냐??" + typeid);
        	//System.out.println(imsi.get("contentid"));
        	finaldata =finaldata+ "<div class=\"col-lg-4 col-md-6\" >"+
        			"<input type =\"hidden\" id=\"contentTypeId\" value=\""+ typeid +"\"/>" +
        			"<input type =\"hidden\" id=\"contentId\" value=\""+ contid +"\"/>" +
        			"<a href=\"content/"+typeid+"/"+contid+"\"class=\"listing-item-container compact\" >"+
        			"<div class=\"listing-item\">"+
        			"<img src=\"" +firstimage+"\" alt=\"\">"+
        			"<div class=\"listing-badge now-open\">Now Open</div>"+
        			"<div class=\"listing-item-content\">"+
        			"<div class=\"numerical-rating\" data-rating=\"3.5\"></div>"+
        			"<h3>"+title+" <i class=\"verified-icon\"></i></h3>"+
        			"<span>"+addr1+"</span>"+
        			"</div>"+
        			"<span class=\"like-icon\"></span>"+
        			"</div>"+
        			"</a>"+
        			"</div>";
        	}	

        out.append(finaldata);
        out.flush();
        out.close();

    }
	
	// @RequestParam String areaCode, @RequestParam String eventStartDate
	@RequestMapping(value = "content/{typeid}/{contid}")
	public ModelAndView test1(HttpServletRequest request, HttpServletResponse response,@PathVariable("typeid") int typeid,@PathVariable("contid") int contid) throws Exception {
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
	    	        
	
	    	        	
	    	        model.addObject("title",title);
	    	        model.addObject("addr1",addr1);
	    	        model.addObject("firstimage",firstimage);
	    	        model.addObject("overview",overview);
	    	        model.addObject("tel",tel);
	    	        model.addObject("telname",telname);
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
	    	        //System.out.println(startdate);
	    	        //SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	    	       
	    	        //Date fdate1 = sdf.parse(startdate);
	    	        //Date fdate2 = sdf.parse(enddate);

    	        	String fee = (String) parse_item.get("usetimefestival"); 
    	        	String agelimit = (String) parse_item.get("agelimit"); 
    	        	String playtime = (String) parse_item.get("playtime");
    	        	
    	        
    	        	model.addObject("fdate1",fdate1);
    		        model.addObject("fdate2",fdate2);
    		        model.addObject("fee",fee);
    		        model.addObject("agelimit",agelimit);
    		        model.addObject("playtime",playtime);
	        	}
	        }
	        
	        
	        model.setViewName("euny/festCont.do");	
	        return model;
    }
	@RequestMapping(value = "/review")
	public void setFestival(FestivalModel festmodel,FestReviewModel freviewmodel, HttpSession session)throws Exception {
		//insert전에 중복확인
		FestivalModel checkfest = festService.selectFestWithsubject(festmodel);
		int chkNum = checkfest.getFestNum();
		if( chkNum)
		
		//먼저 축제정보 insert
		festService.insertFest(festmodel);
		festmodel = festService.selectFestWithsubject(festmodel);
		System.out.println(festmodel);
		int festNum = festmodel.getFestNum();
		// 축제 고유번호 select
		freviewmodel.setFestNum(festNum);
		int memNum = (Integer) session.getAttribute("SessionMemberMemnum");
		freviewmodel.setMemNum(memNum);
		
		festReviewService.insertFestReview(freviewmodel);

	}
	
	
}

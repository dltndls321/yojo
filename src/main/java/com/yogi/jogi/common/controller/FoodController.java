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

import com.yogi.jogi.common.model.FoodModel;
import com.yogi.jogi.common.model.FoodReviewModel;
import com.yogi.jogi.common.service.FoodReviewService;
import com.yogi.jogi.common.service.FoodService;
import com.yogi.jogi.member.model.MemberModel;
import com.yogi.jogi.member.service.MemberService;



@Controller
@RequestMapping(value = "food")
public class FoodController {
	@Autowired
	private FoodService foodService;
	
	@Autowired 
	private FoodReviewService foodReviewService;
	
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
		return "tripInfo/food.do";
	}
	//관광지리스트뽑기
	@RequestMapping(value = "food.do" )	
	public void test(FoodModel foodModel, HttpServletRequest request, HttpServletResponse response,@RequestParam String areaCode, @RequestParam String foodCode, @RequestParam int pageNum) throws Exception {
		model.clear();
		request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
       
        String addr = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList?ServiceKey=";
        String serviceKey = "Tua5fEDly3iKvvzpx%2F7OOnK7t6QMYcBuGsaiBl%2BQalNS5gZamN1jCFjTpyrafwkC4dhvs4vd59C4cMGKikSx1g%3D%3D";
        String parameter = "";
        PrintWriter out = response.getWriter();    
    
 
        parameter = parameter + "&" + "MobileOS=ETC";
        parameter = parameter + "&" + "MobileApp=AppTest";
        parameter = parameter + "&" + "arrange=O";       
        parameter = parameter + "&" + "listYN=Y" ;
        parameter = parameter + "&" + "areaCode=" + areaCode ;
        parameter = parameter + "&cat1=A05&cat2=A0502&cat3=" + foodCode;
        parameter = parameter + "&" + "numOfRows=9";
        parameter = parameter + "&" + "pageNo=" + pageNum;
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
       
        JSONArray foodjson = new JSONArray();
        JSONObject fooddata = new JSONObject();
        JSONObject pagedata = new JSONObject();
        JSONObject pagingdata = new JSONObject();
        
        //페이징을 위한
        int pageSize = 9;
        int bottomLine = 3;
        int currentPage = pageNum;
        Object total = parse_body.get("totalCount");
        int count = Integer.parseInt(total.toString());
        
        int pageCount = count / pageSize + (count % pageSize ==0? 0 :1);
        int startPage = 1 + (currentPage - 1) / bottomLine * bottomLine;
        int endPage = startPage + bottomLine -1;//
        if (endPage > pageCount)
        	endPage = pageCount;
    	JSONObject pdata = new JSONObject();
    	pdata.put("count", total);

    	
    	String finaldata="";
		System.out.println("갯수"+total);
        for (int i = 0; i < parse_item.size(); i++) { 
        	JSONObject imsi = (JSONObject) parse_item.get(i);   
        	pagedata.put("pagedata", pdata);	
        	
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
        			"</div>"+
        			"</a>"+
        			"</div>";
			/*
			 * //데이터넣기위해 jsonparsing하는 애들 String cat = (String) imsi.get("cat3"); Object
			 * mapX = imsi.get("mapx"); Object mapY = imsi.get("mapy"); float foodx; float
			 * foody; if(mapX == null || mapY == null) { foodx = 0; foody = 0; }else {
			 * foodx= Float.parseFloat(mapX.toString()); foody =
			 * Float.parseFloat(mapY.toString()); }
			 * 
			 * Object areacode = imsi.get("areacode"); int zcode =
			 * Integer.parseInt(areacode.toString());
			 * 
			 * //데이터넣기 foodModel.setCategory(cat); foodModel.setArea(addr1);
			 * foodModel.setName(title); foodModel.setFoodx(foodx);
			 * foodModel.setFoody(foody); foodModel.setZcode(zcode);
			 * 
			 * System.out.println(i+"번째"+foodModel); addData(foodModel); Thread.sleep(100);
			 */
        	}
        
        String paging = "";
        if(startPage>bottomLine) {
        	int prev = startPage - bottomLine;
        	paging += "<li><a onclick =\"goChange("+prev+")\"}\" style=\"cursor: pointer;\"><i class=\"sl sl-icon-arrow-left\"></i></a></li>" ;
        }
        
        for (int j = startPage; j < endPage+1; j++) {
        	if(j==pageNum) {
        		paging += "<li><a class=\"current-page\" onclick =\"goChange("+j+")\" style=\"cursor: pointer;\">"+j+"</a></li>";	
        	}else if(j!=pageNum) {
        		paging += "<li><a  onclick =\"goChange("+j+")\" style=\"cursor: pointer;\">"+j+"</a></li>";	
        	}
		}
        if(endPage<pageCount) {
        	int next = startPage + bottomLine;
        	paging += "<li><a onclick =\"goChange("+next+")\" style=\"cursor: pointer;\"><i class=\"sl sl-icon-arrow-right\"></i></a></li>";
        }
        
        Object foodCont = finaldata;
        Object pagingdatas = paging;
        fooddata.put("foodCont", foodCont);
        pagingdata.put("pagingdata",pagingdatas);
        foodjson.add(fooddata);
        foodjson.add(pagingdata);
        foodjson.add(pagedata);
        
        
        System.out.println(foodjson.toString());
        out.print(foodjson.toString());
        out.flush();
        out.close();


    }
	public void addData(FoodModel foodModel) throws Exception {
		foodService.insertFood(foodModel);
	}
	
	@RequestMapping(value = "content/{typeid}/{contid}")
	public ModelAndView foodContent(FoodModel foodModel, FoodReviewModel foodReviewModel, MemberModel memberModel, HttpServletRequest request, HttpServletResponse response,@PathVariable("typeid") int typeid,@PathVariable("contid") int contid) throws Exception {
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
	    	        Object mapX = parse_item.get("mapx");
	    	        Object mapY = parse_item.get("mapy");
	    	        float mapx = Float.parseFloat(mapX.toString());
	    	        float mapy = Float.parseFloat(mapY.toString());
	    	        String link = (String) parse_item.get("homepage");	
	    	        
	    	        foodModel.setName(title);
	    	        foodModel.setArea(addr1);
	    	        model.addObject("title",title);
	    	        model.addObject("addr1",addr1);
	    	        model.addObject("firstimage",firstimage);
	    	        model.addObject("overview",overview);
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
	    	        
    	        	String chkcard = (String) parse_item.get("chkcreditcardfood"); 
    	        	String opentime = (String) parse_item.get("opentimefood");
    	        	String infocenter = (String) parse_item.get("infocenterfood");
    	        	String parking = (String) parse_item.get("parkingfood");
    	        	String restdate = (String) parse_item.get("restdatefood");
    	        	String smoking = (String) parse_item.get("smoking");
    	        	String packing = (String) parse_item.get("packing");
    	        	String firstmenu = (String) parse_item.get("firstmenu");
    	        	String treatmenu = (String) parse_item.get("treatmenu");
    	        	
    		        model.addObject("chkcard",chkcard);
    		        model.addObject("smoking",smoking);
    		        model.addObject("opentime",opentime);
    		        model.addObject("infocenter",infocenter);
    		        model.addObject("parking",parking);
    		        model.addObject("restdate",restdate);
    		        model.addObject("packing",packing);
    		        model.addObject("firstmenu",firstmenu);
    		        model.addObject("treatmenu",treatmenu);
    		        model.addObject("typeid", typeid);
    		        model.addObject("contid", contid);
    		        
	        	}
	        }
	        System.out.println(foodModel);
	        if(foodService.selectFoodWithname(foodModel) != null) {
	     
	        	foodModel = foodService.selectFoodWithname(foodModel);
	        	System.out.println(foodModel);
		        int foodNum = foodModel.getFoodNum();
		        foodReviewModel.setFoodNum(foodNum);  
		        List<FoodReviewModel> reviewList = foodReviewService.selectFoodReviewListWithFoodNum(foodReviewModel);
		        System.out.println(reviewList);
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
	        model.setViewName("tripInfo/foodCont.do");	
	        return model;
	}
	@RequestMapping(value = "/review")
	public String setFood(FoodModel foodmodel, FoodReviewModel foodReviewModel, HttpSession session,@RequestParam int typeid,@RequestParam int contid)throws Exception {	
		
		foodmodel = foodService.selectFoodWithname(foodmodel);
		int foodNum = foodmodel.getFoodNum();
		// 축제 고유번호, memnum select
		int memNum = (Integer) session.getAttribute("SessionMemberMemnum");
		foodReviewModel.setFoodNum(foodNum);
		foodReviewModel.setMemNum(memNum);
		
		if(foodReviewService.selectFoodReviewOne(foodReviewModel) == null) {
			foodReviewService.insertFoodReview(foodReviewModel);
		} else {
			foodReviewService.updateFoodReview(foodReviewModel);
		}
		
		return "redirect:/food/content/" + typeid + "/" + contid;

	}
	
	
	
}

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

import com.yogi.jogi.common.model.SpotModel;
import com.yogi.jogi.common.model.SpotReviewModel;
import com.yogi.jogi.common.service.SpotReviewService;
import com.yogi.jogi.common.service.SpotService;
import com.yogi.jogi.member.model.MemberModel;
import com.yogi.jogi.member.service.MemberService;



@Controller
@RequestMapping(value = "spot")
public class SpotController {
	@Autowired
	private SpotService spotService;
	
	@Autowired 
	private SpotReviewService spotReviewService;
	
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
		return "tripInfo/spot.do";
	}
	//관광지리스트뽑기
	@RequestMapping(value = "spot.do")	
	public void test(SpotModel spotModel, HttpServletRequest request, HttpServletResponse response,@RequestParam String areaCode, @RequestParam String spotCode, @RequestParam int pageNum) throws Exception {
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
        parameter = parameter + "&cat1=A01&cat2=A0101&cat3=" + spotCode;
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
        
        //페이징
        JSONArray spotjson = new JSONArray();
        JSONObject spotdata = new JSONObject();
        JSONObject pagedata = new JSONObject();
        JSONObject pagingdata = new JSONObject();
        
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
		 System.out.println("여기"+pdata.toString());
        String finaldata="";
        System.out.println("갯수"+total);
        for (int i = 0; i < parse_item.size(); i++) { 
        	JSONObject imsi = (JSONObject) parse_item.get(i);
        	pagedata.put("pagedata", pdata);
        	System.out.println("여기2"+pagedata.toString());
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
        	//데이터넣기위해 jsonparsing하는 애들
        	String cat = (String) imsi.get("cat3"); 
        	if(cat.equals("A01010100")|| cat.equals("A01010200")|| cat.equals("A01010300")) {
        		cat = "A01010100";
        	}

         	Object mapX = imsi.get("mapx");
  	        Object mapY = imsi.get("mapy");
  	        float smapx;
  	        float smapy;
  	        if(mapX == null || mapY == null) {
  	        	smapx = 0;
  	        	smapy = 0;
  	        }else {
  	        	smapx = Float.parseFloat(mapX.toString());
  	        	smapy = Float.parseFloat(mapY.toString());
  	        }
  	                
 	        Object areacode = imsi.get("areacode"); 
 	        int zcode = Integer.parseInt(areacode.toString());
    
         	//데이터넣기	
 	        spotModel.setCategory(cat);
 	        spotModel.setArea(addr1);
 	        spotModel.setName(title);
 	        spotModel.setSmapx(smapx);
 	        spotModel.setSmapy(smapy);
 	        spotModel.setZcode(zcode);
         	 	
         	System.out.println(i+"번째"+spotModel);
         	addData(spotModel);
         	Thread.sleep(100);
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
        
        Object spotCont = finaldata;
        Object pagingdatas = paging;
        spotdata.put("spotCont", spotCont);
        pagingdata.put("pagingdata",pagingdatas);
        spotjson.add(spotdata); 	//0
        spotjson.add(pagingdata); 	//1
        spotjson.add(pagedata);		//2
        
        
        System.out.println(spotjson.toString());
        out.print(spotjson.toString());
        out.flush();
        out.close();

    }
	public void addData(SpotModel spotModel) throws Exception {
		spotService.insertSpot(spotModel);
	}
	
	@RequestMapping(value = "content/{typeid}/{contid}")
	public ModelAndView spotContent(SpotModel spotModel, SpotReviewModel spotReviewModel, MemberModel memberModel, HttpServletRequest request, HttpServletResponse response,@PathVariable("typeid") int typeid,@PathVariable("contid") int contid) throws Exception {
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
	    	        
	    	        String addr2 = addr1;
	    	        int lastIdx = addr1.lastIndexOf(",");
	    	        if(lastIdx!=0 && lastIdx != -1) {
	    	        	addr2 = addr1.substring(0,lastIdx-2);
	    	        	model.addObject("addr2",addr2);
	    	        }
	    	        
	    	        System.out.println(title + " : " + addr2);
	    	        spotModel.setName(title);
	    	        model.addObject("title",title);
	    	        model.addObject("addr1",addr1);
	    	        model.addObject("addr2",addr2);
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
	    	        

	    	
    	        	String baby = (String) parse_item.get("chkbabycarriage"); 
    	        	String chkcard = (String) parse_item.get("chkcreditcard"); 
    	        	String usetime = (String) parse_item.get("usetime");
    	        	String infocenter = (String) parse_item.get("infocenter");
    	        	String parking = (String) parse_item.get("parking");
    	        	String restdate = (String) parse_item.get("restdate");
    	        	

    		        model.addObject("chkcard",chkcard);
    		        model.addObject("baby",baby);
    		        model.addObject("usetime",usetime);
    		        model.addObject("infocenter",infocenter);
    		        model.addObject("parking",parking);
    		        model.addObject("restdate",restdate);
    		        model.addObject("typeid", typeid);
    		        model.addObject("contid", contid);
	        	}
	        }
	        System.out.println(spotModel);
	        if(spotService.selectSpotWithname(spotModel) != null) {
	     
	        	spotModel = spotService.selectSpotWithname(spotModel);
	        	System.out.println(spotModel);
		        int spotNum = spotModel.getSpotNum();
		        spotReviewModel.setSpotNum(spotNum);  
		        List<SpotReviewModel> reviewList = spotReviewService.selectSpotReviewListWithSpotNum(spotReviewModel);
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
	        model.setViewName("tripInfo/spotCont.do");	
	        return model;
	}
	@RequestMapping(value = "/review")
	public String setSpot(SpotModel spotmodel, SpotReviewModel spotReviewModel, HttpSession session,@RequestParam int typeid,@RequestParam int contid)throws Exception {	
		
		spotmodel = spotService.selectSpotWithname(spotmodel);
		int spotNum = spotmodel.getSpotNum();
		// 축제 고유번호, memnum select
		int memNum = (Integer) session.getAttribute("SessionMemberMemnum");
		spotReviewModel.setSpotNum(spotNum);
		spotReviewModel.setMemNum(memNum);
		
		if(spotReviewService.selectSpotReviewOne(spotReviewModel) == null) {
			spotReviewService.insertSpotReview(spotReviewModel);
		} else {
			spotReviewService.updateSpotReview(spotReviewModel);
		}
		
		return "redirect:/spot/content/" + typeid + "/" + contid;

	}
	
	
}

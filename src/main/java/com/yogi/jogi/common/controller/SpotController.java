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

import com.yogi.jogi.common.model.FestivalModel;
import com.yogi.jogi.common.model.SpotModel;
import com.yogi.jogi.common.service.SpotService;
import com.yogi.jogi.member.service.MemberService;



@Controller
@RequestMapping(value = "spot")
public class SpotController {
	@Autowired
	private SpotService spotService;
	/*
	 * @Autowired private SpotReviewService festReviewService;
	 */
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
	public void test(SpotModel spotModel, HttpServletRequest request, HttpServletResponse response,@RequestParam String areaCode, @RequestParam String spotCode) throws Exception {
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
        parameter = parameter + "&" + "numOfRows=1";
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
        out.append(finaldata);
        out.flush();
        out.close();


    }
	public void addData(SpotModel spotModel) throws Exception {
		spotService.insertSpot(spotModel);
	}
	
	
}

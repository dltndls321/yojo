package com.yogi.jogi.common.controller;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
@RequestMapping(value = "main")
public class MainController {
	@RequestMapping(value = "main")
	public String moveMain() {
		return "index/index.do";
	}
	@RequestMapping(value = "index3")
	public String moveMain2() {
		return "index/index3.do";
	}
	@RequestMapping(value = "festival")
	public String test() {
		return "euny/festival.do";
	}
	
	@RequestMapping(value = "test.do")
	public void test(HttpServletRequest request, HttpServletResponse response, @RequestParam String areaCode, @RequestParam String eventStartDate) throws Exception {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        String addr = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/searchFestival?serviceKey=";
        String serviceKey = "Tua5fEDly3iKvvzpx%2F7OOnK7t6QMYcBuGsaiBl%2BQalNS5gZamN1jCFjTpyrafwkC4dhvs4vd59C4cMGKikSx1g%3D%3D";
        String parameter = "";
        PrintWriter out = response.getWriter();                                        //클라이언트로 보낼 TEXT DATA, JSON에 넣을 때 쭉 나열하는듯
 
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
 
        InputStream in = url.openStream();                            //URL로 부터 자바로 데이터 읽어오도록 URL객체로 스트림 열기
 
        ByteArrayOutputStream bos1 = new ByteArrayOutputStream();        //InputStream의 데이터들을 바이트 배열로 저장하기 위해
        IOUtils.copy(in, bos1);            //InputStream의 데이터를 바이트 배열로 복사
        in.close();
        bos1.close();
 
        String mbos = bos1.toString("UTF-8");
 
        byte[] b = mbos.getBytes("UTF-8");
        String s = new String(b, "UTF-8");        //String으로 풀었다가 byte배열로 했다가 다시 String으로 해서 json에 저장할 배열을 print?? 여긴 잘 모르겠다
        //out.println(s);
        
        JSONParser paser = new JSONParser();
        JSONObject obj = (JSONObject) paser.parse(s);
        System.out.println(obj.toString());
        
        JSONObject parse_response = (JSONObject) obj.get("response"); //response key값에 맞는 Value인 JSON객체를 가져옵니다. // response 로 부터 body 찾아오기 
        JSONObject parse_body = (JSONObject) parse_response.get("body"); // body 로 부터 items 받아오기 
        JSONObject parse_items = (JSONObject) parse_body.get("items"); // items로 부터 itemlist 를 받아옵니다. itemlist : 뒤에 [ 로 시작하므로 jsonarray입니다. 
        JSONArray parse_item = (JSONArray) parse_items.get("item"); // 각각 요소 출력 
        System.out.println("1"+parse_response.toString());
        System.out.println("2"+parse_body.toString());
        System.out.println("3"+parse_items.toString());
        System.out.println("5"+parse_item.size());

		 
        String finaldata="";
        for (int i = 0; i < parse_item.size(); i++) { // 해당 JSONArray객체에 값을 차례대로 가져와서 읽습니다. 
        	JSONObject imsi = (JSONObject) parse_item.get(i);
        	String addr1 = (String) imsi.get("addr1"); 
        	String firstimage = (String) imsi.get("firstimage"); 
        	String title = (String) imsi.get("title"); 
        	finaldata =finaldata+ "<div class=\"col-lg-4 col-md-6\" >"+
        			"<a href=\"listings-single-page.html\" class=\"listing-item-container compact\">"+
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
//        System.out.println("최종데이터"+finaldata);
        out.append(finaldata);
        out.flush();
        out.close();


    }
}

package com.yogi.jogi.map.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.yogi.jogi.map.service.MapService;

import net.sf.json.JSON;
import net.sf.json.JSONArray;

@Controller
@RequestMapping("map")
public class MapController {
	private static final Logger logger = LoggerFactory.getLogger(MapController.class);
	
	
	ModelAndView mv = new ModelAndView();

	@Autowired
	private MapService mapService;

	@RequestMapping("test") //
	public ModelAndView test() throws Exception {

		mv.clear();
		System.out.println(mapService.getFoodList());

		mv.addObject("foodList", mapService.getFoodList());
		mv.setViewName("maptest/maptest.do"); //

		return mv;
	}

	@RequestMapping("test2") //
	public ModelAndView test2(@RequestParam("startPoint") String startPoint, @RequestParam("endPoint") String endPoint)
			throws Exception {

		mv.clear();
		 
		 String url = "https://dapi.kakao.com/v2/local/search/address.json?query="+startPoint;
		 
		 String json = getJSONData(url);
		 System.out.println(json);

		System.out.println(mapService.getFoodList2());

		mv.addObject("foodList", mapService.getFoodList2());
		mv.setViewName("maptest/maptest.do"); //

		return mv;
	}

	@RequestMapping("search") //
	public ModelAndView search() throws Exception {

		mv.clear();

		mv.setViewName("maptest/mapSearch.do"); //

		return mv;
	}

	private static String getJSONData(String apiUrl) throws Exception {
        String jsonString = new String();
        String buf;
        String apikey = "13cd4e6df49574ac7ccc468bb2a978a2"; //apikey
         
        URL url = new URL(apiUrl);
        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
        String auth = "KakaoAK "+apikey;
        conn.setRequestMethod("GET");
        conn.setRequestProperty("X-Requested-With", "curl");
        conn.setRequestProperty("Authorization", auth);
         
        BufferedReader br = new BufferedReader(new InputStreamReader(
                conn.getInputStream(), "UTF-8"));
        while ((buf = br.readLine()) != null) {
            jsonString += buf;
        }
        return jsonString;
    }

}

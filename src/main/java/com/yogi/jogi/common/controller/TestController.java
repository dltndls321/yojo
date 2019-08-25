package com.yogi.jogi.common.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.yogi.jogi.common.model.TestModel;
import com.yogi.jogi.common.service.TestService;


@Controller
public class TestController {
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);
	@Inject
	private TestService testService;
	
	@RequestMapping(value = "main.do")
	public String main(HttpServletResponse response) throws Exception{
		return "/main/Main";
	}
	
	@RequestMapping(value = "index.do")
	public String index(HttpServletResponse response) throws Exception{
		return "/insertTable/InsertTable";
	}
	
	@RequestMapping(value = "insert.do")
	public ModelAndView inserttest(HttpServletResponse response,@RequestParam() int num,@RequestParam() String name)throws Exception{
		response.setContentType("text/html; charset=utf-8");
		TestModel vo = new TestModel();
		vo.setName(name);
		vo.setNum(num);
		ModelAndView model = new ModelAndView();
		testService.insertTest(vo);
		model.addObject("test",vo);
		model.setViewName("aaa");
		return model;
	}
	
	@RequestMapping(value = "index1.do")
	public String index1(HttpServletResponse response) throws Exception{
		return "/viewTable/viewOneTest";
	}
	@RequestMapping(value = "selectTest.do")
	public ModelAndView selectTest(HttpServletResponse response,@RequestParam() int num) throws Exception{
		ModelAndView model = new ModelAndView();
		TestModel vo = testService.selectTest(num);
		model.addObject("testVO",vo);
		model.setViewName("/viewTable/viewOneTest2");
		return model;
	}
	@RequestMapping(value = "index2.do")
	public ModelAndView index2(HttpServletResponse response) throws Exception{
		response.setContentType("text/html; charset=utf-8");
		List<TestModel> list = testService.selectTestAll();
		ModelAndView model = new ModelAndView();
		model.addObject("testList",list);
		model.setViewName("/viewTable/viewAllTest");
		return model;
	}
	@RequestMapping(value = "index3.do")
	public String index3(HttpServletResponse response) throws Exception{
		
		return "/deleteTable/DeleteTest";
	}
	@RequestMapping(value = "deleteTest.do")
	public ModelAndView deleteTest(HttpServletResponse response,@RequestParam() int num) throws Exception{
		testService.deleteTest(num);
		List<TestModel> list = testService.selectTestAll();
		ModelAndView model = new ModelAndView();
		model.addObject("testList",list);
		model.setViewName("/viewTable/viewAllTest");
		return model;
	}
	
	@RequestMapping(value = "index4.do")
	public String index4(HttpServletResponse response) throws Exception{
		
		return "/updateTable/UpdateTest";
	}
	@RequestMapping(value = "updateTest.do")
	public ModelAndView updateTest(HttpServletResponse response,@RequestParam() int num,@RequestParam() String name) throws Exception{
		ModelAndView model = new ModelAndView();
		TestModel vo = new TestModel();
		vo.setName(name);
		vo.setNum(num);
		testService.updateTest(vo);
		List<TestModel> list = testService.selectTestAll();
		model.addObject("testList",list);
		model.setViewName("/viewTable/viewAllTest");
		return model;
	}
	
	@RequestMapping(value = "maptest.do")
	public String maptest(HttpServletResponse response) throws Exception{
		return "/maptest/maptest";
	}
	
	
	
}

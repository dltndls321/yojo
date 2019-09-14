package com.yogi.jogi.map.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yogi.jogi.map.dao.MapDao;
import com.yogi.jogi.map.model.CourseModel;
import com.yogi.jogi.map.model.MapModel;
import com.yogi.jogi.map.service.MapService;
@Service
public class MapServiceImpl implements MapService{
	@Autowired
	private MapDao dao;

	@Override
	public List<MapModel> getFoodList() throws Exception {
		// TODO Auto-generated method stub
		return dao.getFoodList();
	}

	@Override
	public List<MapModel> getFoodList2(float startX, float startY, float endX, float endY) throws Exception {
		Map map = new HashMap();
		map.put("startX", startX);
		map.put("startY", startY);
		map.put("endX", endX);
		map.put("endY", endY);
		// TODO Auto-generated method stub
		return dao.getFoodList2(map);
	}

	@Override
	public int insertCourse(CourseModel courseModel) throws Exception {
		// TODO Auto-generated method stub
		return dao.insertCourse(courseModel);
	}

	@Override
	public List<CourseModel> getCourseList(String subject) throws Exception {
		// TODO Auto-generated method stub
		return dao.getCourseList(subject);
	}

	@Override
	public CourseModel getCourseListOne(String subject) throws Exception {
		// TODO Auto-generated method stub
		return dao.getCourseListOne(subject);
	}

	@Override
	public MapModel getFoodArea(String name) throws Exception {
		// TODO Auto-generated method stub
		return dao.getFoodArea(name);
	}

	@Override
	public List<CourseModel> getCourseListPaging(int start, int end, String subject) throws Exception {
		Map map = new HashMap();
		map.put("start",start);
		map.put("end",end);
		map.put("subject",subject);
		return dao.getCourseListPaging(map);
	}

	@Override
	public CourseModel getCourseListNumOne(int coursenum) throws Exception {
		// TODO Auto-generated method stub
		return dao.getCourseListNumOne(coursenum);
	}
	
	
	
	
	
}

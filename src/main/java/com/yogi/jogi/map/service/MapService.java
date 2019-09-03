package com.yogi.jogi.map.service;

import java.util.List;

import com.yogi.jogi.common.model.FestReviewModel;
import com.yogi.jogi.map.model.CourseModel;
import com.yogi.jogi.map.model.MapModel;

public interface MapService {
	public List<MapModel> getFoodList() throws Exception;
	public MapModel getFoodArea(String name) throws Exception;
	public List<MapModel> getFoodList2(float startX, float startY, float endX, float endY) throws Exception;
	public int insertCourse(CourseModel courseModel) throws Exception;
	public List<CourseModel> getCourseList(String subject) throws Exception;
	public CourseModel getCourseListOne(String subject) throws Exception;
	
}

package com.yogi.jogi.admin.service;


import com.yogi.jogi.admin.model.AdminCourseModel;



public interface AdminCourseService {
	public int insertCourse(AdminCourseModel adminCourseModel) throws Exception;
	public AdminCourseModel selectCourse(AdminCourseModel adminCourseModel) throws Exception;
	
	
}

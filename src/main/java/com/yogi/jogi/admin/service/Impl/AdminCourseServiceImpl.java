package com.yogi.jogi.admin.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yogi.jogi.admin.dao.AdminCourseDao;
import com.yogi.jogi.admin.model.AdminCourseModel;
import com.yogi.jogi.admin.service.AdminCourseService;



@Service
public class AdminCourseServiceImpl implements AdminCourseService{
	@Autowired
	private AdminCourseDao dao;

	@Override
	public int insertCourse(AdminCourseModel adminCourseModel ) throws Exception {
		// TODO Auto-generated method stub
		return dao.insertCourse(adminCourseModel);
	}


	
	
}

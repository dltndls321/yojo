package com.yogi.jogi.admin.dao;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yogi.jogi.admin.model.AdminCourseModel;





@Repository
public class AdminCourseDao {
	@Autowired
	private SqlSession sqlSession;
	private final String Namespace = "AdminCourseMapperNS";
	public int insertCourse(AdminCourseModel adminCourseModel) throws Exception {
		return sqlSession.insert(Namespace + ".insertCourse" , adminCourseModel);
	}
}

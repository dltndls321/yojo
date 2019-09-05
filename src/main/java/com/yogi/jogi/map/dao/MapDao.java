package com.yogi.jogi.map.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yogi.jogi.map.model.CourseModel;
import com.yogi.jogi.map.model.MapModel;

@Repository
public class MapDao {
	@Autowired
	private SqlSession sqlSession;
	
	private final String Namespace = "MapMapperNS";
	
	public List<MapModel> getFoodList() throws Exception {
		return sqlSession.selectList(Namespace+".getFoodList");
	}
	
	public List<MapModel> getFoodList2(Map map) throws Exception {
		return sqlSession.selectList(Namespace+".getFoodList2",map);
	}

	public int insertCourse(CourseModel courseModel) {
		// TODO Auto-generated method stub
		return sqlSession.insert(Namespace + ".insertCourse",courseModel);
	}

	public List<CourseModel> getCourseList(String subject) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(Namespace + ".getCourseList",subject);
	}

	public CourseModel getCourseListOne(String subject) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(Namespace + ".getCourseListOne",subject);
	}

	public MapModel getFoodArea(String name) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(Namespace + ".getFoodArea", name);
	}
}

package com.yogi.jogi.map.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yogi.jogi.map.model.MapModel;

@Repository
public class MapDao {
	@Autowired
	private SqlSession sqlSession;
	
	private final String Namespace = "MapMapperNS";
	
	public List<MapModel> getFoodList() throws Exception {
		return sqlSession.selectList(Namespace+".getFoodList");
	}
	
	public List<MapModel> getFoodList2(MapModel mapModel) throws Exception {
		return sqlSession.selectList(Namespace+".getFoodList2");
	}
}

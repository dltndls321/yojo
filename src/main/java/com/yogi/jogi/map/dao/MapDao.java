package com.yogi.jogi.map.dao;

import java.util.List;
import java.util.Map;

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
	
	public List<MapModel> getFoodList2(Map map) throws Exception {
		return sqlSession.selectList(Namespace+".getFoodList2",map);
	}
}

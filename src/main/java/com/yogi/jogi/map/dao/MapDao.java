package com.yogi.jogi.map.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MapDao {
	@Autowired
	private SqlSession sqlSession;
	
	private static final String Namespace = "";
}

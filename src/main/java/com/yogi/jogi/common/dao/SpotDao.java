package com.yogi.jogi.common.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yogi.jogi.common.model.FestivalModel;
import com.yogi.jogi.common.model.SpotModel;

@Repository
public class SpotDao {
	@Autowired
	private SqlSession sqlSession;
	private final String Namespace = "FestMapperNS";
	public int insertFest(SpotModel spotModel) throws Exception {
		return sqlSession.insert(Namespace + ".insertFest" , spotModel);
	}
	
	public List<SpotModel> selectFestList() throws Exception {
		return sqlSession.selectList(Namespace + ".selectFestList");
	}
	
	public SpotModel selectFestWithFestNum(SpotModel spotModel) throws Exception {
		return sqlSession.selectOne(Namespace + ".selectFestWithFestNum",spotModel);
	}

	public SpotModel selectFestWithsubject(SpotModel spotModel) {
		return sqlSession.selectOne(Namespace + ".selectFestWithsubject",spotModel);
	}
}

package com.yogi.jogi.common.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yogi.jogi.common.model.FestivalModel;

@Repository
public class FestDao {
	@Autowired
	private SqlSession sqlSession;
	private final String Namespace = "FestMapperNS";
	public int insertFest(FestivalModel festivalModel) throws Exception {
		return sqlSession.insert(Namespace + ".insertFest" , festivalModel);
	}
	
	public List<FestivalModel> selectFestList() throws Exception {
		return sqlSession.selectList(Namespace + ".selectFestList");
	}
	
	public FestivalModel selectFestWithFestNum(FestivalModel festivalModel) throws Exception {
		return sqlSession.selectOne(Namespace + ".selectFestWithFestNum",festivalModel);
	}

	public FestivalModel selectFestWithsubject(FestivalModel festivalModel) {
		return sqlSession.selectOne(Namespace + ".selectFestWithsubject",festivalModel);
	}
	
	public List<FestivalModel> selectFestListXY(Map map) throws Exception {
		
		return sqlSession.selectList(Namespace + ".selectFestListXY",map);
	}
}

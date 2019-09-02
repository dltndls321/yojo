package com.yogi.jogi.common.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yogi.jogi.common.model.SpotModel;

@Repository
public class SpotDao {
	@Autowired
	private SqlSession sqlSession;
	private final String Namespace = "SpotMapperNS";
	public int insertSpot(SpotModel spotModel) throws Exception {
		return sqlSession.insert(Namespace + ".insertSpot" , spotModel);
	}
	
	public List<SpotModel> selectSpotList() throws Exception {
		return sqlSession.selectList(Namespace + ".selectSpotList");
	}
	
	public SpotModel selectSpotWithSpotNum(SpotModel spotModel) throws Exception {
		return sqlSession.selectOne(Namespace + ".selectSpotWithSpotNum",spotModel);
	}

	public SpotModel selectSpotWithname(SpotModel spotModel) {
		return sqlSession.selectOne(Namespace + ".selectSpotWithname",spotModel);
	}
	
	public List<SpotModel> selectSpotListXY(Map map) throws Exception {

		return sqlSession.selectList(Namespace + ".selectSpotListXY", map);
	}

	public List<SpotModel> selectSpotAdmin(SpotModel spotModel) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(Namespace + ".selectSpotAdmin", spotModel);
	}
}

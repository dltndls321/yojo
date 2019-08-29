package com.yogi.jogi.common.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yogi.jogi.common.model.SpotReviewModel;



@Repository
public class SpotReviewDao {
	@Autowired
	private SqlSession sqlSession;
	private final String Namespace = "SpotReviewMapperNS";
	public int insertSpotReview(SpotReviewModel spotReviewModel) throws Exception {
		return sqlSession.insert(Namespace + ".insertSpotReview" , spotReviewModel);
	}
	public int updateSpotReview(SpotReviewModel spotReviewModel) {
		return sqlSession.update(Namespace + ".updateSpotReview",spotReviewModel);
	}
	public List<SpotReviewModel> selectSpotReviewList() {
		return sqlSession.selectList(Namespace + ".selectSpotReviewList");
	}
	public List<SpotReviewModel> selectSpotReviewListWithSpotNum(SpotReviewModel spotReviewModel) {
		return sqlSession.selectList(Namespace + ".selectSpotReviewListWithSpotNum", spotReviewModel);
	}
	public List<SpotReviewModel> selectSpotReviewWithMemNum(SpotReviewModel spotReviewModel) {
		return sqlSession.selectList(Namespace + ".selectSpotReviewWithMemNum", spotReviewModel);
	}
	public SpotReviewModel selectSpotReviewOne(SpotReviewModel spotReviewModel) {
		return sqlSession.selectOne(Namespace + ".selectSpotReviewOne",spotReviewModel);
	}
}

package com.yogi.jogi.common.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yogi.jogi.common.model.FestReviewModel;



@Repository
public class FestReviewDao {
	@Autowired
	private SqlSession sqlSession;
	private final String Namespace = "FestReviewMapperNS";
	public int insertFestReview(FestReviewModel festReviewModel) throws Exception {
		return sqlSession.insert(Namespace + ".insertFestReview" , festReviewModel);
	}
	public int updateFestReview(FestReviewModel festReviewModel) {
		return sqlSession.update(Namespace + ".updateFestReview",festReviewModel);
	}
	public List<FestReviewModel> selectFestReviewList() {
		return sqlSession.selectList(Namespace + ".selectFestReviewList");
	}
	public List<FestReviewModel> selectFestReviewListWithFestNum(FestReviewModel festReviewModel) {
		return sqlSession.selectList(Namespace + ".selectFestReviewListWithFestNum", festReviewModel);
	}
	public List<FestReviewModel> selectFestReviewWithMemNum(FestReviewModel festReviewModel) {
		return sqlSession.selectList(Namespace + ".selectFestReviewWithMemNum", festReviewModel);
	}
	public FestReviewModel selectFestReviewOne(FestReviewModel festReviewModel) {
		return sqlSession.selectOne(Namespace + ".selectFestReviewOne",festReviewModel);
	}
}

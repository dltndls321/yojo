package com.yogi.jogi.common.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yogi.jogi.common.model.FoodReviewModel;



@Repository
public class FoodReviewDao {
	@Autowired
	private SqlSession sqlSession;
	private final String Namespace = "FoodReviewMapperNS";
	public int insertFoodReview(FoodReviewModel foodReviewModel) throws Exception {
		return sqlSession.insert(Namespace + ".insertFoodReview" , foodReviewModel);
	}
	public int updateFoodReview(FoodReviewModel foodReviewModel) {
		return sqlSession.update(Namespace + ".updateFoodReview",foodReviewModel);
	}
	public List<FoodReviewModel> selectFoodReviewList() {
		return sqlSession.selectList(Namespace + ".selectFoodReviewList");
	}
	public List<FoodReviewModel> selectFoodReviewListWithFoodNum(FoodReviewModel foodReviewModel) {
		return sqlSession.selectList(Namespace + ".selectFoodReviewListWithFoodNum", foodReviewModel);
	}
	public List<FoodReviewModel> selectFoodReviewWithMemNum(FoodReviewModel foodReviewModel) {
		return sqlSession.selectList(Namespace + ".selectFoodReviewWithMemNum", foodReviewModel);
	}
	public FoodReviewModel selectFoodReviewOne(FoodReviewModel foodReviewModel) {
		return sqlSession.selectOne(Namespace + ".selectFoodReviewOne",foodReviewModel);
	}
}

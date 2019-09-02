package com.yogi.jogi.common.service;

import java.util.List;

import com.yogi.jogi.common.model.FoodReviewModel;


public interface FoodReviewService {
	public int insertFoodReview(FoodReviewModel foodReviewModel) throws Exception;
	public List<FoodReviewModel> selectFoodReviewList() throws Exception;
	public List<FoodReviewModel> selectFoodReviewListWithFoodNum(FoodReviewModel foodReviewModel) throws Exception;
	public List<FoodReviewModel> selectFoodReviewWithMemNum(FoodReviewModel foodReviewModel) throws Exception;
	public FoodReviewModel selectFoodReviewOne(FoodReviewModel foodReviewModel) throws Exception;
	public int updateFoodReview(FoodReviewModel foodReviewModel) throws Exception;
	
	
}

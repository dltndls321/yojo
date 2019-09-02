package com.yogi.jogi.common.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yogi.jogi.common.dao.FoodReviewDao;
import com.yogi.jogi.common.model.FoodReviewModel;
import com.yogi.jogi.common.service.FoodReviewService;





@Service
public class FoodReviewServiceImpl implements FoodReviewService{
	@Autowired
	private FoodReviewDao dao;

	@Override
	public int insertFoodReview(FoodReviewModel foodReviewModel) throws Exception {
		// TODO Auto-generated method stub
		return dao.insertFoodReview(foodReviewModel);
	}

	@Override
	public int updateFoodReview(FoodReviewModel foodReviewModel) throws Exception {
		// TODO Auto-generated method stub
		return dao.updateFoodReview(foodReviewModel);
	}

	@Override
	public List<FoodReviewModel> selectFoodReviewList() throws Exception {
		// TODO Auto-generated method stub
		return dao.selectFoodReviewList();
	}

	@Override
	public List<FoodReviewModel> selectFoodReviewListWithFoodNum(FoodReviewModel foodReviewModel) throws Exception {
		// TODO Auto-generated method stub
		return dao.selectFoodReviewListWithFoodNum(foodReviewModel);
	}

	@Override
	public List<FoodReviewModel> selectFoodReviewWithMemNum(FoodReviewModel foodReviewModel) throws Exception {
		// TODO Auto-generated method stub
		return dao.selectFoodReviewWithMemNum(foodReviewModel);
	}

	@Override
	public FoodReviewModel selectFoodReviewOne(FoodReviewModel foodReviewModel) throws Exception {
		// TODO Auto-generated method stub
		return dao.selectFoodReviewOne(foodReviewModel);
	}
	
	
}

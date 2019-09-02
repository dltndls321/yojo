package com.yogi.jogi.common.service;

import java.util.List;

import com.yogi.jogi.common.model.FoodModel;


public interface FoodService {
	public int insertFood(FoodModel foodModel) throws Exception;
	
	public List<FoodModel> selectFoodList() throws Exception;
	public FoodModel selectFoodWithFoodNum(FoodModel foodModel) throws Exception;
	public FoodModel selectFoodWithname(FoodModel foodModel) throws Exception;
	
}

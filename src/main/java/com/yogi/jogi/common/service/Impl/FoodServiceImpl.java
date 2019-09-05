package com.yogi.jogi.common.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yogi.jogi.common.dao.FoodDao;
import com.yogi.jogi.common.model.FoodModel;
import com.yogi.jogi.common.service.FoodService;


@Service
public class FoodServiceImpl implements FoodService{
	@Autowired
	private FoodDao dao;

	@Override
	public int insertFood(FoodModel foodModel) throws Exception {
		// TODO Auto-generated method stub
		return dao.insertFood(foodModel);
	}

	@Override
	public List<FoodModel> selectFoodList() throws Exception {
		// TODO Auto-generated method stub
		return dao.selectFoodList();
	}

	@Override
	public FoodModel selectFoodWithFoodNum(FoodModel foodModel) throws Exception {
		// TODO Auto-generated method stub
		return dao.selectFoodWithFoodNum(foodModel);
	}

	@Override
	public FoodModel selectFoodWithname(FoodModel foodModel) throws Exception {
		// TODO Auto-generated method stub
		return  dao.selectFoodWithname(foodModel);
	}

	@Override
	public List<FoodModel> selectFoodAdmin(FoodModel foodModel) throws Exception {
		// TODO Auto-generated method stub
		return dao.selectFoodAdmin(foodModel);
	}
	
	
	
	
	
}

package com.yogi.jogi.common.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yogi.jogi.common.model.FoodModel;

@Repository
public class FoodDao {
	@Autowired
	private SqlSession sqlSession;
	private final String Namespace = "FoodMapperNS";
	public int insertFood(FoodModel foodModel) throws Exception {
		return sqlSession.insert(Namespace + ".insertFood" , foodModel);
	}
	
	public List<FoodModel> selectFoodList() throws Exception {
		return sqlSession.selectList(Namespace + ".selectFoodList");
	}
	
	public FoodModel selectFoodWithFoodNum(FoodModel foodModel) throws Exception {
		return sqlSession.selectOne(Namespace + ".selectFoodWithFoodNum",foodModel);
	}

	public FoodModel selectFoodWithname(FoodModel foodModel) {
		return sqlSession.selectOne(Namespace + ".selectFoodWithname",foodModel);
	}
	
	public List<FoodModel> selectFoodAdmin(FoodModel foodModel) throws Exception {
		return sqlSession.selectList(Namespace + ".selectFoodAdmin", foodModel);
	}
}

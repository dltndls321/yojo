package com.yogi.jogi.common.dao;

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
}

package com.yogi.jogi.common.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yogi.jogi.common.dao.FestDao;
import com.yogi.jogi.common.dao.FestReviewDao;
import com.yogi.jogi.common.model.FestReviewModel;
import com.yogi.jogi.common.model.FestivalModel;
import com.yogi.jogi.common.service.FestReviewService;
import com.yogi.jogi.common.service.FestService;

@Service
public class FestReviewServiceImpl implements FestReviewService{
	@Autowired
	private FestReviewDao dao;

	@Override
	public int insertFestReview(FestReviewModel festReviewModel ) throws Exception {
		// TODO Auto-generated method stub
		return dao.insertFestReview(festReviewModel);
	}
	
	
}

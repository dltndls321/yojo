package com.yogi.jogi.common.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.yogi.jogi.common.dao.FestReviewDao;
import com.yogi.jogi.common.model.FestReviewModel;
import com.yogi.jogi.common.service.FestReviewService;


@Service
public class FestReviewServiceImpl implements FestReviewService{
	@Autowired
	private FestReviewDao dao;

	@Override
	public int insertFestReview(FestReviewModel festReviewModel ) throws Exception {
		// TODO Auto-generated method stub
		return dao.insertFestReview(festReviewModel);
	}

	@Override
	public int updateFestReview(FestReviewModel festReviewModel) throws Exception {
		// TODO Auto-generated method stub
		return dao.updateFestReview(festReviewModel);
	}

	@Override
	public List<FestReviewModel> selectFestReviewList() throws Exception {
		// TODO Auto-generated method stub
		return dao.selectFestReviewList();
	}

	@Override
	public List<FestReviewModel> selectFestReviewListWithFestNum(FestReviewModel festReviewModel) throws Exception {
		// TODO Auto-generated method stub
		return dao.selectFestReviewListWithFestNum(festReviewModel);
	}

	@Override
	public List<FestReviewModel> selectFestReviewWithMemNum(FestReviewModel festReviewModel) throws Exception {
		// TODO Auto-generated method stub
		return dao.selectFestReviewWithMemNum(festReviewModel);
	}

	@Override
	public FestReviewModel selectFestReviewOne(FestReviewModel festReviewModel) throws Exception {
		// TODO Auto-generated method stub
		return dao.selectFestReviewOne(festReviewModel);
	}
	
	
}

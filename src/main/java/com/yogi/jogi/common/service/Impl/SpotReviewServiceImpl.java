package com.yogi.jogi.common.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yogi.jogi.common.dao.SpotReviewDao;
import com.yogi.jogi.common.model.SpotReviewModel;
import com.yogi.jogi.common.service.SpotReviewService;




@Service
public class SpotReviewServiceImpl implements SpotReviewService{
	@Autowired
	private SpotReviewDao dao;

	@Override
	public int insertSpotReview(SpotReviewModel spotReviewModel) throws Exception {
		// TODO Auto-generated method stub
		return dao.insertSpotReview(spotReviewModel);
	}

	@Override
	public int updateSpotReview(SpotReviewModel spotReviewModel) throws Exception {
		// TODO Auto-generated method stub
		return dao.updateSpotReview(spotReviewModel);
	}

	@Override
	public List<SpotReviewModel> selectSpotReviewList() throws Exception {
		// TODO Auto-generated method stub
		return dao.selectSpotReviewList();
	}

	@Override
	public List<SpotReviewModel> selectSpotReviewListWithSpotNum(SpotReviewModel spotReviewModel) throws Exception {
		// TODO Auto-generated method stub
		return dao.selectSpotReviewListWithSpotNum(spotReviewModel);
	}

	@Override
	public List<SpotReviewModel> selectSpotReviewWithMemNum(SpotReviewModel spotReviewModel) throws Exception {
		// TODO Auto-generated method stub
		return dao.selectSpotReviewWithMemNum(spotReviewModel);
	}

	@Override
	public SpotReviewModel selectSpotReviewOne(SpotReviewModel spotReviewModel) throws Exception {
		// TODO Auto-generated method stub
		return dao.selectSpotReviewOne(spotReviewModel);
	}
	
	
}

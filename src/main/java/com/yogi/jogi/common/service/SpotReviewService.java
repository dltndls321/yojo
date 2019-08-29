package com.yogi.jogi.common.service;

import java.util.List;

import com.yogi.jogi.common.model.SpotReviewModel;


public interface SpotReviewService {
	public int insertSpotReview(SpotReviewModel spotReviewModel) throws Exception;
	public List<SpotReviewModel> selectSpotReviewList() throws Exception;
	public List<SpotReviewModel> selectSpotReviewListWithSpotNum(SpotReviewModel spotReviewModel) throws Exception;
	public List<SpotReviewModel> selectSpotReviewWithMemNum(SpotReviewModel spotReviewModel) throws Exception;
	public SpotReviewModel selectSpotReviewOne(SpotReviewModel spotReviewModel) throws Exception;
	public int updateSpotReview(SpotReviewModel spotReviewModel) throws Exception;
	
	
}

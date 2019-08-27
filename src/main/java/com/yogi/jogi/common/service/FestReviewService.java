package com.yogi.jogi.common.service;

import java.util.List;

import com.yogi.jogi.common.model.FestReviewModel;


public interface FestReviewService {
	public int insertFestReview(FestReviewModel festReviewModel) throws Exception;
	public List<FestReviewModel> selectFestReviewList() throws Exception;
	public FestReviewModel selectFestReviewWithMemNum(FestReviewModel festReviewModel) throws Exception;
	public int updateFestReview(FestReviewModel festReviewModel) throws Exception;
	
	
}

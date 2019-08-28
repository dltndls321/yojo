package com.yogi.jogi.common.service;

import java.util.List;

import com.yogi.jogi.common.model.FestivalModel;
import com.yogi.jogi.member.model.MemberModel;

public interface FestService {
	public int insertFest(FestivalModel festivalModel) throws Exception;
	
	public List<FestivalModel> selectFestList() throws Exception;
	public FestivalModel selectFestWithFestNum(FestivalModel festivalModel) throws Exception;
	public FestivalModel selectFestWithsubject(FestivalModel festivalModel) throws Exception;
	public List<FestivalModel> selectFestListXY(float startX, float startY, float endX, float endY) throws Exception;
	
}

package com.yogi.jogi.common.service;

import java.util.List;

import com.yogi.jogi.common.model.SpotModel;

public interface SpotService {
	public int insertFest(SpotModel spotModel) throws Exception;
	
	public List<SpotModel> selectFestList() throws Exception;
	public SpotModel selectFestWithFestNum(SpotModel spotModel) throws Exception;
	public SpotModel selectFestWithsubject(SpotModel spotModel) throws Exception;
	
}

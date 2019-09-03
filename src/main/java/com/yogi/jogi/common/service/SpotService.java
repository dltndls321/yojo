package com.yogi.jogi.common.service;

import java.util.List;

import com.yogi.jogi.common.model.SpotModel;

public interface SpotService {
	public int insertSpot(SpotModel spotModel) throws Exception;
	
	public List<SpotModel> selectSpotList() throws Exception;
	public SpotModel selectSpotWithSpotNum(SpotModel spotModel) throws Exception;
	public SpotModel selectSpotWithname(SpotModel spotModel) throws Exception;
	public List<SpotModel> selectSpotListXY(float startX, float startY, float endX, float endY) throws Exception;
	public List<SpotModel> selectSpotAdmin(SpotModel spotModel) throws Exception;
	public SpotModel getSpotArea(String name) throws Exception;

}

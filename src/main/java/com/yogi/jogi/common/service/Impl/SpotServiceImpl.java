package com.yogi.jogi.common.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yogi.jogi.common.dao.SpotDao;
import com.yogi.jogi.common.model.FestivalModel;
import com.yogi.jogi.common.model.SpotModel;
import com.yogi.jogi.common.service.SpotService;

@Service
public class SpotServiceImpl implements SpotService{
	@Autowired
	private SpotDao dao;

	@Override
	public int insertSpot(SpotModel spotModel) throws Exception {
		// TODO Auto-generated method stub
		return dao.insertSpot(spotModel);
	}

	@Override
	public List<SpotModel> selectSpotList() throws Exception {
		// TODO Auto-generated method stub
		return dao.selectSpotList();
	}

	@Override
	public SpotModel selectSpotWithSpotNum(SpotModel spotModel) throws Exception {
		// TODO Auto-generated method stub
		return dao.selectSpotWithSpotNum(spotModel);
	}

	@Override
	public SpotModel selectSpotWithname(SpotModel spotModel) throws Exception {
		// TODO Auto-generated method stub
		return  dao.selectSpotWithname(spotModel);
	}
	 
	@Override 
	public List<SpotModel> selectSpotListXY(float startX, float startY, float endX, float endY) throws Exception {

		// TODO Auto-generated method stub
		Map map = new HashMap();
		map.put("startX", startX);
		map.put("startY", startY);
		map.put("endX", endX);
		map.put("endY", endY);
		return dao.selectSpotListXY(map); 
	}

	@Override
	public List<SpotModel> selectSpotAdmin(SpotModel spotModel) throws Exception {
		// TODO Auto-generated method stub
		return dao.selectSpotAdmin(spotModel);
	}
	
	
	
}

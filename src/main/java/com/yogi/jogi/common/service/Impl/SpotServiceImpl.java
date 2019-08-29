package com.yogi.jogi.common.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yogi.jogi.common.dao.SpotDao;
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
	
	
	
	
	
}

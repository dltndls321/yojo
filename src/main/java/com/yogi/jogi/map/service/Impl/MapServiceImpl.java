package com.yogi.jogi.map.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yogi.jogi.map.dao.MapDao;
import com.yogi.jogi.map.model.MapModel;
import com.yogi.jogi.map.service.MapService;
@Service
public class MapServiceImpl implements MapService{
	@Autowired
	private MapDao dao;

	@Override
	public List<MapModel> getFoodList() throws Exception {
		// TODO Auto-generated method stub
		return dao.getFoodList();
	}

	@Override
	public List<MapModel> getFoodList2(float startX, float startY, float endX, float endY) throws Exception {
		// TODO Auto-generated method stub
		return dao.getFoodList2(startX,startY,endX,endY);
	}
	
	
	
}

package com.yogi.jogi.map.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		Map map = new HashMap();
		map.put("startX", startX);
		map.put("startY", startY);
		map.put("endX", endX);
		map.put("endY", endY);
		// TODO Auto-generated method stub
		return dao.getFoodList2(map);
	}
	
	
	
}

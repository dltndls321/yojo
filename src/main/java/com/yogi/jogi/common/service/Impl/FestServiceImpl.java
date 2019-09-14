package com.yogi.jogi.common.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yogi.jogi.common.dao.FestDao;
import com.yogi.jogi.common.model.FestivalModel;
import com.yogi.jogi.common.service.FestService;

@Service
public class FestServiceImpl implements FestService{
	@Autowired
	private FestDao dao;

	@Override
	public int insertFest(FestivalModel festivalModel) throws Exception {
		// TODO Auto-generated method stub
		return dao.insertFest(festivalModel);
	}

	@Override
	public List<FestivalModel> selectFestList() throws Exception {
		// TODO Auto-generated method stub
		return dao.selectFestList();
	}

	@Override
	public FestivalModel selectFestWithFestNum(FestivalModel festivalModel) throws Exception {
		// TODO Auto-generated method stub
		return dao.selectFestWithFestNum(festivalModel);
	}

	@Override
	public FestivalModel selectFestWithsubject(FestivalModel festivalModel) throws Exception {
		// TODO Auto-generated method stub
		return  dao.selectFestWithsubject(festivalModel);
	}

	@Override
	public List<FestivalModel> selectFestListXY(float startX, float startY, float endX, float endY) throws Exception {
		// TODO Auto-generated method stub
		Map map = new HashMap();
		map.put("startX", startX);
		map.put("startY", startY);
		map.put("endX", endX);
		map.put("endY", endY);
		return dao.selectFestListXY(map); 
	}

	@Override
	public List<FestivalModel> selectFestAdmin(FestivalModel festivalModel) throws Exception {
		// TODO Auto-generated method stub
		return dao.selectFestAdmin(festivalModel);
	}

	@Override
	public FestivalModel getFestArea(String name) throws Exception {
		// TODO Auto-generated method stub
		return dao.getFestArea(name);
	}
	
	
	
	
	
}

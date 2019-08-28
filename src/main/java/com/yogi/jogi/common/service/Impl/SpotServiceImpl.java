package com.yogi.jogi.common.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yogi.jogi.common.dao.FestDao;
import com.yogi.jogi.common.dao.SpotDao;
import com.yogi.jogi.common.model.FestivalModel;
import com.yogi.jogi.common.model.SpotModel;
import com.yogi.jogi.common.service.FestService;
import com.yogi.jogi.common.service.SpotService;

@Service
public class SpotServiceImpl implements SpotService{
	@Autowired
	private SpotDao dao;

	@Override
	public int insertFest(SpotModel spotModel) throws Exception {
		// TODO Auto-generated method stub
		return dao.insertFest(spotModel);
	}

	@Override
	public List<SpotModel> selectFestList() throws Exception {
		// TODO Auto-generated method stub
		return dao.selectFestList();
	}

	@Override
	public SpotModel selectFestWithFestNum(SpotModel spotModel) throws Exception {
		// TODO Auto-generated method stub
		return dao.selectFestWithFestNum(spotModel);
	}

	@Override
	public SpotModel selectFestWithsubject(SpotModel spotModel) throws Exception {
		// TODO Auto-generated method stub
		return  dao.selectFestWithsubject(spotModel);
	}
	
	
	
	
	
}

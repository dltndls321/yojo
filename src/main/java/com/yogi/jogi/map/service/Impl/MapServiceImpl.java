package com.yogi.jogi.map.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yogi.jogi.map.dao.MapDao;
import com.yogi.jogi.map.service.MapService;
@Service
public class MapServiceImpl implements MapService{
	@Autowired
	private MapDao dao;
}

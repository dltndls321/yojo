package com.yogi.jogi.map.service;

import java.util.List;

import com.yogi.jogi.map.model.MapModel;

public interface MapService {
	public List<MapModel> getFoodList() throws Exception;
}
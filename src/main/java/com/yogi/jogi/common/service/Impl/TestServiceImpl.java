package com.yogi.jogi.common.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yogi.jogi.common.dao.TestDao;
import com.yogi.jogi.common.model.TestModel;
import com.yogi.jogi.common.service.TestService;
@Service
public class TestServiceImpl implements TestService{
	
	@Autowired
	private TestDao dao;
	@Override
	public int insertTest(TestModel testVO) throws Exception {
		// TODO Auto-generated method stub
		return dao.insertTest(testVO);
	}

	@Override
	public TestModel selectTest(int num) throws Exception {
		// TODO Auto-generated method stub
		return dao.selectTest(num);
	}

	@Override
	public List<TestModel> selectTestAll() throws Exception {
		// TODO Auto-generated method stub
		return dao.selectTestAll();
	}

	@Override
	public int deleteTest(int num) throws Exception {
		// TODO Auto-generated method stub
		return dao.deleteTest(num);
	}

	@Override
	public int updateTest(TestModel testVO) throws Exception {
		// TODO Auto-generated method stub
		return dao.updateTest(testVO);
	}
	
}

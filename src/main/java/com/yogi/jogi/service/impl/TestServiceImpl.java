package com.yogi.jogi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yogi.jogi.dao.TestDao;
import com.yogi.jogi.service.TestService;
import com.yogi.jogi.vo.TestVO;
@Service
public class TestServiceImpl implements TestService{
	
	@Autowired
	private TestDao dao;
	@Override
	public int insertTest(TestVO testVO) throws Exception {
		// TODO Auto-generated method stub
		return dao.insertTest(testVO);
	}

	@Override
	public TestVO selectTest(int num) throws Exception {
		// TODO Auto-generated method stub
		return dao.selectTest(num);
	}

	@Override
	public List<TestVO> selectTestAll() throws Exception {
		// TODO Auto-generated method stub
		return dao.selectTestAll();
	}

	@Override
	public int deleteTest(int num) throws Exception {
		// TODO Auto-generated method stub
		return dao.deleteTest(num);
	}

	@Override
	public int updateTest(TestVO testVO) throws Exception {
		// TODO Auto-generated method stub
		return dao.updateTest(testVO);
	}
	
}

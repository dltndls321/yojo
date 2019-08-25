package com.yogi.jogi.common.service;


import java.util.List;

import com.yogi.jogi.common.model.TestModel;


public interface TestService {
	
	public int insertTest(TestModel testVO) throws Exception;
	public TestModel selectTest(int num) throws Exception;
	public List<TestModel> selectTestAll() throws Exception;
	public int deleteTest(int num) throws Exception;
	public int updateTest(TestModel testVO) throws Exception;
}

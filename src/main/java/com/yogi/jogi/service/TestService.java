package com.yogi.jogi.service;


import java.util.List;

import com.yogi.jogi.vo.TestVO;


public interface TestService {
	
	public int insertTest(TestVO testVO) throws Exception;
	public TestVO selectTest(int num) throws Exception;
	public List<TestVO> selectTestAll() throws Exception;
	public int deleteTest(int num) throws Exception;
	public int updateTest(TestVO testVO) throws Exception;
}

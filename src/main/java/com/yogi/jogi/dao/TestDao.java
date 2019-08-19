package com.yogi.jogi.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yogi.jogi.vo.TestVO;

@Repository
public class TestDao {
	@Autowired
	private SqlSession sqlSession;
	
	
	private static final String Namespace = "testMapperNS";
	
	public int insertTest(TestVO testVO) throws Exception{
		return sqlSession.insert(Namespace + ".insertTest",testVO);
	}
	
	public TestVO selectTest(int num) throws Exception{
		return sqlSession.selectOne(Namespace + ".selectTest",num);
	}
	
	public List<TestVO> selectTestAll() throws Exception{
		return sqlSession.selectList(Namespace + ".selectTestAll");
	}
	
	public int deleteTest(int num) throws Exception {
		return sqlSession.delete(Namespace + ".deleteTest",num);
	}
	
	public int updateTest(TestVO testVO) throws Exception{
		return sqlSession.update(Namespace + ".updateTest",testVO);
	}
}

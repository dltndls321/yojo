package com.yogi.jogi.common.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yogi.jogi.common.model.TestModel;

@Repository
public class TestDao {
	@Autowired
	private SqlSession sqlSession;
	
	
	private static final String Namespace = "testMapperNS";
	
	public int insertTest(TestModel testVO) throws Exception{
		return sqlSession.insert(Namespace + ".insertTest",testVO);
	}
	
	public TestModel selectTest(int num) throws Exception{
		return sqlSession.selectOne(Namespace + ".selectTest",num);
	}
	
	public List<TestModel> selectTestAll() throws Exception{
		return sqlSession.selectList(Namespace + ".selectTestAll");
	}
	
	public int deleteTest(int num) throws Exception {
		return sqlSession.delete(Namespace + ".deleteTest",num);
	}
	
	public int updateTest(TestModel testVO) throws Exception{
		return sqlSession.update(Namespace + ".updateTest",testVO);
	}
}

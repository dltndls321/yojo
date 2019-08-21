package com.yogi.jogi.member.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yogi.jogi.member.model.MemberModel;

@Repository
public class MemberDao {
	@Autowired
	private SqlSession sqlSession;
	
	private static final String Namespace = "memberMapperNS";
	
	public int insertMember(MemberModel memberModel) throws Exception{
		return sqlSession.insert(Namespace+".insertMember",memberModel);
	}
}

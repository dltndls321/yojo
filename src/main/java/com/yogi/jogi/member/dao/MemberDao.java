package com.yogi.jogi.member.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yogi.jogi.member.model.MemberModel;

@Repository
public class MemberDao {
	@Autowired
	private SqlSession sqlSession;
	
	private final String Namespace = "memberMapperNS";
	
	public int insertMember(MemberModel memberModel) throws Exception{
		return sqlSession.insert(Namespace+".insertMember",memberModel);
	}
	
	public List<MemberModel> selectMemberList() throws Exception {
		return sqlSession.selectList(Namespace + ".selectMemberList");
	}
	
	public MemberModel selectMemberWithId(MemberModel memberModel) throws Exception {
		return sqlSession.selectOne(Namespace + ".selectMemberWithId",memberModel);
	}
	
	public MemberModel selectMemberWithEmail(MemberModel memberModel) throws Exception {
		return sqlSession.selectOne(Namespace + ".selectMemberWithEmail",memberModel);
	}
	
	public MemberModel selectMemberWithMemNum(MemberModel memberModel) throws Exception {
		return sqlSession.selectOne(Namespace + ".selectMemberWithMemNum",memberModel);
	}
	
	public int updateMember(MemberModel memberModel) throws Exception {
		return sqlSession.update(Namespace+".updateMember",memberModel);
	}
	
	public int deleteMember(MemberModel memberModel) throws Exception {
		return sqlSession.delete(Namespace+".deleteMember",memberModel);
	}
	
	public List<MemberModel> selectMemberListPaging(Map map) throws Exception {
		return sqlSession.selectList(Namespace+".selectMemberListPaging",map);
	}
}

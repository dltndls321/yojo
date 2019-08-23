package com.yogi.jogi.member.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yogi.jogi.member.dao.MemberDao;
import com.yogi.jogi.member.model.MemberModel;
import com.yogi.jogi.member.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberDao dao;

	@Override
	public int insertMember(MemberModel memberModel) throws Exception {
		// TODO Auto-generated method stub
		return dao.insertMember(memberModel);
	}

	@Override
	public List<MemberModel> selectMemberList() throws Exception {
		// TODO Auto-generated method stub
		return dao.selectMemberList();
	}

	@Override
	public MemberModel selectMemberWithId(MemberModel memberModel) throws Exception {
		// TODO Auto-generated method stub
		return dao.selectMemberWithId(memberModel);
	}

	@Override
	public MemberModel selectMemberWithEmail(MemberModel memberModel) throws Exception {
		// TODO Auto-generated method stub
		return dao.selectMemberWithEmail(memberModel);
	}
	
	
}

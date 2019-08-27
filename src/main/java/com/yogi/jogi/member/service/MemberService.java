package com.yogi.jogi.member.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yogi.jogi.member.model.MemberModel;

@Service
public interface MemberService {

	public int insertMember(MemberModel memberModel) throws Exception;

	public List<MemberModel> selectMemberList() throws Exception;

	public MemberModel selectMemberWithId(MemberModel memberModel) throws Exception;

	public MemberModel selectMemberWithEmail(MemberModel memberModel) throws Exception;

	public MemberModel selectMemberWithMemNum(MemberModel memberModel) throws Exception;

}

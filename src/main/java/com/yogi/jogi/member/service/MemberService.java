package com.yogi.jogi.member.service;

import java.util.Date;
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
	
	public int updateMember(MemberModel memberModel)throws Exception;
	
	public int deleteMember(MemberModel memberModel)throws Exception;
	
	public List<MemberModel> selectMemberListPaging(int start,int end) throws Exception;
	
	public List<MemberModel> selectMemberbetweenDate(Date start,Date end) throws Exception;
	
	public int updateMemberTokken(MemberModel memberModel)throws Exception;
	
	public int updateMemberStatus(MemberModel memberModel)throws Exception;
	
	
}

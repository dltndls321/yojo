package com.yogi.jogi.board.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yogi.jogi.board.dao.ReplyDao;
import com.yogi.jogi.board.model.ReplyModel;
import com.yogi.jogi.board.service.ReplyService;

@Service
public class BoardReplyServicelmpl implements ReplyService {

	@Autowired
	private ReplyDao replyDao;

	@Override
	public int replyCount() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ReplyModel> replyList() throws Exception {
		// TODO Auto-generated method stub
		return replyDao.replyList();
	}

	@Override
	public int replyInsert(ReplyModel replyModel) throws Exception {
		// TODO Auto-generated method stub
		return replyDao.replyInsert(replyModel);
	}

	@Override
	public int replyUpdate(ReplyModel replyModel) throws Exception {
		// TODO Auto-generated method stub
		return replyDao.replyUpdate(replyModel);
	}

	@Override
	public int replyDelete(int replynum) throws Exception {
		// TODO Auto-generated method stub
		return replyDao.replyDelete(replynum);
	}

	
	
}

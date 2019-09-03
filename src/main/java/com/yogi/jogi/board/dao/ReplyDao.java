package com.yogi.jogi.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yogi.jogi.board.model.ReplyModel;

@Repository
public class ReplyDao {

	private SqlSession sqlSession;

	@Autowired
	public ReplyDao(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	private static final String Namespace = "boardReplyMapperNS";

	public List<ReplyModel> replyList() throws Exception {
		return sqlSession.selectList(Namespace + ".replyList");
	}
	public int replyInsert(ReplyModel replyModel) throws Exception {
		return sqlSession.insert(Namespace + ".replyInsert",replyModel);
	}
	public int replyUpdate(ReplyModel replyModel) throws Exception {
		System.out.println(replyModel);
		return sqlSession.update(Namespace + ".replyUpdate",replyModel);
	}
	public int replyDelete(int replynum) throws Exception{
		return sqlSession.delete(Namespace + ".replyDelete",replynum);
	}
}


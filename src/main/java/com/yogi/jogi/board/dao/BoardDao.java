package com.yogi.jogi.board.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yogi.jogi.board.model.BoardModel;



@Repository
public class BoardDao {
	@Autowired
	private SqlSession sqlSession;
	
	private static final String Namespace = "boardMapperNS";
	
	public BoardModel selectPasswdOneNum(BoardModel boardModel) throws Exception {
		try {
			return sqlSession.selectOne(Namespace+".selectPasswdOneNum",boardModel);
		}
		finally {
			sqlSession.close();
		}
	}
	public BoardModel selectArticleCount(BoardModel boardModel) throws Exception {
		return sqlSession.selectOne(Namespace+"selectArticleCount",boardModel);
		
	}
	public List<BoardModel> selectBoardList(BoardModel boardModel) throws Exception {
		return sqlSession.selectList(Namespace+".selectBoardList",boardModel);
	}
	
}
	
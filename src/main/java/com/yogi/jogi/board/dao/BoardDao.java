package com.yogi.jogi.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yogi.jogi.board.model.BoardModel;

@Repository
public class BoardDao {
	
	private SqlSession sqlSession;
	
	@Autowired
	public BoardDao(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	private static final String Namespace = "boardMapperNS";

	public List<BoardModel> selectBoardList(BoardModel boardModel) throws Exception {
		System.out.println("before quering" + boardModel.toString());
		String boardid = boardModel.getBoardid();
		List<BoardModel> returnValue = sqlSession.selectList(Namespace + ".selectBoardList",boardModel);

		System.out.println(returnValue.toString());
		return returnValue;

	}

	public BoardModel selectBoard(BoardModel boardModel) throws Exception {
		return sqlSession.selectOne(Namespace+".selectBoard",boardModel);
	}
//
//	public BoardModel selectMaxBoardNum(BoardModel boardModel) throws Exception {
//		return sqlSession.selectOne(Namespace + ".selectMaxBoardNum", boardModel);
//	}
//
//	public int updateReStep(BoardModel boardModel) throws Exception {
//		return sqlSession.selectOne(Namespace + ".updateReStep", boardModel);
//
//	}
//
	public int insertBoard(BoardModel boardModel, String boardid) throws Exception {

		return sqlSession.selectOne(Namespace + ".insertBoard",boardModel);
	}
//
//	public BoardModel selectPasswdOneNum(BoardModel boardModel) throws Exception {
//		try {
//			return sqlSession.selectOne(Namespace + ".selectPasswdOneNum", boardModel);
//		} finally {
//			sqlSession.close();
//		}
//	}
//
//	public int updateReadCount(BoardModel boardModel) throws Exception {
//		
//		
//		return sqlSession.selectOne(Namespace + ".updateReadCount", boardModel);
//
//	}
//	public int updateBoard(BoardModel boardModel) throws Exception {
//		return sqlSession.selectOne(Namespace + ".updateBoard", boardModel);
//
//	}
//	public int deleteBoard(BoardModel boardModel) throws Exception {
//		return sqlSession.selectOne(Namespace + ".deleteBoard", boardModel);
//
//	}
}

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
		String boardid = boardModel.getBoardid();
		return sqlSession.selectList(Namespace + ".selectBoardList", boardModel);

	}

	public BoardModel selectBoard(BoardModel boardModel) throws Exception {
		return sqlSession.selectOne(Namespace + ".selectBoard", boardModel);
	}

	public int insertBoard(BoardModel boardModel) throws Exception {
        System.out.println();
		return sqlSession.selectOne(Namespace + ".insertBoard", boardModel);
	}
	public BoardModel updateBoard(BoardModel boardModel) throws Exception {
		return sqlSession.selectOne(Namespace + ".updateBoard", boardModel);

	}
	public int deleteBoard(BoardModel boardModel) throws Exception {
		return sqlSession.selectOne(Namespace + ".deleteBoard", boardModel);

	}
	public int selectPasswdOneNum(BoardModel boardModel) throws Exception {
		try {
			return sqlSession.selectOne(Namespace + ".selectPasswdOneNum", boardModel);
		} finally {
			sqlSession.close();
		}
	}


}

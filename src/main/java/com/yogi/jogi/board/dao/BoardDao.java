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

	public List<BoardModel> selectBoardList(BoardModel boardModel) throws Exception {
		return sqlSession.selectList(Namespace + ".selectBoardList", boardModel);
	}

	public BoardModel selectBoard(BoardModel boardModel) throws Exception {
		
		HashMap map = new HashMap();
		map.put("boardNum", boardModel.getBoardNum());
		map.put("boardid", boardModel.getBoardid());
		BoardModel article = new BoardModel();
		try {
			int result = sqlSession.update(Namespace + ".update_readcount", boardModel);
			article = (BoardModel) sqlSession.selectOne(Namespace + ".selectBoard ", boardModel);
		} finally {
			sqlSession.commit();
			sqlSession.close();
			return article;
		}
	}

	public BoardModel selectMaxBoardNum(BoardModel boardModel) throws Exception {
		return sqlSession.selectOne(Namespace + ".selectMaxBoardNum", boardModel);
	}

	public int updateReStep(BoardModel boardModel) throws Exception {
		return sqlSession.selectOne(Namespace + ".updateReStep", boardModel);

	}

	public int insertBoard(BoardModel boardModel, String boardid) throws Exception {
		int num = boardModel.getBoardNum();
		int ref = boardModel.getRef();
		int reStep = boardModel.getReStep();
		int reLevel = boardModel.getReLevel();
		try {
			HashMap map = new HashMap();
			int number = sqlSession.selectOne(Namespace + ".selectMaxBoardNum");
			if (number != 0)
				number = number + 1;
			else
				number = 1;
			if (num != 0) {
				map.put("ref", ref);
				map.put("reStep", reStep);
				sqlSession.update(Namespace + ".updateReStep", map);
				reStep = reStep + 1;
				reLevel = reLevel + 1;
			} else {
				ref = number;
				reStep = 0;
				reLevel = 0;
			}
			boardModel.setBoardNum(number);
			boardModel.setRef(ref);
			boardModel.setReStep(reStep);
			boardModel.setReLevel(reLevel);
			boardModel.setBoardid(boardid);
			int result = sqlSession.insert(Namespace + ".insertBoard", boardModel);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.commit();
			sqlSession.close();
		}
		return sqlSession.selectOne(Namespace + ".insertBoard",boardModel);
	}

	public BoardModel selectPasswdOneNum(BoardModel boardModel) throws Exception {
		try {
			return sqlSession.selectOne(Namespace + ".selectPasswdOneNum", boardModel);
		} finally {
			sqlSession.close();
		}
	}

	public int updateReadCount(BoardModel boardModel) throws Exception {
		
		
		return sqlSession.selectOne(Namespace + ".updateReadCount", boardModel);

	}
	public int updateBoard(BoardModel boardModel) throws Exception {
		return sqlSession.selectOne(Namespace + ".updateBoard", boardModel);

	}
	public int deleteBoard(BoardModel boardModel) throws Exception {
		return sqlSession.selectOne(Namespace + ".deleteBoard", boardModel);

	}
}

package com.yogi.jogi.board.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yogi.jogi.board.dao.BoardDao;
import com.yogi.jogi.board.model.BoardModel;
import com.yogi.jogi.board.service.BoardService;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDao dao;

	@Override
	public List<BoardModel> selectBoardList(BoardModel boardModel) throws Exception {
		// TODO Auto-generated method stub
		return dao.selectBoardList(boardModel);
	}

	@Override
	public BoardModel selectBoard(BoardModel boardModel) throws Exception {
		// TODO Auto-generated method stub
		return dao.selectBoard(boardModel);
	}

//	@Override
//	public BoardModel selectMaxBoardNum(BoardModel boardModel) throws Exception {
//		// TODO Auto-generated method stub
//		return dao.selectMaxBoardNum(boardModel);
//	}
//	
//	@Override
//	public int updateReStep(BoardModel boardModel) throws Exception {
//		// TODO Auto-generated method stub
//		return dao.updateReStep(boardModel);
//	}
	@Override
	public int insertBoard(BoardModel boardModel, String boardid) throws Exception {
		// TODO Auto-generated method stub
		return dao.insertBoard(boardModel, boardid);
	}
//	@Override
//	public BoardModel selectPasswdOneNum(BoardModel boardModel) throws Exception {
//		// TODO Auto-generated method stub
//		return dao.selectPasswdOneNum(boardModel);
//	}
//
//	@Override
//	public int updateReadCount(BoardModel boardModel) throws Exception {
//		// TODO Auto-generated method stub
//		return dao.updateReadCount(boardModel);
//	}
//
//	@Override
//	public int updateBoard(BoardModel boardModel) throws Exception {
//		// TODO Auto-generated method stub
//		return dao.updateBoard(boardModel);
//	}
//
//	@Override
//	public int deleteBoard(BoardModel boardModel) throws Exception {
//		// TODO Auto-generated method stub
//		return dao.deleteBoard(boardModel);
//	}
//	
//	
}

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
	public BoardModel selectBoard(int boardNum) throws Exception {
		// TODO Auto-generated method stub
		return dao.selectBoard(boardNum);
	}
	
	@Override
	public int updateBoard(BoardModel boardModel) throws Exception {
		// TODO Auto-generated method stub
		return dao.updateBoard(boardModel);
	}

	@Override
	public int deleteBoard(BoardModel boardModel) throws Exception {
		// TODO Auto-generated method stub
		return dao.deleteBoard(boardModel);
	}

	@Override
	public BoardModel selectPasswdOneNum(BoardModel boardModel) throws Exception {
		// TODO Auto-generated method stub
		return dao.selectPasswdOneNum(boardModel);
	}

	@Override
	public int insertBoard(BoardModel boardModel) throws Exception {
		// TODO Auto-generated method stub
		return dao.insertBoard(boardModel);
	}

}

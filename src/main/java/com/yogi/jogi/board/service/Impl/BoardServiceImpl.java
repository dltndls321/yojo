package com.yogi.jogi.board.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yogi.jogi.board.dao.BoardDao;
import com.yogi.jogi.board.model.BoardModel;
import com.yogi.jogi.board.model.NoticeModel;
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
	@Override
<<<<<<< HEAD
	public void insertBoard(BoardModel boardModel) throws Exception {
		// TODO Auto-generated method stub
		
=======
	public int insertBoard(BoardModel boardModel) throws Exception {
		// TODO Auto-generated method stub
		return dao.insertBoard(boardModel);
>>>>>>> 58807e42f796fa06f0a504f84566e3a8c8561a74
	}
	@Override
	public BoardModel updateBoard(BoardModel boardModel) throws Exception {
		// TODO Auto-generated method stub
		return dao.updateBoard(boardModel);
	}

	@Override
	public int deleteBoard(BoardModel boardModel) throws Exception {
		// TODO Auto-generated method stub
		return dao.deleteBoard(boardModel);
	}

	@Override
	public int selectPasswdOneNum(BoardModel boardModel) throws Exception {
		// TODO Auto-generated method stub
		return dao.selectPasswdOneNum(boardModel);
	}

<<<<<<< HEAD
	

=======
>>>>>>> 58807e42f796fa06f0a504f84566e3a8c8561a74
}

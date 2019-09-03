package com.yogi.jogi.board.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yogi.jogi.board.dao.BoardDao;
import com.yogi.jogi.board.model.BoardModel;
import com.yogi.jogi.board.model.ReplyModel;
import com.yogi.jogi.board.service.BoardService;
import com.yogi.jogi.member.model.MemberModel;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDao dao;

	@Override
	public List<BoardModel> selectBoardList() throws Exception {
		// TODO Auto-generated method stub
		return dao.selectBoardList();
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
	@Override
	public List<BoardModel> selectBoardListPaging(int start, int end,String boardid) throws Exception {
		Map map = new HashMap();
		map.put("start", start);
		map.put("end", end);
		map.put("boardid",boardid);
		return dao.selectBoardListPaging(map);
	}

	@Override
	public List<BoardModel> selectBoardListWidhBoardid(String boardid) throws Exception {
		// TODO Auto-generated method stub
		return dao.selectBoardListWidhBoardid(boardid);
	}

	

	

	
}

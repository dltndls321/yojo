package com.yogi.jogi.board.service;


import java.util.List;

import com.yogi.jogi.board.model.BoardModel;

public interface BoardService {

	public List<BoardModel> selectBoardList(BoardModel boardModel) throws Exception;
	public BoardModel selectBoard(int boardNum)throws Exception;
	public int insertBoard(BoardModel boardModel) throws Exception;
	public int updateBoard(BoardModel boardModel)throws Exception;
	public int deleteBoard(BoardModel boardModel)throws Exception;
	public int selectPasswdOneNum(BoardModel boardModel)throws Exception;

	
}

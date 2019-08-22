package com.yogi.jogi.board.service;


import java.util.List;

import com.yogi.jogi.board.model.BoardModel;

public interface BoardService {

	public List selectBoardList(BoardModel boardModel) throws Exception;
//	public BoardModel selectBoard(BoardModel boardModel)throws Exception;
//	public BoardModel selectMaxBoardNum(BoardModel boardModel)throws Exception;
//	public int updateReStep(BoardModel boardModel)throws Exception;
//	public int insertBoard (BoardModel boardModel,String boardid)throws Exception;
//	public BoardModel selectPasswdOneNum(BoardModel boardModel)throws Exception;
//	public int updateReadCount(BoardModel boardModel)throws Exception;
//	public int updateBoard(BoardModel boardModel)throws Exception;
//	public int deleteBoard(BoardModel boardModel)throws Exception;
}

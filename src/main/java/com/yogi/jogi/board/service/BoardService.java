package com.yogi.jogi.board.service;


import java.util.List;

import com.yogi.jogi.board.model.BoardModel;

public interface BoardService {

	public BoardModel selectPasswdOneNum(BoardModel boardModel)throws Exception;
	public BoardModel selectArticleCount(BoardModel boardModel)throws Exception;
	public List<BoardModel> selectBoardList(BoardModel boardModel) throws Exception;

}

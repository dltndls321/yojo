package com.yogi.jogi.board.service;


import java.util.List;

import com.yogi.jogi.board.model.BoardModel;
import com.yogi.jogi.member.model.MemberModel;

public interface BoardService {

	public List<BoardModel> selectBoardList() throws Exception;
	public BoardModel selectBoard(int boardNum)throws Exception;
	public int insertBoard(BoardModel boardModel) throws Exception;
	public int updateBoard(BoardModel boardModel)throws Exception;
	public int deleteBoard(BoardModel boardModel)throws Exception;
	public BoardModel selectPasswdOneNum(BoardModel boardModel)throws Exception;
	public List<BoardModel> selectBoardListPaging(int start,int end) throws Exception;
	
}

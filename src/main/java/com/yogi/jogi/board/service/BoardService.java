package com.yogi.jogi.board.service;


import java.util.List;
import java.util.Map;

import com.yogi.jogi.board.model.BoardModel;
import com.yogi.jogi.board.model.ReplyModel;
import com.yogi.jogi.member.model.MemberModel;

public interface BoardService {

	public List<BoardModel> selectBoardList() throws Exception;
	public BoardModel selectBoard(int boardNum)throws Exception;
	public int insertBoard(BoardModel boardModel) throws Exception;
	public int updateBoard(BoardModel boardModel)throws Exception;
	public int deleteBoard(BoardModel boardModel)throws Exception;
	public BoardModel selectPasswdOneNum(BoardModel boardModel)throws Exception;
	public List<BoardModel> selectBoardListPaging(int start,int end,String boardid) throws Exception;
	public List<BoardModel> selectBoardListWidhMemnum(BoardModel boardModel) throws Exception;
	
	public List<BoardModel> selectBoardListWidhBoardid(String boardid) throws Exception;

	/*
	 * public List<BoardModel> selectSearchBoardList(String searchOption,String
	 * keyword) throws Exception;
	 */	
	public List<BoardModel> selectSearchBoardList(int start,int end,String boardid,String searchOption,String keyword) throws Exception;
	public int selectListGetCount(String searchOption,String keyword,String boardid) throws Exception; 
	
}

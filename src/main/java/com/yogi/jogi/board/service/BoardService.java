package com.yogi.jogi.board.service;


import java.util.List;

import com.yogi.jogi.board.model.BoardModel;
import com.yogi.jogi.board.model.NoticeModel;

public interface BoardService {

	public List<BoardModel> selectBoardList(BoardModel boardModel) throws Exception;
	public BoardModel selectBoard(BoardModel boardModel)throws Exception;
<<<<<<< HEAD
	public void insertBoard (BoardModel boardModel)throws Exception;
=======
	public int insertBoard (BoardModel boardModel)throws Exception;
>>>>>>> 58807e42f796fa06f0a504f84566e3a8c8561a74
	public BoardModel updateBoard(BoardModel boardModel)throws Exception;
	public int deleteBoard(BoardModel boardModel)throws Exception;
	public int selectPasswdOneNum(BoardModel boardModel)throws Exception;

<<<<<<< HEAD
	
=======
>>>>>>> 58807e42f796fa06f0a504f84566e3a8c8561a74
}

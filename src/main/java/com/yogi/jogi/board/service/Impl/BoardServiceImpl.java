package com.yogi.jogi.board.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yogi.jogi.board.dao.BoardDao;
import com.yogi.jogi.board.service.BoardService;

@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	private BoardDao dao;
}

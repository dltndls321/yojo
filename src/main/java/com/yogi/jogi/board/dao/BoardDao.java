package com.yogi.jogi.board.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

package service;


import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.BoardDataBean;
import mybatis.MybatisConnector;

@Service
public class BoardDao {
	private final String namespace = "mybatis.board";

	@Autowired
	public MybatisConnector mybatisConnector;
	
	
	public int getArticleCount(String boardid) throws Exception {
		SqlSession sqlSession = mybatisConnector.sqlSession();
		System.out.println("getArticleCount===old");
		try {
			return sqlSession.selectOne(namespace + ".getArticleCount", boardid);
		} finally {
			sqlSession.close();
		}
	}

	public List getArticles(int start, int end, String boardid) throws Exception {
		SqlSession sqlSession = mybatisConnector.sqlSession();
		System.out.println("getArticles===old");
		
		
		if(mybatisConnector.getDbname().equals("Oracle")) {
			
		}
		HashMap map = new HashMap();
		map.put("start", start);
		map.put("end", end);
		map.put("boardid", boardid);
		try {
			return sqlSession.selectList(namespace + ".getArticles", map);
		} finally {
			sqlSession.close();
		}
	}

	public void insertArticle(BoardDataBean article, String boardid) throws Exception {
		SqlSession sqlSession = mybatisConnector.sqlSession();
		int num = article.getNum();
		int ref = article.getRef();
		int re_step = article.getRe_step();
		int re_level = article.getRe_level();
		try {
			HashMap map = new HashMap();
			int number = sqlSession.selectOne(namespace + ".insertArticle_new");
			if (number != 0)
				number = number + 1;
			else
				number = 1;
			if (num != 0) {
				map.put("ref", ref);
				map.put("re_step", re_step);
				sqlSession.update(namespace + ".insertArticle_update", map);
				re_step = re_step + 1;
				re_level = re_level + 1;
			} else {
				ref = number;
				re_step = 0;
				re_level = 0;
			}
			article.setNum(number);
			article.setRef(ref);
			article.setRe_step(re_step);
			article.setRe_level(re_level);
			article.setBoardid(boardid);
			System.out.println("insert:" + article);
			int result = sqlSession.insert(namespace + ".insertArticle_insert", article);
			System.out.println("insert  0k:" + result);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.commit();
			sqlSession.close();
		}
	}

	public BoardDataBean getArticle(int num, String boardid) throws Exception {
		SqlSession sqlSession = mybatisConnector.sqlSession();
		HashMap map = new HashMap();
		map.put("num", num);
		map.put("boardid", boardid);
		BoardDataBean article = new BoardDataBean();
		try {
			int result = sqlSession.update(namespace + ".update_readcount", map);
			article = (BoardDataBean) sqlSession.selectOne(namespace + ".getArticle", map);
		} finally {
			sqlSession.commit();
			sqlSession.close();
			return article;
		}

	}

	public BoardDataBean getUpdate(int num, String boardid) throws Exception {
		SqlSession sqlSession = mybatisConnector.sqlSession();
		HashMap map = new HashMap();
		map.put("num", num);
		map.put("boardid", boardid);
		BoardDataBean article = new BoardDataBean();
		try {
			article = (BoardDataBean) sqlSession.selectOne(namespace + ".getArticle", map);
			System.out.println(":::" + article);
		} finally {
			sqlSession.close();
			return article;
		}
	}

	public int updateArticle(BoardDataBean article, String boardid) throws Exception {
		SqlSession sqlSession = mybatisConnector.sqlSession();
		HashMap map = new HashMap();
		map.put("num", article.getNum());
		int x = -1;
		try {
			String dbpasswd = (String) sqlSession.selectOne(namespace + ".update_passwd", map);
			if (dbpasswd.equals(article.getPasswd())) {
				x = sqlSession.update(namespace + ".update_update", article);
			}
		} finally {
			sqlSession.commit();
			sqlSession.close();
		}
		return x;
	}

	public int deleteArticle(int num, String passwd) throws Exception {
		SqlSession sqlSession = mybatisConnector.sqlSession();
		HashMap map = new HashMap();
		map.put("num", num);
		int x = -1;
		try {
			String dbpasswd = (String) sqlSession.selectOne(namespace + ".update_passwd", map);
			if (dbpasswd.equals(passwd)) {
				x = sqlSession.delete(namespace + ".delete", map);
			}
		} finally {
			sqlSession.commit();
			sqlSession.close();
		}
		return x;
	}

}

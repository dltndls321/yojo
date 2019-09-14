package com.yogi.jogi.board.model;

import java.util.Date;

public class BoardModel {
	private int boardNum;
	private int memNum;
	private String boardid;
	private String subject;
	private String writer;
	private String passwd;
	private String content;
	private String fname;
	private int fsize;
	private int readcount;
	private Date regdate;
	private int ref;
	private int reStep;
	private int reLevel;
	private int replycount;
	private int prevboardNum;
	private int nextboardNum;
	private String nextsubject;
	private String prevsubject;

	public int getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}

	public int getMemNum() {
		return memNum;
	}

	public void setMemNum(int memNum) {
		this.memNum = memNum;
	}

	public String getBoardid() {
		return boardid;
	}

	public void setBoardid(String boardid) {
		this.boardid = boardid;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public int getFsize() {
		return fsize;
	}

	public void setFsize(int fsize) {
		this.fsize = fsize;
	}

	public int getReadcount() {
		return readcount;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getRef() {
		return ref;
	}

	public void setRef(int ref) {
		this.ref = ref;
	}

	public int getReStep() {
		return reStep;
	}

	public void setReStep(int reStep) {
		this.reStep = reStep;
	}

	public int getReLevel() {
		return reLevel;
	}

	public void setReLevel(int reLevel) {
		this.reLevel = reLevel;
	}

	public int getReplycount() {
		return replycount;
	}

	public void setReplycount(int replycount) {
		this.replycount = replycount;
	}

	public int getPrevboardNum() {
		return prevboardNum;
	}

	public void setPrevboardNum(int prevboardNum) {
		this.prevboardNum = prevboardNum;
	}

	public int getNextboardNum() {
		return nextboardNum;
	}

	public void setNextboardNum(int nextboardNum) {
		this.nextboardNum = nextboardNum;
	}

	public String getNextsubject() {
		return nextsubject;
	}

	public void setNextsubject(String nextsubject) {
		this.nextsubject = nextsubject;
	}

	public String getPrevsubject() {
		return prevsubject;
	}

	public void setPrevsubject(String prevsubject) {
		this.prevsubject = prevsubject;
	}

	@Override
	public String toString() {
		return "BoardModel [boardNum=" + boardNum + ", memNum=" + memNum + ", boardid=" + boardid + ", subject="
				+ subject + ", writer=" + writer + ", passwd=" + passwd + ", content=" + content + ", fname=" + fname
				+ ", fsize=" + fsize + ", readcount=" + readcount + ", regdate=" + regdate + ", ref=" + ref
				+ ", reStep=" + reStep + ", reLevel=" + reLevel + ", replycount=" + replycount + ", prevboardNum="
				+ prevboardNum + ", nextboardNum=" + nextboardNum + ", nextsubject=" + nextsubject + ", prevsubject="
				+ prevsubject + "]";
	}

}

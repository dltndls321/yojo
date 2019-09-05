package com.yogi.jogi.board.model;

import java.util.Date;

public class ReplyModel {
private int replyNum;
private int memNum;
private int boardNum;
private String content;
private Date regdate;
public int getReplyNum() {
	return replyNum;
}
public void setReplyNum(int replyNum) {
	this.replyNum = replyNum;
}
public int getMemNum() {
	return memNum;
}
public void setMemNum(int memNum) {
	this.memNum = memNum;
}
public int getBoardNum() {
	return boardNum;
}
public void setBoardNum(int boardNum) {
	this.boardNum = boardNum;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public Date getRegdate() {
	return regdate;
}
public void setRegdate(Date regdate) {
	this.regdate = regdate;
}
@Override
public String toString() {
	return "ReplyModel [replyNum=" + replyNum + ", memNum=" + memNum + ", boardNum=" + boardNum + ", content=" + content
			+ ", regdate=" + regdate + "]";
}



}

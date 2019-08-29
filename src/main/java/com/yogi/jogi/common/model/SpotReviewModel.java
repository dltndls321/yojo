package com.yogi.jogi.common.model;

import java.util.Date;

public class SpotReviewModel {
	private int srNum;
	private int spotNum;
	private int memNum;
	private int star;
	private String sReview;
	private Date regDate;
	public int getSrNum() {
		return srNum;
	}
	public void setSrNum(int srNum) {
		this.srNum = srNum;
	}
	public int getSpotNum() {
		return spotNum;
	}
	public void setSpotNum(int spotNum) {
		this.spotNum = spotNum;
	}
	public int getMemNum() {
		return memNum;
	}
	public void setMemNum(int memNum) {
		this.memNum = memNum;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	public String getsReview() {
		return sReview;
	}
	public void setsReview(String sReview) {
		this.sReview = sReview;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	@Override
	public String toString() {
		return "SpotReviewModel [srNum=" + srNum + ", spotNum=" + spotNum + ", memNum=" + memNum + ", star=" + star
				+ ", sReview=" + sReview + ", regDate=" + regDate + "]";
	}
	
	
	
	
	
	

}

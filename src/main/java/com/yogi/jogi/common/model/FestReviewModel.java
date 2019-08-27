package com.yogi.jogi.common.model;

import java.util.Date;

public class FestReviewModel {
	private int frNum;
	private int festNum;
	private int memNum;
	private int star;
	private String fReview;
	private Date regDate;
	
	public int getFrNum() {
		return frNum;
	}
	public void setFrNum(int frNum) {
		this.frNum = frNum;
	}
	public int getFestNum() {
		return festNum;
	}
	public void setFestNum(int festNum) {
		this.festNum = festNum;
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
	public String getfReview() {
		return fReview;
	}
	public void setfReview(String fReview) {
		this.fReview = fReview;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	@Override
	public String toString() {
		return "FestReviewModel [frNum=" + frNum + ", festNum=" + festNum + ", memNum=" + memNum + ", star=" + star
				+ ", fReview=" + fReview + ", regDate=" + regDate + "]";
	}
	
	
	
	
	

}

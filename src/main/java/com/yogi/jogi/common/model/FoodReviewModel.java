package com.yogi.jogi.common.model;

import java.util.Date;

public class FoodReviewModel {
	private int fdrNum;
	private int foodNum;
	private int memNum;
	private int star;
	private String fdReview;
	private Date regDate;
	public int getFdrNum() {
		return fdrNum;
	}
	public void setFdrNum(int fdrNum) {
		this.fdrNum = fdrNum;
	}
	public int getFoodNum() {
		return foodNum;
	}
	public void setFoodNum(int foodNum) {
		this.foodNum = foodNum;
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
	public String getFdReview() {
		return fdReview;
	}
	public void setFdReview(String fdReview) {
		this.fdReview = fdReview;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	@Override
	public String toString() {
		return "FoodReviewModel [fdrNum=" + fdrNum + ", foodNum=" + foodNum + ", memNum=" + memNum + ", star=" + star
				+ ", fdReview=" + fdReview + ", regDate=" + regDate + "]";
	}
	
	
	
	
	
	
	

}

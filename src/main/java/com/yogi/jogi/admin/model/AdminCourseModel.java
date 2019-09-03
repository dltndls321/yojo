package com.yogi.jogi.admin.model;

import java.util.Date;

public class AdminCourseModel {
	private int courseNum;
	private String subject;
	private String theme;
	private Date startDate;
	private Date endDate;
	private int areaCode;
	private String foodCode;
	private String spotCode;
	private String course1;
	private String course2;
	private String course3;
	private String course4;
	private String course5;
	private String course6;
	public int getCourseNum() {
		return courseNum;
	}
	public void setCourseNum(int courseNum) {
		this.courseNum = courseNum;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public int getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(int areaCode) {
		this.areaCode = areaCode;
	}
	public String getFoodCode() {
		return foodCode;
	}
	public void setFoodCode(String foodCode) {
		this.foodCode = foodCode;
	}
	public String getSpotCode() {
		return spotCode;
	}
	public void setSpotCode(String spotCode) {
		this.spotCode = spotCode;
	}
	public String getCourse1() {
		return course1;
	}
	public void setCourse1(String course1) {
		this.course1 = course1;
	}
	public String getCourse2() {
		return course2;
	}
	public void setCourse2(String course2) {
		this.course2 = course2;
	}
	public String getCourse3() {
		return course3;
	}
	public void setCourse3(String course3) {
		this.course3 = course3;
	}
	public String getCourse4() {
		return course4;
	}
	public void setCourse4(String course4) {
		this.course4 = course4;
	}
	public String getCourse5() {
		return course5;
	}
	public void setCourse5(String course5) {
		this.course5 = course5;
	}
	public String getCourse6() {
		return course6;
	}
	public void setCourse6(String course6) {
		this.course6 = course6;
	}
	
	@Override
	public String toString() {
		return "AdminCourseModel [courseNum=" + courseNum + ", subject=" + subject + ", theme=" + theme + ", startDate="
				+ startDate + ", endDate=" + endDate + ", areaCode=" + areaCode + ", foodCode=" + foodCode
				+ ", spotCode=" + spotCode + ", course1=" + course1 + ", course2=" + course2 + ", course3=" + course3
				+ ", course4=" + course4 + ", course5=" + course5 + ", course6=" + course6 + "]";
	}
	
	

}

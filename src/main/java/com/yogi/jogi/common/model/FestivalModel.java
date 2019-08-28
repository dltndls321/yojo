package com.yogi.jogi.common.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class FestivalModel {
	private int festNum;
	private String subject;
	@DateTimeFormat(pattern = "yyyyMMdd")
	private Date fdate1;
	private String area;
	@DateTimeFormat(pattern = "yyyyMMdd")
	private Date fdate2;
	private float fmapx;
	private float fmapy;
	private int zcode;
	
	public int getFestNum() {
		return festNum;
	}
	public void setFestNum(int festNum) {
		this.festNum = festNum;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public Date getFdate1() {
		return fdate1;
	}
	public void setFdate1(Date fdate1) {
		this.fdate1 = fdate1;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public Date getFdate2() {
		return fdate2;
	}
	public void setFdate2(Date fdate2) {
		this.fdate2 = fdate2;
	}
	public float getFmapx() {
		return fmapx;
	}
	public void setFmapx(float fmapx) {
		this.fmapx = fmapx;
	}
	public float getFmapy() {
		return fmapy;
	}
	public void setFmapy(float fmapy) {
		this.fmapy = fmapy;
	}
	public int getZcode() {
		return zcode;
	}
	public void setZcode(int zcode) {
		this.zcode = zcode;
	}
	
	
	@Override
	public String toString() {
		return "FestivalModel [festNum=" + festNum + ", subject=" + subject + ", fdate1=" + fdate1 + ", area=" + area
				+ ", fdate2=" + fdate2 + ", fmapx=" + fmapx + ", fmapy=" + fmapy + ", zcode=" + zcode + "]";
	}
	
	
	
	
	
	
	
	
	
	

}

package com.yogi.jogi.common.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class FestivalModel {
	private int festNum;
	private String name;
	@DateTimeFormat(pattern = "yyyyMMdd")
	private Date fdate1;
	private String area;
	@DateTimeFormat(pattern = "yyyyMMdd")
	private Date fdate2;
	private float x;
	private float y;
	private int zcode;
	
	public int getFestNum() {
		return festNum;
	}
	public void setFestNum(int festNum) {
		this.festNum = festNum;
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
	
	public int getZcode() {
		return zcode;
	}
	public void setZcode(int zcode) {
		this.zcode = zcode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}
	public float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
	}
	@Override
	public String toString() {
		return "FestivalModel [festNum=" + festNum + ", name=" + name + ", fdate1=" + fdate1 + ", area=" + area
				+ ", fdate2=" + fdate2 + ", x=" + x + ", y=" + y + ", zcode=" + zcode + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}

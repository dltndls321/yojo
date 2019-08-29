package com.yogi.jogi.common.model;


public class SpotModel {
	private int spotNum;
	private String category;
	private String area;
	private String name;
	private float smapx;
	private float smapy;
	private int zcode;
	public int getSpotNum() {
		return spotNum;
	}
	public void setSpotNum(int spotNum) {
		this.spotNum = spotNum;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getSmapx() {
		return smapx;
	}
	public void setSmapx(float smapx) {
		this.smapx = smapx;
	}
	public float getSmapy() {
		return smapy;
	}
	public void setSmapy(float smapy) {
		this.smapy = smapy;
	}
	public int getZcode() {
		return zcode;
	}
	public void setZcode(int zcode) {
		this.zcode = zcode;
	}
	
	@Override
	public String toString() {
		return "SpotModel [spotNum=" + spotNum + ", category=" + category + ", area=" + area + ", name=" + name + ", smapx="
				+ smapx + ", smapy=" + smapy + ", zcode=" + zcode + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	

}

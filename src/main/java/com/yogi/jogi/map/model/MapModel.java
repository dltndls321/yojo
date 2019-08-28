package com.yogi.jogi.map.model;

public class MapModel {

	private int foodnum;
	private String foodname;
	private String foodinfo;
	private String address;
	private float foodx;
	private float foody;
	public int getFoodnum() {
		return foodnum;
	}
	public void setFoodnum(int foodnum) {
		this.foodnum = foodnum;
	}
	public String getFoodname() {
		return foodname;
	}
	public void setFoodname(String foodname) {
		this.foodname = foodname;
	}
	public String getFoodinfo() {
		return foodinfo;
	}
	public void setFoodinfo(String foodinfo) {
		this.foodinfo = foodinfo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public float getFoodx() {
		return foodx;
	}
	public void setFoodx(float foodx) {
		this.foodx = foodx;
	}
	public float getFoody() {
		return foody;
	}
	public void setFoody(float foody) {
		this.foody = foody;
	}
	@Override
	public String toString() {
		return "MapModel [foodnum=" + foodnum + ", foodname=" + foodname + ", foodinfo=" + foodinfo + ", address="
				+ address + ", foodx=" + foodx + ", foody=" + foody + "]";
	}
	
	

	
	
	
	
	
}

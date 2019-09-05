package com.yogi.jogi.map.model;

public class MapModel {

	private int foodnum;
	private String category;
	private String area;
	private String name;
	private float x;
	private float y;
	private int zcode;
	
	public int getFoodnum() {
		return foodnum;
	}
	public void setFoodnum(int foodnum) {
		this.foodnum = foodnum;
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
	
	public int getZcode() {
		return zcode;
	}
	public void setZcode(int zcode) {
		this.zcode = zcode;
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
		return "MapModel [foodnum=" + foodnum + ", category=" + category + ", area=" + area + ", name=" + name + ", x="
				+ x + ", y=" + y + ", zcode=" + zcode + "]";
	}
	
	
	
	

	
	
	
	
	
}

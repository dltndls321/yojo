package com.yogi.jogi.common.model;


public class FoodModel {
	private int foodNum;
	private String category;
	private String area;
	private String name;
	private float foodx;
	private float foody;
	private int zcode;
	public int getFoodNum() {
		return foodNum;
	}
	public void setFoodNum(int foodNum) {
		this.foodNum = foodNum;
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
	public int getZcode() {
		return zcode;
	}
	public void setZcode(int zcode) {
		this.zcode = zcode;
	}
	@Override
	public String toString() {
		return "FoodModel [foodNum=" + foodNum + ", category=" + category + ", area=" + area + ", name=" + name
				+ ", foodx=" + foodx + ", foody=" + foody + ", zcode=" + zcode + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}

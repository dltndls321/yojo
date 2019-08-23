package com.yogi.jogi.map.model;

public class MapModel {

	private String name;
	private String food;
	private String addr;
	private float x;
	private float y;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFood() {
		return food;
	}
	public void setFood(String food) {
		this.food = food;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
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
		return "MapModel [name=" + name + ", food=" + food + ", addr=" + addr + ", x=" + x + ", y=" + y + "]";
	}
	

	
	
	
	
	
}

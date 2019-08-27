package com.yogi.jogi.common.model;

public class FestivalValueModel {
	String addr1;
	String firstimage;
	String title;
	int typeid;
	int contid;
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getFirstimage() {
		return firstimage;
	}
	public void setFirstimage(String firstimage) {
		this.firstimage = firstimage;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getTypeid() {
		return typeid;
	}
	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}
	public int getContid() {
		return contid;
	}
	public void setContid(int contid) {
		this.contid = contid;
	}
	@Override
	public String toString() {
		return "FestivalValueModel [addr1=" + addr1 + ", firstimage=" + firstimage + ", title=" + title + ", typeid="
				+ typeid + ", contid=" + contid + "]";
	}
	
	
}

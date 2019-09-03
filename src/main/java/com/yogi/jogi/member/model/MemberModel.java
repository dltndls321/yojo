package com.yogi.jogi.member.model;

import java.util.Date;

public class MemberModel {
	private int memnum;
	private String id;
	private String passwd;
	private String name;
	private String jumin;
	private String address;
	private String phone;
	private String email;
	private Date regdate;
	private String status;
	private String tokken;
	public int getMemnum() {
		return memnum;
	}
	public void setMemnum(int memnum) {
		this.memnum = memnum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJumin() {
		return jumin;
	}
	public void setJumin(String jumin) {
		this.jumin = jumin;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTokken() {
		return tokken;
	}
	public void setTokken(String tokken) {
		this.tokken = tokken;
	}
	@Override
	public String toString() {
		return "MemberModel [memnum=" + memnum + ", id=" + id + ", passwd=" + passwd + ", name=" + name + ", jumin="
				+ jumin + ", address=" + address + ", phone=" + phone + ", email=" + email + ", regdate=" + regdate
				+ ", status=" + status + ", tokken=" + tokken + "]";
	}
	
	
}

package com.yogi.jogi.member.model;

import java.util.Date;

public class MemberDetailModel {
	private int memnum;
	private String id;
	private String passwd;
	private String name;
	private String jumin1;
	private String jumin2;
	private String postcode;
	private String address1;
	private String detailAddress;
	private String phone1;
	private String phone2;
	private String phone3;
	private String email;
	private Date regdate;
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
	public String getJumin1() {
		return jumin1;
	}
	public void setJumin1(String jumin1) {
		this.jumin1 = jumin1;
	}
	public String getJumin2() {
		return jumin2;
	}
	public void setJumin2(String jumin2) {
		this.jumin2 = jumin2;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getDetailAddress() {
		return detailAddress;
	}
	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}
	public String getPhone1() {
		return phone1;
	}
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}
	public String getPhone2() {
		return phone2;
	}
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	public String getPhone3() {
		return phone3;
	}
	public void setPhone3(String phone3) {
		this.phone3 = phone3;
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
	@Override
	public String toString() {
		return "MemberDetailModel [memnum=" + memnum + ", id=" + id + ", passwd=" + passwd + ", name=" + name
				+ ", jumin1=" + jumin1 + ", jumin2=" + jumin2 + ", postcode=" + postcode + ", address1=" + address1
				+ ", detailAddress=" + detailAddress + ", phone1=" + phone1 + ", phone2=" + phone2 + ", phone3="
				+ phone3 + ", email=" + email + ", regdate=" + regdate + "]";
	}
	
	
}

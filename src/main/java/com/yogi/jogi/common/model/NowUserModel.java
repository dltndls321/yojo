package com.yogi.jogi.common.model;

public class NowUserModel {
	private static int nowUser = 0;

	public static int getNowUser() {
		return nowUser;
	}

	public static void setNowUser(int nowUser) {
		NowUserModel.nowUser = nowUser+1;
	}
	
}

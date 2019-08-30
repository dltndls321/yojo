package com.yogi.jogi.common.model;

public class NowUserModel {
	private static int nowUser=0;

	public static int getNowUser() {
		return nowUser;
	}

	public static void setNowUser(int nowUser) {
		if(NowUserModel.nowUser<=0)
			NowUserModel.nowUser=0;
		NowUserModel.nowUser = nowUser+1;
	}
	
}

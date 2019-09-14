package com.yogi.jogi.common.model;

import com.github.scribejava.core.builder.api.DefaultApi20;

public class KakaoLoginModel extends DefaultApi20{
	protected KakaoLoginModel() {
    }
	private static class InstanceHolder{
        private static final KakaoLoginModel INSTANCE = new KakaoLoginModel();
    }
	public static KakaoLoginModel instance(){
        return InstanceHolder.INSTANCE;
    }
	@Override
	public String getAccessTokenEndpoint() {
		// TODO Auto-generated method stub
		return "https://kauth.kakao.com/oauth/token?grant_type=authorization_code";
	}
	@Override
	protected String getAuthorizationBaseUrl() {
		// TODO Auto-generated method stub
		return "https://kauth.kakao.com/oauth/authorize?response_type=code&encode_state=1";
	}


}

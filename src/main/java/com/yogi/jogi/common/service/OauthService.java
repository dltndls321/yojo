package com.yogi.jogi.common.service;

import java.util.Map;
public interface OauthService {
	 public Map<String, Object> selectKakaoAccountInfo(Map<String, Object> paramMap);
	 public String getKakaoAuthUrl(String tokken);
	 public String getKakaoAccessToken(Map<String, Object> paramMap);
	 public Map<String, Object> selectKakaoInfo(String token);
	 public void deleteKakaoInfo(Map<String, Object> paramMap);
	 public void logoutKakaoInfo(String tokken);
}

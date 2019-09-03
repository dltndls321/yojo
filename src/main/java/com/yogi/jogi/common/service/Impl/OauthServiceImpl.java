package com.yogi.jogi.common.service.Impl;



import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.oauth.OAuth20Service;
import com.yogi.jogi.common.model.KakaoLoginModel;
import com.yogi.jogi.common.service.OauthService;



@Service("oauthService")
public class OauthServiceImpl implements OauthService{
    
    private static final Logger LOGGER = LoggerFactory.getLogger(OauthServiceImpl.class);

    @Resource
    private RestTemplate restTemplate;
    
    
    private static String kakaoRestApiKey = "55c143e0b9c2751bfa9c15f3aef22fd4";
    private static String kakaoRestAdminKey ="44e7930fbfba445bc7331c791e4a7726";
    private static String serviceUrl = "http://211.63.89.29:31235";
    
    @Override
    public String getKakaoAuthUrl(String tokken) {
        OAuth20Service oauthService = new ServiceBuilder()
                .apiKey(kakaoRestApiKey)
                .callback(serviceUrl + "/oauth/kakaoLogin.do")
                .state(tokken)
                .build(KakaoLoginModel.instance());
        return oauthService.getAuthorizationUrl();
    }
    @Override
    public String getKakaoAccessToken(Map<String, Object> paramMap) {
        try {
             
            Map<String, Object> resultMap = new HashMap<String, Object>();
            HttpHeaders headers = new HttpHeaders();
            MultiValueMap<String, String> parameters= new LinkedMultiValueMap<String, String>();
            parameters.add("grant_type", "authorization_code");
            parameters.add("client_id", kakaoRestApiKey);
            parameters.add("redirect_uri", serviceUrl + "/oauth/kakaoLogin.do");
            parameters.add("code", paramMap.get("code").toString());
            
            HttpEntity<MultiValueMap<String, String>> httpRequest = new HttpEntity(parameters, headers);
            
            String result = restTemplate.postForObject("https://kauth.kakao.com/oauth/token", httpRequest, String.class);
            
            JSONObject resultJson = (JSONObject) new JSONParser().parse(result);
            
            //확실한 type 확인이 필요
            return resultJson.get("access_token").toString().replaceAll("\"", "");
            
        }catch (Exception e) {
            LOGGER.warn("error occur while getting KAKAO ACCESS TOKEN");
            return null;
        }
    }
   
    @Override
    public Map<String, Object> selectKakaoAccountInfo(Map<String, Object> paramMap) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        MultiValueMap<String, String> parameters= new LinkedMultiValueMap<String, String>();
        HttpHeaders headers = new HttpHeaders();
        
        headers.add("Authorization", "KakaoAK "+kakaoRestAdminKey);
        parameters.add("target_id_type", "user_id");
        parameters.add("target_id", paramMap.get("id").toString());
        parameters.add("property_keys", "[\"kakao_account.email\",\"properties.nickname\"]");
        
        HttpEntity<MultiValueMap<String, String>> httpRequest = new HttpEntity(parameters, headers);
        resultMap = restTemplate.postForObject("https://kapi.kakao.com/v2/user/me", httpRequest, Map.class);
        
        return resultMap;
    }
    @Override
    public Map<String, Object> selectKakaoInfo(String token){
        Map<String, Object> resultMap = new HashMap<String, Object>();
        
        MultiValueMap<String, String> parameters= new LinkedMultiValueMap<String, String>();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + token);
        parameters.add("property_keys", "[\"kakao_account.email\",\"properties.nickname\",\"kakao_account.birthday\",\"kakao_account.gender\"]");
        HttpEntity<MultiValueMap<String, String>> httpRequest = new HttpEntity(parameters, headers);
        
        resultMap = restTemplate.postForObject("https://kapi.kakao.com/v2/user/me", httpRequest, Map.class);
        //확실한 type 확인이 필요
        
        return resultMap;
    }
    @Override
    public void deleteKakaoInfo(Map<String, Object> paramMap){
        Map<String, Object> resultMap = new HashMap<String, Object>();
        MultiValueMap<String, String> parameters= new LinkedMultiValueMap<String, String>();
        HttpHeaders headers = new HttpHeaders();
        
        headers.add("Authorization", "KakaoAK "+kakaoRestAdminKey);
        parameters.add("target_id_type", "user_id");
        parameters.add("target_id", paramMap.get("id").toString());
        HttpEntity<MultiValueMap<String, String>> httpRequest = new HttpEntity(parameters, headers);
        String result2 = restTemplate.postForObject("https://kapi.kakao.com/v1/user/unlink", httpRequest, String.class);
    }
    
    @Override
    public void logoutKakaoInfo(String tokken) {
    	MultiValueMap<String, String> parameters= new LinkedMultiValueMap<String, String>();
    	 HttpHeaders headers = new HttpHeaders();
    	 headers.add("Authorization", "Bearer " + tokken);
    	 HttpEntity<MultiValueMap<String, String>> httpRequest = new HttpEntity(parameters, headers);
    	 String result2 = restTemplate.postForObject("https://kapi.kakao.com/v1/user/logout", httpRequest, String.class);
    };

    
   
}

package com.yogi.jogi.common.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.github.scribejava.core.model.OAuth2AccessToken;
import com.yogi.jogi.common.service.OauthService;


@Controller
public class OauthController{

    /**
     * 
     */
    private static final long serialVersionUID = -8307085144609236088L;

    @Resource
    private RestTemplate restTemplate;
    @Resource(name="oauthService")
    private OauthService oauthService;
    
//    @Resource
//    private UserSession userSession;
//    @RequestMapping(value="/oauth/kakaoLogin.do")
//    public String kakaoLogin(@RequestParam Map<String, Object> paramMap, ModelMap model, HttpServletRequest request, HttpServletResponse response) throws IOException {
//        if(userSession.getToken().equals(paramMap.get("state").toString()))
//        try {
//            String token = oauthService.getKakaoAccessToken(paramMap);
//            
//            //엑세스 토큰을 이용한 카카오 정보 조회 서비스
//            Map<String, Object> resultMap = oauthService.selectKakaoInfo(token);
//            //계정 정보
//            Map<String, Object> kakaoAccount = (Map<String, Object>) resultMap.get("kakao_account");
//            
//            //이메일 정보가 존재할 시
//            if(kakaoAccount.containsKey("email") /*&& kakaoAccount.containsKey("nickName")*/) {
//                resultMap = oauthService.selectKakaoAccountInfo(resultMap);
//                kakaoAccount = (Map<String, Object>) resultMap.get("kakao_account");
//                kakaoAccount.put("userType", "KAKAO");
//                kakaoAccount.put("access_token", token);
//                Map<String, Object> propertiesMap = (Map<String, Object>) resultMap.get("properties");
//                
//                Map<String, Object> kakaoUserInfo;
//                if(oauthService.chkUserExsist(kakaoAccount)) {
//                    kakaoUserInfo = oauthService.selectUserInfo(kakaoAccount);
//                }else {
//                    kakaoUserInfo = oauthService.insertUserInfo(kakaoAccount, propertiesMap);
//                }
//                String privacy = oauthService.chkPrivacy(kakaoUserInfo);
//                
//                model.addAttribute("privacy", privacy);
//                model.addAttribute("result", "success");
//                model.addAttribute("loginId", kakaoUserInfo.get("userId"));
//            }else {
//                oauthService.deleteKakaoInfo(resultMap);
//                model.addAttribute("result", "fail");
//                model.addAttribute("loginId", kakaoAccount);
//            }
//            RSAUtil.encryptRsa(model);
//            return "login/NaverOauthRedirect";
//        
//        }catch (Exception e) {
//            response.sendRedirect("/");
//            return null;
//        }
//        else {
//            response.sendRedirect("/");
//            return null;
//        }
//    }
}
package com.favccxx.favauth.controller.client;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.oltu.oauth2.common.OAuth;
import org.apache.oltu.oauth2.common.message.types.GrantType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.favccxx.favauth.service.IAuthVerifyService;
import com.favccxx.favauth.util.HttpClientUtils;

/**
 * 模拟构建客户端访问请求
 * @author favccxx
 *
 */
@Controller
@RequestMapping("client")
public class AuthCodeClientController {

	@Autowired
	IAuthVerifyService authVerifyService;

	/**
	 * 根据服务器端的授权许可构造申请访问令牌请求
	 * @param request
	 * @return
	 */
	@RequestMapping("authCodeRequest")
	public ModelAndView authCodeRequest(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		String authCode = request.getParameter(OAuth.OAUTH_CODE);
		String clientId = request.getParameter(OAuth.OAUTH_CLIENT_ID);
		String clientSecret = request.getParameter(OAuth.OAUTH_CLIENT_SECRET);
//		String accessTokenUrl = "http://localhost:8080/FavOAuth2/server/applyAccessToken";
		String redirectUrl = "http://localhost:8080/FavOAuth2/client/";
		
		if (StringUtils.isEmpty(authCode)) {
			mav.setViewName("client/home_client");
			return mav;
		}
		
		

		
		
		// 使用授权码去服务端获取令牌
		if (authVerifyService.checkAuthCode(authCode)) {
			// 此处应采用XXX方法调用FavAccessTokenController获取返回的值
			String userName = authVerifyService.getUsernameByAuthCode(authCode);
			
			String url = "http://localhost:8080/FavOAuth2/server/applyAccessToken";
			Map<String, String> paramMap = new HashMap<String, String>();
			paramMap.put(OAuth.OAUTH_STATE, "123");	
			paramMap.put(OAuth.OAUTH_SCOPE, "RRR");
			paramMap.put(OAuth.OAUTH_REDIRECT_URI, "ding.com");
			paramMap.put(OAuth.OAUTH_GRANT_TYPE, String.valueOf(GrantType.AUTHORIZATION_CODE));
			paramMap.put(OAuth.OAUTH_CLIENT_ID, clientId);
			paramMap.put(OAuth.OAUTH_CODE, authCode);
			paramMap.put(OAuth.OAUTH_CLIENT_SECRET, clientSecret);
			paramMap.put(OAuth.OAUTH_REDIRECT_URI, redirectUrl);
			paramMap.put(OAuth.OAUTH_USERNAME, userName);
			
			String accessToken = HttpClientUtils.doPost(url, paramMap);
			
//			Object resp = JSON.parse(result);    
//	        Map map = (Map)resp;  
//	        String accessToken = "";
//	        if(map.containsKey("accessToken")) {
//	        	accessToken = (String)map.get("accessToken");
//	        }
//			
//			System.out.println("=----------" + accessToken);
			
			mav.addObject("accessToken", accessToken);
			
			//STATE 预防CSRF攻击
			
			mav.setViewName("redirect:http://localhost:8080/FavOAuth2/client/applyAuthUser");

		}

		return mav;
	}

}

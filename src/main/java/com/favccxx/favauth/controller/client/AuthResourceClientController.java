package com.favccxx.favauth.controller.client;

import org.apache.oltu.oauth2.client.OAuthClient;
import org.apache.oltu.oauth2.client.URLConnectionClient;
import org.apache.oltu.oauth2.client.request.OAuthBearerClientRequest;
import org.apache.oltu.oauth2.client.request.OAuthClientRequest;
import org.apache.oltu.oauth2.client.response.OAuthResourceResponse;
import org.apache.oltu.oauth2.common.OAuth;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 根据访问令牌获取登录用户信息
 * 
 * @author favccxx
 *
 */
@Controller
@RequestMapping("client")
public class AuthResourceClientController {

	@RequestMapping(value="/applyAuthUser", produces = "text/html;charset=UTF-8")
	public ModelAndView applyAuthUser(String accessToken) {
		ModelAndView mav = new ModelAndView();
		// 资源认证服务器
		String authResourceServer = "http://localhost:8080/FavOAuth2/server/authUserInfo";
		OAuthClient oAuthClient = new OAuthClient(new URLConnectionClient());
		OAuthClientRequest authUserRequest;
		try {
			authUserRequest = new OAuthBearerClientRequest(authResourceServer).setAccessToken(accessToken).buildQueryMessage();
			
			OAuthResourceResponse resourceResponse = oAuthClient.resource(authUserRequest, OAuth.HttpMethod.GET,
					OAuthResourceResponse.class);
	
			String userName = resourceResponse.getBody();
			System.out.println(userName);
			

			mav.addObject("userName", userName);
			mav.setViewName("client/auth_user");
			
		} catch (OAuthSystemException e) {
			
			e.printStackTrace();
		} catch (OAuthProblemException e) {
			e.printStackTrace();
		}		

		return mav;
	}
}

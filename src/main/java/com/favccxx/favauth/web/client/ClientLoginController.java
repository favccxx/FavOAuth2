package com.favccxx.favauth.web.client;

import javax.servlet.http.HttpServletRequest;

import org.apache.oltu.oauth2.common.OAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.favccxx.favauth.service.IFavAuthService;

@Controller
@RequestMapping("client")
public class ClientLoginController {
	
	@Autowired
	IFavAuthService favAuthService;
	
	@RequestMapping("clientlogin")
	public ModelAndView clientLogin(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		String authCode = request.getParameter(OAuth.OAUTH_CODE);
		if(StringUtils.isEmpty(authCode)){
			mav.setViewName("forward:/oauth2/getoAuth2loginapp");
			return mav;
		}
		//使用令牌换取
		return mav;
	}
	
	
	@RequestMapping("clienthome")
	public ModelAndView clientHome(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		String authCode = request.getParameter(OAuth.OAUTH_CODE);
		if(StringUtils.isEmpty(authCode)){
			mav.setViewName("client/home_client");
			return mav;
		}
		//使用授权码去服务端获取令牌
		if(favAuthService.checkAuthCode(authCode)){
			//此处应采用XXX方法调用FavAccessTokenController获取返回的值
			
			
			String userName = favAuthService.getUsernameByAuthCode(authCode);
			String clientId = "";	//每个网站的客户端Id都是唯一的，即应用注册时生成的webKey.
			mav.addObject(OAuth.OAUTH_CLIENT_ID, clientId);
			mav.addObject(OAuth.OAUTH_CODE, authCode);
			mav.addObject(OAuth.OAUTH_REDIRECT_URI, "");
			mav.addObject(OAuth.OAUTH_USERNAME, userName);
			mav.setViewName("redirect:http://localhost:8086/FAVAUTH/oauth2/favaccesstoken");
			
		}
		
		return mav;
	}

}

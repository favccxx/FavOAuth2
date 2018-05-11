package com.favccxx.favauth.controller.login;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.favccxx.favauth.model.AuthApp;
import com.favccxx.favauth.service.IAuthAppService;

@Controller
@RequestMapping("oauth2")
public class OAuth2LoginController {
	
	@Autowired
	IAuthAppService authAppService;
	
	/**
	 * 可以进行OAuth2认证登录的应用页面
	 * @return
	 */
	@RequestMapping(value={"initOAuth2LoginApp"})
	public ModelAndView initOAuth2LoginApp(){
		ModelAndView mav = new ModelAndView();
		List<AuthApp> appList =  authAppService.listNeedAuthApps();
		mav.addObject("appList", appList);
		mav.setViewName("oauth2/oauth2_login_app");
		return mav;
	}
	
	
	@RequestMapping(value={"initOAuth2Login"})
	public ModelAndView initOAuth2Login(String appId){
		ModelAndView mav = new ModelAndView();
		if(!StringUtils.isEmpty(appId)){
			AuthApp authApp = authAppService.findByAppId(Long.valueOf(appId));
			mav.addObject("authApp", authApp);
		}		
		mav.setViewName("oauth2/oauth2_login");
		return mav;
	}

}

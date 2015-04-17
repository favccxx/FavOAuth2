package com.favccxx.favauth.web.oauth2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.favccxx.favauth.pojo.FavWebApp;
import com.favccxx.favauth.service.IFavWebAppService;

@Controller
@RequestMapping("oauth2")
public class OAuth2LoginController {
	
	@Autowired
	IFavWebAppService favWebAppService;
	
	@RequestMapping(value={"getoAuth2loginapp"})
	public ModelAndView getOAuth2LoginApp(){
		ModelAndView mav = new ModelAndView();
		List<FavWebApp> websiteList =  favWebAppService.findAll();
		mav.addObject("websiteList", websiteList);
		mav.setViewName("oauth2/oAuth2_login_app");
		return mav;
	}
	
	
	@RequestMapping(value={"oauth2login"})
	public ModelAndView oauth2Login(String webId){
		ModelAndView mav = new ModelAndView();
		if(!StringUtils.isEmpty(webId)){
			FavWebApp favWebApp = favWebAppService.findOne(Long.valueOf(webId));
			mav.addObject("favWebApp", favWebApp);
		}		
		mav.setViewName("oauth2/oAuth2Login");
		return mav;
	}

}

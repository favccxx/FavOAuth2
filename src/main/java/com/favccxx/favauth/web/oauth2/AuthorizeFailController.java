package com.favccxx.favauth.web.oauth2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("oauth2")
public class AuthorizeFailController {
	
	@RequestMapping("authorizefailed")
	public ModelAndView authorizeFailed(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("oauth2/oauth2_authorize_fail");
		return mav;
	}

}

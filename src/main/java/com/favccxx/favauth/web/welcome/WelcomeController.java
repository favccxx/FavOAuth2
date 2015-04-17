package com.favccxx.favauth.web.welcome;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("welcome")
public class WelcomeController {
	
	@RequestMapping("welcome")
	public ModelAndView welcome(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("welcome/welcome");
		return mav;
	}

}

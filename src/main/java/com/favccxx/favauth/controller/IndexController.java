package com.favccxx.favauth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	
	@RequestMapping(value= {"", "/",  "/index"})
	public ModelAndView welcome(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		return mav;
	}

}

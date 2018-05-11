package com.favccxx.favauth.controller.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("api")
public class ApiResourceController {
	
	@RequestMapping("initResource")
	public ModelAndView initRestResource(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("api/resource_list");
		return mav;
	}

}

package com.favccxx.favauth.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.favccxx.favauth.pojo.FavUser;

@Controller
public class IndexController {

	@RequestMapping("admin")
	public ModelAndView index(HttpSession session){
		ModelAndView mav = new ModelAndView();
		FavUser favUser = (FavUser) session.getAttribute("favUser");
		mav.addObject("favUser", favUser);
		mav.setViewName("index");
		return mav;
	}
}

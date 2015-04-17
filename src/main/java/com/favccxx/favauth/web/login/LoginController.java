package com.favccxx.favauth.web.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.favccxx.favauth.pojo.FavUser;

@Controller
public class LoginController {
	
	@RequestMapping(value={"login","/"})
	public String login(){
		return "login/login";
	}
	
	
	@RequestMapping("loginForm")
	public ModelAndView loginForm(HttpSession session,HttpServletRequest request,String username, String password, Model model){
		ModelAndView mav = new ModelAndView();
		System.out.println("" + username + password);
		request.setAttribute("username", username);
		request.setAttribute("password", password);
		if(StringUtils.isEmpty(username)){
			mav.setViewName("forward:/login");
			return mav;
		}
		FavUser favUser = new FavUser();
		favUser.setUsername(username);
		favUser.setPassword(password);
		session.setAttribute("favUser", favUser);
		mav.addObject("favUser", favUser);
		mav.setViewName("forward:/admin");
		return mav;
	}
	
	@RequestMapping("oauth2login")
	public ModelAndView oauth2Login(){
		ModelAndView mav = new ModelAndView();
		return mav;
	}

}

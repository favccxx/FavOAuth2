package com.favccxx.favauth.web.applysite;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.favccxx.favauth.pojo.FavWebApp;
import com.favccxx.favauth.service.IFavWebAppService;

@Controller
@RequestMapping("applysite")
public class ApplySiteController {
	
	@Autowired
	IFavWebAppService favWebAppService;
	
	@RequestMapping("initapplysite")
	public ModelAndView initApplySite(){
		ModelAndView mav = new ModelAndView();
		String webKey = UUID.randomUUID().toString();
		mav.addObject("webKey", webKey);
		mav.setViewName("applysite/site_apply");
		
		return mav;
	}
	
	@RequestMapping("initapprovesite")
	public ModelAndView initApproveSite(){
		ModelAndView mav = new ModelAndView();
		List<FavWebApp> websiteList =  favWebAppService.findAll();
		mav.addObject("websiteList", websiteList);
		mav.setViewName("applysite/site_approval");
		
		return mav;
	}
	
	@RequestMapping("approvewebsite")
	public ModelAndView approveWebSite(String webId, String approveState){
		ModelAndView mav = new ModelAndView();
		FavWebApp favWebApp = favWebAppService.findOne(Long.valueOf(webId));
		if(favWebApp!=null){
			favWebApp.setWebState(approveState);
			favWebAppService.updateFavWebApp(favWebApp);
		}
		return mav;
	}

	
	@RequestMapping("/addwebsite")
	@ResponseBody
	public String addWebSite(FavWebApp favWebApp){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("webapply/web_application");
		favWebAppService.createFavWebApp(favWebApp);
		return "";
	}
	
	
}

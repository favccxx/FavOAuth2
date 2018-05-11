package com.favccxx.favauth.controller.site;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.favccxx.favauth.constants.OAuth2Constants;
import com.favccxx.favauth.model.AuthApp;
import com.favccxx.favauth.service.IAuthAppService;

/**
 * 第三方应用网站授权管理
 * 1. 第三方应用网站管理员在OAuth2.0服务器填写需要申请授权访问的网站
 * 2. OAuth2.0服务器管理员进入后台审批系统对第三方应用网站进行审核授权
 * 3. 对于授权的站点，颁发认证信息
 * @author favccxx
 *
 */
@Controller
@RequestMapping("site")
public class AppSiteController {
	
	@Autowired
	IAuthAppService authAppService;
	
	/**
	 * 加载第三方应用申请授权页面
	 * @return
	 */
	@RequestMapping("initApplySite")
	public ModelAndView initApplySite(){
		ModelAndView mav = new ModelAndView();
		String appKey = UUID.randomUUID().toString();
		mav.addObject("appKey", appKey);
		mav.setViewName("site/site_apply");
		
		return mav;
	}
	
	//查询需要授权的应用站点
	@RequestMapping("initNeedApproveSite")
	public ModelAndView initNeedApproveSite(){
		ModelAndView mav = new ModelAndView();
		List<AuthApp> appList =  authAppService.listNeedAuthApps();
		mav.addObject("appList", appList);
		mav.setViewName("site/site_approval");
		
		return mav;
	}
	
	
	@RequestMapping(value="/approveAppSite",produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String approveAppSite(String appId, String appState){		
		AuthApp authApp = authAppService.findByAppId(Long.valueOf(appId));
		if(authApp!=null){
			authApp.setAppState(appState);
			authAppService.saveOrUpdate(authApp);
		}
		return JSON.toJSONString("success");
	}

	
	
	@RequestMapping(value="/addAppSite", produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String addAppSite(AuthApp authApp){
		ModelAndView mav = new ModelAndView();
		authApp.setAppState(OAuth2Constants.APP_STATUS_APPLY);
		mav.setViewName("webapply/web_application");
		authAppService.save(authApp);
		return JSON.toJSONString("success");
	}
	
	
}

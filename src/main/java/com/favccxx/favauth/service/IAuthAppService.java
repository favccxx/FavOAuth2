package com.favccxx.favauth.service;

import java.util.List;

import com.favccxx.favauth.model.AuthApp;

public interface IAuthAppService {
	
	/**
	 * 新增第三方应用网站信息
	 * @param authApp
	 * @return
	 */
	void save(AuthApp authApp);
	
	/**
	 * 新增或更新第三方应用网站信息
	 * @param authApp
	 * @return
	 */
	void saveOrUpdate(AuthApp authApp);
	
	/**
	 * 删除第三方应用网站信息
	 * @param authApp
	 */
	void delete(AuthApp authApp);	
	
	/**
	 * 根据应用网站ID查询应用网站信息
	 * @param appId
	 * @return
	 */
	AuthApp findByAppId(long appId);
	
	/**
	 * 根据应用网站代码查找应用网站信息
	 * @param appKey
	 * @return
	 */
	AuthApp findByAppKey(String appKey);
	
	
	List<AuthApp> listNeedAuthApps();


}

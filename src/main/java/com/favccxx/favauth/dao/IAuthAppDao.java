package com.favccxx.favauth.dao;

import java.util.List;

import com.favccxx.favauth.model.AuthApp;

public interface IAuthAppDao extends IBaseDao<AuthApp>{
	
	/**
	 * 根据应用网站代码查找应用网站信息
	 * @param appKey
	 * @return
	 */
	AuthApp findByAppKey(String appKey);
	
	/**
	 * 根据应用网站状态查询第三方应用网站列表
	 * 如appState为空对象或空字符串时则查询所有的应用网站列表
	 * @param appState
	 * @return
	 */
	List<AuthApp> listByAppState(String appState);

}

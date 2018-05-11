package com.favccxx.favauth.dao;

import com.favccxx.favauth.model.AuthUser;

public interface IAuthUserDao extends IBaseDao<AuthUser> {

	/**
	 * 根据用户名查找用户信息
	 * @param username
	 * @return
	 */
	AuthUser findByUserName(String userName);
	
}

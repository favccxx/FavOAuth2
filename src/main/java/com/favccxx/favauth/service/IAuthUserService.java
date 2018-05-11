package com.favccxx.favauth.service;

import com.favccxx.favauth.model.AuthUser;

public interface IAuthUserService {

	/**
	 * 新增用户
	 * @param authUser
	 * @return
	 */
	void save(AuthUser authUser);
	
	/**
	 * 新增或更新用户
	 * @param authUser
	 * @return
	 */
	void saveOrUpdate(AuthUser authUser);
	
	/**
	 * 删除用户
	 * @param authUser
	 */
	void delete(AuthUser authUser);	
	
	/**
	 * 根据用户Id查找用户信息
	 * @param id
	 * @return
	 */
	AuthUser findById(long id);
	
	/**
	 * 根据用户名查找用户信息
	 * @param username
	 * @return
	 */
	AuthUser findByUserName(String userName);
	
}

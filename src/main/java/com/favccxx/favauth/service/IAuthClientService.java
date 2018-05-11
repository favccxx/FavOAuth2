package com.favccxx.favauth.service;

import com.favccxx.favauth.model.AuthClient;

public interface IAuthClientService {
	
	/**
	 * 新增认证客户端信息
	 * @param authClient
	 * @return
	 */
	void save(AuthClient authClient);
	
	/**
	 * 新增或更新客户端信息
	 * @param authClient
	 * @return
	 */
	void saveOrUpdate(AuthClient authClient);
	
	/**
	 * 删除客户端信息
	 * @param authClient
	 */
	void delete(AuthClient authClient);
	
	/**
	 * 根据客户端Id删除客户端信息
	 * @param clientId
	 */
	void deleteByClientId(String clientId);
	
	/**
	 * 根据客户端Id查询认证客户端信息
	 * @param clientId
	 * @return
	 */
    AuthClient findByClientId(String clientId);
    
    /**
     * 根据密钥查询认证客户端信息
     * @param clientSecret
     * @return
     */
    AuthClient findByClientSecret(String clientSecret);
	
	    
}

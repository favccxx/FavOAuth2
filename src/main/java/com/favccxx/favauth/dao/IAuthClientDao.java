package com.favccxx.favauth.dao;

import com.favccxx.favauth.model.AuthClient;

public interface IAuthClientDao extends IBaseDao<AuthClient>{
	
	/**
	 * 根据客户端Id删除客户端认证信息
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

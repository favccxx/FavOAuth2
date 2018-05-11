package com.favccxx.favauth.service;

public interface IAuthVerifyService {

	/**
	 * 添加授权代码
	 * 
	 * @param authCode
	 *            授权代码
	 * @param username
	 *            用户名
	 */
	void addAuthCode(String authCode, String username);
	

    /**
     * 根据授权码获取登陆用户的用户名
     * @param authCode
     * @return
     */
	String getUsernameByAuthCode(String authCode);
	
	/**
	 * 验证授权代码是否有效
	 * 
	 * @param authCode
	 *            授权代码
	 * @return
	 */
	boolean checkAuthCode(String authCode);
	
	
	/**
	 * 添加访问令牌
	 * @param accessToken 访问令牌
	 * @param username 用户名
	 */
	void addAccessToken(String accessToken, String username);
	
	/**
	 * 验证访问令牌是否有效
	 * @param accessToken 访问令牌
	 * @return
	 */
    boolean checkAccessToken(String accessToken); 
    
    /**
     * 根据令牌获取用户名
     * @param accessToken
     * @return
     */
    String getUsernameByAccessToken(String accessToken);
    
    

	/**
	 * 校验客户端密钥是否正确
	 * 
	 * @param clientSecret
	 * @return
	 */
	boolean checkClientSecret(String clientSecret);

	
	
	 /**
     * 获取授权代码/令牌过期时间
     * @return
     */
    long getExpireIn();

	
	
}

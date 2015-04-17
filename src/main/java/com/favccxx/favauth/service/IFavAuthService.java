package com.favccxx.favauth.service;

public interface IFavAuthService {
	
	/**
	 * 添加授权代码
	 * @param authCode 授权代码
	 * @param username 用户名 
	 */
	public void addAuthCode(String authCode, String username);
	
	/**
	 * 添加访问令牌
	 * @param accessToken 访问令牌
	 * @param username 用户名
	 */
	public void addAccessToken(String accessToken, String username); 
	
	/**
	 * 验证授权代码是否有效
	 * @param authCode 授权代码
	 * @return
	 */
	boolean checkAuthCode(String authCode); 
	
	/**
	 * 验证访问令牌是否有效
	 * @param accessToken 访问令牌
	 * @return
	 */
    boolean checkAccessToken(String accessToken); 
    
    /**
     * 根据授权代码获取用户名
     * @param authCode
     * @return
     */
    String getUsernameByAuthCode(String authCode);
    
    /**
     * 根据令牌获取用户名
     * @param accessToken
     * @return
     */
    String getUsernameByAccessToken(String accessToken);
    
    /**
     * 获取授权代码/令牌过期时间
     * @return
     */
    long getExpireIn();
    
    /**
     * 检查客户端Id是否存在
     * @param clientId 客户端Id
     * @return
     */
    public boolean checkClientId(String clientId);
    
    /**
     * 检查客户端安全Key是否存在
     * @param clientSecret
     * @return
     */
    public boolean checkClientSecret(String clientSecret);

}

package com.favccxx.favauth.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import com.favccxx.favauth.dao.IAuthClientDao;
import com.favccxx.favauth.service.IAuthVerifyService;

@Service
public class AuthVerifyServiceImpl implements IAuthVerifyService {

	private Cache cache;
	
	@Autowired
	IAuthClientDao authClientDao;	
	
	public AuthVerifyServiceImpl(CacheManager cacheManager){
		this.cache = cacheManager.getCache("code-cache");
	}

	@Override
	public void addAuthCode(String authCode, String username) {
		cache.put(authCode, username);
	}

	@Override
	public boolean checkClientSecret(String clientSecret) {
		return authClientDao.findByClientSecret(clientSecret) != null;
	}

	@Override
	public boolean checkAuthCode(String authCode) {
		return cache.get(authCode) != null;
	}

	@Override
	public long getExpireIn() {
		 return 3600L;
	}
	
	@Override
	public String getUsernameByAuthCode(String authCode) {
		return (String)cache.get(authCode).get();
	}

	@Override
	public void addAccessToken(String accessToken, String username) {
		cache.put(accessToken, username);
	}

	@Override
	public boolean checkAccessToken(String accessToken) {
		return cache.get(accessToken) != null;
	}

	@Override
	public String getUsernameByAccessToken(String accessToken) {
		return (String)cache.get(accessToken).get();
	}

}

package com.favccxx.favauth.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.favccxx.favauth.dao.IAuthClientDao;
import com.favccxx.favauth.model.AuthClient;
import com.favccxx.favauth.service.IAuthClientService;

@Service
public class AuthClientServiceImpl implements IAuthClientService {
	
	@Autowired
	IAuthClientDao authClientDao;	

	@Transactional
	@Override
	public void save(AuthClient authClient) {
		authClientDao.save(authClient);
	}

	@Transactional
	@Override
	public void saveOrUpdate(AuthClient authClient) {
		authClientDao.saveOrUpdate(authClient);
	}

	@Transactional
	@Override
	public void delete(AuthClient authClient) {
		authClientDao.delete(authClient);
	}

	@Transactional
	@Override
	public void deleteByClientId(String clientId) {
		authClientDao.deleteByClientId(clientId);
	}

	@Override
	public AuthClient findByClientId(String clientId) {
		return authClientDao.findByClientId(clientId);
	}

	@Override
	public AuthClient findByClientSecret(String clientSecret) {
		return authClientDao.findByClientSecret(clientSecret);
	}	
	
	
}

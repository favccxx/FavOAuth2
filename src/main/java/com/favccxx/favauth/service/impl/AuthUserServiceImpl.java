package com.favccxx.favauth.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.favccxx.favauth.dao.IAuthUserDao;
import com.favccxx.favauth.model.AuthUser;
import com.favccxx.favauth.service.IAuthUserService;

@Service
public class AuthUserServiceImpl implements IAuthUserService {
	
	@Autowired
	IAuthUserDao authUserDao;	

	@Override
	public void save(AuthUser authUser) {
		authUserDao.save(authUser);
	}

	@Override
	public void saveOrUpdate(AuthUser authUser) {
		authUserDao.saveOrUpdate(authUser);
	}

	@Override
	public void delete(AuthUser authUser) {
		authUserDao.delete(authUser);
	}

	@Override
	public AuthUser findById(long id) {
		return authUserDao.load(id);
	}

	@Override
	public AuthUser findByUserName(String userName) {
		return authUserDao.findByUserName(userName);
	}

	

}

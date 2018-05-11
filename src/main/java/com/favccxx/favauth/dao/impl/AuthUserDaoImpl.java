package com.favccxx.favauth.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.favccxx.favauth.dao.IAuthUserDao;
import com.favccxx.favauth.model.AuthUser;

@Repository
public class AuthUserDaoImpl extends BaseDaoImpl<AuthUser> implements IAuthUserDao {

	@SuppressWarnings("unchecked")
	@Override
	public AuthUser findByUserName(String userName) {
		String hql = "from AuthUser where userName = ?";		
		List<AuthUser> list = (List<AuthUser>) hibernateTemplate.find(hql, userName);
		
		if(list!=null && list.size()>0) {
			return list.get(0);
		}
		
		return null;
	}

	

}

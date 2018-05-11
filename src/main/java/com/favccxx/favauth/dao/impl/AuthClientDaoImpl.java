package com.favccxx.favauth.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.favccxx.favauth.dao.IAuthClientDao;
import com.favccxx.favauth.model.AuthClient;

@Repository
public class AuthClientDaoImpl extends BaseDaoImpl<AuthClient> implements IAuthClientDao {
	
	@Override
	public void deleteByClientId(String clientId) {
		AuthClient authClient = findByClientId(clientId);
		hibernateTemplate.delete(authClient);
	}

	@SuppressWarnings("unchecked")
	@Override
	public AuthClient findByClientId(String clientId) {
		String hql = "from AuthClient where clientId=?";
		List<AuthClient> list = (List<AuthClient>) hibernateTemplate.find(hql, clientId);
		if(list!=null && list.size()>0) {
			return list.get(0);
		}
		
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public AuthClient findByClientSecret(String clientSecret) {
		String hql = "from AuthClient where clientSecret=?";
		List<AuthClient> list = (List<AuthClient>) hibernateTemplate.find(hql, clientSecret);
		if(list!=null) {
			return list.get(0);
		}
		
		return null;
	}

	

	

}

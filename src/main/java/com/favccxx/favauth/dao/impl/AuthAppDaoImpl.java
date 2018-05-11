package com.favccxx.favauth.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.favccxx.favauth.dao.IAuthAppDao;
import com.favccxx.favauth.model.AuthApp;

@Repository
public class AuthAppDaoImpl extends BaseDaoImpl<AuthApp> implements IAuthAppDao {

	@SuppressWarnings("unchecked")
	@Override
	public AuthApp findByAppKey(String appKey) {
		String hql = "from AuthApp where appKey=?";
		List<AuthApp> list = (List<AuthApp>) hibernateTemplate.find(hql, appKey);
		if(list!=null && list.size()>0) {
			return list.get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AuthApp> listByAppState(String appState) {
		if(StringUtils.isBlank(appState)) {
			String hql = "from AuthApp";
			List<AuthApp> list = (List<AuthApp>) hibernateTemplate.find(hql);
			return list;
		}
		String hql = "from AuthApp where appState=?";
		List<AuthApp> list = (List<AuthApp>) hibernateTemplate.find(hql, appState);
		return list;
	}

}

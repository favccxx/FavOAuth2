package com.favccxx.favauth.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.favccxx.favauth.constants.OAuth2Constants;
import com.favccxx.favauth.dao.IAuthAppDao;
import com.favccxx.favauth.dao.IAuthClientDao;
import com.favccxx.favauth.model.AuthApp;
import com.favccxx.favauth.model.AuthClient;
import com.favccxx.favauth.service.IAuthAppService;

@Service
public class AuthAppServiceImpl implements IAuthAppService {
	
	@Autowired
	IAuthAppDao authAppDao;	
	@Autowired
	IAuthClientDao authClientDao;	

	@Transactional
	@Override
	public void save(AuthApp authApp) {
		authAppDao.save(authApp);
	}

	@Transactional
	@Override
	public void saveOrUpdate(AuthApp authApp) {
		authAppDao.saveOrUpdate(authApp);
		
		//当应用网站状态为APPROVED时，将应用网站注册到认证客户端
		if(authApp.getAppState()!=null && OAuth2Constants.APP_STATUS_APPROVE.equals(authApp.getAppState())) {
			AuthClient authClient = authClientDao.findByClientId(authApp.getAppKey());
			if(authClient == null) {
				authClient = new AuthClient();
				authClient.setClientId(authApp.getAppKey());
				authClient.setClientName(authApp.getAppName());
				authClient.setClientSecret("xxxxxxx");
				authClientDao.save(authClient);
			}
		}
		
	}

	@Transactional
	@Override
	public void delete(AuthApp authApp) {
		authAppDao.delete(authApp);
	}

	

	@Override
	public AuthApp findByAppKey(String appKey) {
		return authAppDao.findByAppKey(appKey);
	}

	@Override
	public List<AuthApp> listNeedAuthApps() {
		return authAppDao.listByAppState("");
	}

	@Override
	public AuthApp findByAppId(long appId) {
		return authAppDao.load(appId);
	}

}

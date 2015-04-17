package com.favccxx.favauth.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.favccxx.favauth.dao.IFavWebAppDao;
import com.favccxx.favauth.pojo.FavWebApp;
import com.favccxx.favauth.service.IFavWebAppService;

@Service("favWebAppService")
public class FabWebAppServiceImpl implements IFavWebAppService {
	
	@Autowired
	private IFavWebAppDao favWebAppDao;

	@Override
	public FavWebApp createFavWebApp(FavWebApp favWebApp) {
		return favWebAppDao.createFavWebApp(favWebApp);
	}

	@Override
	public List<FavWebApp> findAll() {
		return favWebAppDao.findAll();
	}

	@Override
	public FavWebApp updateFavWebApp(FavWebApp favWebApp) {
		return favWebAppDao.updateFavWebApp(favWebApp);
	}

	@Override
	public FavWebApp findOne(Long webId) {
		return favWebAppDao.findOne(webId);
	}

}

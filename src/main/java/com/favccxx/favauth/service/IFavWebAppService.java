package com.favccxx.favauth.service;

import java.util.List;

import com.favccxx.favauth.pojo.FavWebApp;

public interface IFavWebAppService {

	public FavWebApp createFavWebApp(FavWebApp favWebApp);
	
	public FavWebApp updateFavWebApp(FavWebApp favWebApp);
	
	FavWebApp findOne(Long webId);
	
	List<FavWebApp> findAll();
	
	
	
}

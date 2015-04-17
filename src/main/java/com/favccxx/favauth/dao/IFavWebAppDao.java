package com.favccxx.favauth.dao;

import java.util.List;

import com.favccxx.favauth.pojo.FavWebApp;

public interface IFavWebAppDao {
	
	public FavWebApp createFavWebApp(FavWebApp favWebApp);
	
	public FavWebApp updateFavWebApp(FavWebApp favWebApp);
	
	FavWebApp findOne(Long webId);
	
	List<FavWebApp> findAll();

}

package com.favccxx.favauth.service;

import java.util.List;

import com.favccxx.favauth.pojo.FavClient;

public interface IFavClientService {

	public FavClient createFavClient(FavClient favClient);
    public FavClient updateFavClient(FavClient favClient);
    public void deleteFavClient(Long clientId);

    FavClient findOne(Long clientId);

    List<FavClient> findAll();

    FavClient findByClientId(String clientId);
    FavClient findByClientSecret(String clientSecret);
	    
}

package com.favccxx.favauth.dao;

import java.util.List;

import com.favccxx.favauth.pojo.FavUser;

public interface IFavUserDao {

	public FavUser createFavUser(FavUser favUser);

	public FavUser updateFavUser(FavUser favUser);

	public void deleteFavUser(Long userId);

	FavUser findOne(Long userId);

	List<FavUser> findAll();

	FavUser findByUsername(String username);

}

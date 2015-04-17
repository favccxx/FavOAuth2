package com.favccxx.favauth.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import com.favccxx.favauth.dao.IFavWebAppDao;
import com.favccxx.favauth.pojo.FavWebApp;

@Repository("favWebAppDao")
public class FavWebAppDaoImpl implements IFavWebAppDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public FavWebApp createFavWebApp(final FavWebApp favWebApp) {
		final String sql = "insert into fav_web_app(webKey, webName, webProfile, webCategory, webUrl,webState) values(?,?,?,?,?,?)";

		GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				PreparedStatement psst = connection.prepareStatement(sql,
						new String[] { "webId" });
				int count = 1;
				psst.setString(count++, favWebApp.getWebKey());
				psst.setString(count++, favWebApp.getWebName());
				psst.setString(count++, favWebApp.getWebProfile());
				psst.setString(count++, favWebApp.getWebCategory());
				psst.setString(count++, favWebApp.getWebUrl());
				psst.setString(count++, favWebApp.getWebState());
				return psst;
			}
		}, keyHolder);

		favWebApp.setWebId(keyHolder.getKey().longValue());
		return favWebApp;
	}

	@Override
	public List<FavWebApp> findAll() {
		String sql = "select webId, webKey, webName, webProfile, webCategory, webUrl, webState from fav_web_app";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<FavWebApp>(FavWebApp.class));
	}

	@Override
	public FavWebApp updateFavWebApp(FavWebApp favWebApp) {
		String sql = "update fav_web_app set webKey=?, webName=?, webProfile=?, webCategory=?, webUrl=?,webState=? where webId=?";
		jdbcTemplate.update(sql,favWebApp.getWebKey(), favWebApp.getWebName(), favWebApp.getWebProfile(), favWebApp.getWebCategory(),
				favWebApp.getWebUrl(), favWebApp.getWebState(), favWebApp.getWebId());
		return favWebApp;
	}

	@Override
	public FavWebApp findOne(Long webId) {
		String sql = "select  webId, webKey, webName, webProfile, webCategory, webUrl, webState from fav_web_app where webId=?";
		List<FavWebApp> webAppList = jdbcTemplate.query(sql,
				new BeanPropertyRowMapper<FavWebApp>(FavWebApp.class), webId);
		if (webAppList.size() == 0) {
			return null;
		}
		return webAppList.get(0);
	}

	

}

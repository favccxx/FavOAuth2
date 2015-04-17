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

import com.favccxx.favauth.dao.IFavClientDao;
import com.favccxx.favauth.pojo.FavClient;

@Repository("favClientDao")
public class FavClientDaoImpl implements IFavClientDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public FavClient createFavClient(final FavClient favClient) {
		final String sql = "insert into fav_client(client_name, client_id, client_secret) values(?,?,?)";

		GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				PreparedStatement psst = connection.prepareStatement(sql,
						new String[] { "id" });
				int count = 1;
				psst.setString(count++, favClient.getClientName());
				psst.setString(count++, favClient.getClientId());
				psst.setString(count++, favClient.getClientSecret());
				return psst;
			}
		}, keyHolder);

		favClient.setId(keyHolder.getKey().longValue());
		return favClient;
	}

	@Override
	public FavClient updateFavClient(FavClient favClient) {
		String sql = "update fav_client set client_name=?, client_id=?, client_secret=? where id=?";
		jdbcTemplate.update(sql, favClient.getClientName(),
				favClient.getClientId(), favClient.getClientSecret(),
				favClient.getId());
		return favClient;
	}

	@Override
	public void deleteFavClient(Long clientId) {
		String sql = "delete from fav_client where id=?";
		jdbcTemplate.update(sql, clientId);
	}

	@Override
	public FavClient findOne(Long clientId) {
		String sql = "select id, client_name, client_id, client_secret from fav_client where id=?";
		List<FavClient> clientList = jdbcTemplate.query(sql,
				new BeanPropertyRowMapper<FavClient>(FavClient.class), clientId);
		if (clientList.size() == 0) {
			return null;
		}
		return clientList.get(0);
	}

	@Override
	public List<FavClient> findAll() {
		String sql = "select id, client_name, client_id, client_secret from fav_client";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<FavClient>(FavClient.class));
	}

	@Override
	public FavClient findByClientId(String clientId) {
		String sql = "select id, client_name, client_id, client_secret from fav_client where client_id=?";
		List<FavClient> clientList = jdbcTemplate.query(sql,
				new BeanPropertyRowMapper<FavClient>(FavClient.class), clientId);
		if (clientList.size() == 0) {
			return null;
		}
		return clientList.get(0);
	}

	@Override
	public FavClient findByClientSecret(String clientSecret) {
		String sql = "select id, client_name, client_id, client_secret from fav_client where client_secret=?";
		List<FavClient> clientList = jdbcTemplate.query(sql,
				new BeanPropertyRowMapper<FavClient>(FavClient.class), clientSecret);
		if (clientList.size() == 0) {
			return null;
		}
		return clientList.get(0);
	}

}

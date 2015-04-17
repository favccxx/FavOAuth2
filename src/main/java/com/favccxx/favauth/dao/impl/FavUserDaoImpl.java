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

import com.favccxx.favauth.dao.IFavUserDao;
import com.favccxx.favauth.pojo.FavUser;

@Repository("favUserDao")
public class FavUserDaoImpl implements IFavUserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public FavUser createFavUser(final FavUser favUser) {
		final String sql = "insert into fav_user(username, password, salt) values(?,?,?)";

		GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				PreparedStatement psst = connection.prepareStatement(sql,
						new String[] { "id" });
				int count = 1;
				psst.setString(count++, favUser.getUsername());
				psst.setString(count++, favUser.getPassword());
				psst.setString(count++, favUser.getSalt());
				return psst;
			}
		}, keyHolder);

		favUser.setId(keyHolder.getKey().longValue());
		return favUser;
	}

	@Override
	public FavUser updateFavUser(FavUser favUser) {
		String sql = "update fav_user set username=?, password=?, salt=? where id=?";
		jdbcTemplate.update(sql, favUser.getUsername(), favUser.getPassword(),
				favUser.getSalt(), favUser.getId());
		return favUser;
	}

	@Override
	public void deleteFavUser(Long userId) {
		String sql = "delete from fav_user where id=?";
		jdbcTemplate.update(sql, userId);
	}

	@Override
	public FavUser findOne(Long userId) {
		String sql = "select id, username, password, salt from fav_user where id=?";
		List<FavUser> userList = jdbcTemplate.query(sql,
				new BeanPropertyRowMapper<FavUser>(FavUser.class), userId);
		if (userList.size() == 0) {
			return null;
		}
		return userList.get(0);
	}

	@Override
	public List<FavUser> findAll() {
		String sql = "select id, username, password, salt from fav_user";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<FavUser>(FavUser.class));
	}

	@Override
	public FavUser findByUsername(String username) {
		String sql = "select id, username, password, salt from fav_user where username=?";
		List<FavUser> userList = jdbcTemplate.query(sql,
				new BeanPropertyRowMapper<FavUser>(FavUser.class), username);
		if (userList.size() == 0) {
			return null;
		}
		return userList.get(0);
	}

}

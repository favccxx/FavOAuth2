package com.favccxx.favauth.pojo;

import java.io.Serializable;

public class FavUser implements Serializable {

	private Long id; // 编号
	private String username; // 用户名
	private String password; // 密码
	private String salt; // 加密密码的盐

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;

		FavUser favUser = (FavUser) obj;

		if (id != null ? !id.equals(favUser.id) : favUser.id != null)
			return false;

		return true;
	}

}

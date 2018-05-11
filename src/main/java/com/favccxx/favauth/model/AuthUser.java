package com.favccxx.favauth.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * OAuth认证服务器用户实体类
 * @author favccxx
 *
 */
@Entity
@Table(name = "FAV_AUTH_USER")
public class AuthUser {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="authUserSeq")
	@SequenceGenerator(name="authUserSeq",initialValue = 1, allocationSize = 1, sequenceName = "FAV_AUTH_USER_SEQ" )
	@Column(name = "ID")
	private long id;	

	@Column(name = "USER_NAME", unique = true)
	private String userName;

	@Column(name = "NICK_NAME")
	private String nickName;

	@Column(name = "USER_PWD")
	private String userPwd;	
	
	@Column(name = "USER_STATUS")
	private String userStatus;

	@Column(name = "BIRTHDAY")
	private Date birthday;

	@Column(name = "USER_MAIL")
	private String userMail;

	@Column(name = "USER_TEL")
	private String userTel;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getUserMail() {
		return userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	public String getUserTel() {
		return userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	
	
}

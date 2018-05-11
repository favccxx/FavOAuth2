package com.favccxx.favauth.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 第三方应用网站实体类
 * 记录第三方网站的基本信息
 * @author favccxx
 *
 */
@Entity
@Table(name = "FAV_AUTH_APP")
public class AuthApp implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="authAppSeq")
	@SequenceGenerator(name="authAppSeq", initialValue = 1, allocationSize = 1, sequenceName = "FAV_AUTH_APP_SEQ" )
	@Column(name = "ID")
	private Long id;
	
	/**
	 * 应用网站代码
	 */
	private String appKey;
	
	/**
	 * 应用网站名称
	 */
	private String appName;
	
	/**
	 * 应用网站简介
	 */
	private String appProfile;
	
	/**
	 * 应用网站分类
	 */
	private String appCategory;
	
	/**
	 * 应用网站地址
	 */
	private String appUrl;
	
	/**
	 * 应用网站状态
	 */
	private String appState;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAppKey() {
		return appKey;
	}

	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getAppProfile() {
		return appProfile;
	}

	public void setAppProfile(String appProfile) {
		this.appProfile = appProfile;
	}

	public String getAppCategory() {
		return appCategory;
	}

	public void setAppCategory(String appCategory) {
		this.appCategory = appCategory;
	}

	public String getAppUrl() {
		return appUrl;
	}

	public void setAppUrl(String appUrl) {
		this.appUrl = appUrl;
	}

	public String getAppState() {
		return appState;
	}

	public void setAppState(String appState) {
		this.appState = appState;
	}

	
	
	
	
}

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
 * 授权客户端实体类
 * 只有数据库中存在的客户端站点才有资格申请访问服务器的资源
 * @author favccxx
 *
 */
@Entity
@Table(name = "FAV_AUTH_CLIENT")
public class AuthClient implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="authClientSeq")
	@SequenceGenerator(name="authClientSeq", initialValue = 1, allocationSize = 1, sequenceName = "FAV_AUTH_CLIENT_SEQ" )
	@Column(name = "ID")
	private Long id;
	
	/**
	 * 客户端Id
	 */
	@Column(name = "CLIENT_ID")
	private String clientId;
	
	/**
	 * 客户端名称
	 */
	@Column(name = "CLIENT_NAME")
	private String clientName;
	
	/**
	 * 客户端密钥
	 */
	@Column(name = "CLIENT_SECRET")
	private String clientSecret;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}
	
	
	
}

package com.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "evs_tbl_user_credentials")
public class UserCredentialsEntity {

	@GeneratedValue
	@Id
	@Column(name = "userid")
	private String userid;

	@Column(name = "password")
	private String password;

	@Column(name = "usertype")
	private String usertype;

	@Column(name = "loginstatus")
	private int loginStatus;

	@Column(name = "session_id")
	private String sessionId;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public int getLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(int loginStatus) {
		this.loginStatus = loginStatus;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public UserCredentialsEntity(String userid, String password, String usertype, int loginStatus, String sessionId) {
		super();
		this.userid = userid;
		this.password = password;
		this.usertype = usertype;
		this.loginStatus = loginStatus;
		this.sessionId = sessionId;
	}

	public UserCredentialsEntity() {
		super();
	}

}

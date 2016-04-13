package com.drpeng.pengxin.api.domain;

import java.io.Serializable;

public class User implements Serializable {
	private static final long serialVersionUID = -8623475762493346151L;
	private Long id;
	private String username;
	private String password;
	private Long accountId;//服务商id
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

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
}

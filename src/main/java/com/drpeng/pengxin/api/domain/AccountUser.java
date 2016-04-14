package com.drpeng.pengxin.api.domain;

import java.io.Serializable;

/**
 * 服务商账号
 */
public class AccountUser implements Serializable {

	private static final long serialVersionUID = 8807491206476904381L;
	private Long id;
	private String account;
	private String password;
	private String secret;
	private Integer status;//状态
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}

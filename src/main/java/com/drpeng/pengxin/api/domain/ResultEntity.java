package com.drpeng.pengxin.api.domain;

import com.wordnik.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class ResultEntity implements Serializable {

	private static final long serialVersionUID = -155361761690519237L;
	@ApiModelProperty(value = "状态码", required = true)
	private String code;
	@ApiModelProperty(value = "信息", required = true)
	private String msg;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}


}

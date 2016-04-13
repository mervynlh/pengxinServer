package com.drpeng.pengxin.api.domain;

import com.wordnik.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class ResultMes<T> extends ResultEntity implements Serializable {


	private static final long serialVersionUID = 610015964113348649L;
	@ApiModelProperty("返回数据")
	private T data;	
	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	
	

}

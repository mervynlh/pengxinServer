package api.pengxin.domain;

import com.wordnik.swagger.annotations.ApiModelProperty;

import java.util.HashMap;

public class ResultEntity {

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

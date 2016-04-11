package api.pengxin.domain;

import com.wordnik.swagger.annotations.ApiModelProperty;

public class ResultMes<T> extends ResultEntity {
	
	
	@ApiModelProperty("返回数据")
	private T data;	
	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	
	

}

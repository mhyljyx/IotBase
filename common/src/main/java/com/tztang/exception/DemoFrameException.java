package com.tztang.exception;

import com.tztang.common.ApiResponse;
import com.tztang.enums.BaseCode;
import lombok.Data;

/**
 * @program: 
 * @description: 业务异常
 * @author: tztang
 **/
@Data
public class DemoFrameException extends BaseException {

	private Integer code;
	
	private String message;

	public DemoFrameException() {
		super();
	}

	public DemoFrameException(String message) {
		super(message);
	}
	
	
	public DemoFrameException(String code, String message) {
		super(message);
		this.code = Integer.parseInt(code);
		this.message = message;
	}
	
	public DemoFrameException(Integer code, String message) {
		super(message);
		this.code = code;
		this.message = message;
	}
	
	public DemoFrameException(BaseCode baseCode) {
		super(baseCode.getMsg());
		this.code = baseCode.getCode();
		this.message = baseCode.getMsg();
	}
	
	public DemoFrameException(ApiResponse apiResponse) {
		super(apiResponse.getMessage());
		this.code = apiResponse.getCode();
		this.message = apiResponse.getMessage();
	}

	public DemoFrameException(Throwable cause) {
		super(cause);
	}

	public DemoFrameException(String message, Throwable cause) {
		super(message, cause);
		this.message = message;
	}

	public DemoFrameException(Integer code, String message, Throwable cause) {
		super(message, cause);
		this.code = code;
		this.message = message;
	}
}

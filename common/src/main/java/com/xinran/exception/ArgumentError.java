package com.xinran.exception;

import lombok.Data;

/**
 * @program: 
 * @description: 参数错误
 * @author: tztang
 **/
@Data
public class ArgumentError {
	
	private String argumentName;
	
	private String message;
}

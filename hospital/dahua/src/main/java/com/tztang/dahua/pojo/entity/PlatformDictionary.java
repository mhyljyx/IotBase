package com.tztang.dahua.pojo.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import io.swagger.annotations.ApiModelProperty;

/**
 * @description  订阅平台 
 * @author  tztang
 * @Date 2024-11-14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlatformDictionary  implements Serializable {

	private static final long serialVersionUID =  5471725690888406955L;

	/**
	 * 平台标识
	 */
	private String sign;

	/**
	 * 平台名称
	 */
	private String name;

}

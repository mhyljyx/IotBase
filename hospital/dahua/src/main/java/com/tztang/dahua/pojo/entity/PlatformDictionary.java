package com.tztang.dahua.pojo.entity;

import com.tztang.data.BaseTableData;
import lombok.Data;

import java.io.Serializable;

/**
 * @description  订阅平台 
 * @author  tztang
 * @Date 2024-11-21
 */
@Data
public class PlatformDictionary extends BaseTableData implements Serializable {

	private static final long serialVersionUID =  3443450302073691064L;

	/**
	 * 平台标识
	 */
	private String sign;

	/**
	 * 平台名称
	 */
	private String name;

}

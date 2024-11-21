package com.tztang.pojo.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import com.tztang.data.BaseTableData;
import lombok.Data;

import java.io.Serializable;

/**
 * @description  订阅平台 
 * @author  tztang
 * @Date 2024-11-21
 */
@Data
public class PlatformDictionaryDto {

	/**
	 * 平台标识
	 */
	private String sign;

	/**
	 * 平台名称
	 */
	private String name;

}

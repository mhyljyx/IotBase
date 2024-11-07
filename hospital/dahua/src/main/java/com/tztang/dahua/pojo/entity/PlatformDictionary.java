package com.tztang.dahua.pojo.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import io.swagger.annotations.ApiModelProperty;

/**
 * @description  订阅平台字典表
 * @author  tztang
 * @Date 2024-11-07
 */
@Data
@TableName("platform_dictionary")
public class PlatformDictionary  implements Serializable {

	private static final long serialVersionUID =  1479565629941043142L;

	/**
	 * 平台标识
	 */
	@TableId(type = IdType.INPUT)
	private String sign;

	/**
	 * 平台名称
	 */
	private String name;

}

package com.tztang.dahua.pojo.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import io.swagger.annotations.ApiModelProperty;

/**
 * @description  事件订阅（设备||通道）关联表 
 * @author  tztang
 * @Date 2024-11-14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventSubscribeNodeCode  implements Serializable {

	private static final long serialVersionUID =  6659137133917891172L;

	/**
	 * 事件订阅名称
	 */
	private String subscribeName;

	/**
	 * 设备或者通道编号
	 */
	private String nodeCode;

}

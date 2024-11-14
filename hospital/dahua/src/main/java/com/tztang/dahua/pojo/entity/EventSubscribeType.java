package com.tztang.dahua.pojo.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import io.swagger.annotations.ApiModelProperty;

/**
 * @description  事件订阅类型关联表 
 * @author  tztang
 * @Date 2024-11-14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventSubscribeType  implements Serializable {

	private static final long serialVersionUID =  7476611276839196666L;

	/**
	 * 事件订阅名称
	 */
	private String subscribeName;

	/**
	 * 事件类型
	 */
	private String type;

}

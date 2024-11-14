package com.tztang.dahua.pojo.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import io.swagger.annotations.ApiModelProperty;

/**
 * @description  事件订阅组织关联表 
 * @author  tztang
 * @Date 2024-11-14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventSubscribeOrg  implements Serializable {

	private static final long serialVersionUID =  4801923088818319317L;

	/**
	 * 事件订阅名称
	 */
	private String subscribeName;

	/**
	 * 组织代码
	 */
	private String org;

}

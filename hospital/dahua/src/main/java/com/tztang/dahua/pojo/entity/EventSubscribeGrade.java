package com.tztang.dahua.pojo.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import io.swagger.annotations.ApiModelProperty;

/**
 * @description  事件订阅报警关联表 
 * @author  tztang
 * @Date 2024-11-14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventSubscribeGrade  implements Serializable {

	private static final long serialVersionUID =  4684970657001480092L;

	/**
	 * 事件订阅名称
	 */
	private String subscribeName;

	/**
	 * 告警等级
	 */
	private Integer grade;

}

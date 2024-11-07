package com.tztang.dahua.pojo.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import io.swagger.annotations.ApiModelProperty;

/**
 * @description  事件订阅报警关联表 
 * @author  tztang
 * @Date 2024-11-07
 */
@Data
@TableName("event_subscribe_grade")
public class EventSubscribeGrade  implements Serializable {

	private static final long serialVersionUID =  9123363065922232910L;

	/**
	 * 事件订阅名称
	 */
	private String subscribeName;

	/**
	 * 告警等级
	 */
	private Integer grade;

}

package com.tztang.dahua.pojo.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import io.swagger.annotations.ApiModelProperty;

/**
 * @description  事件订阅（设备||通道）关联表 
 * @author  tztang
 * @Date 2024-11-07
 */
@Data
@TableName("event_subscribe_node_code")
public class EventSubscribeNodeCode  implements Serializable {

	private static final long serialVersionUID =  9127148531349143303L;

	/**
	 * 事件订阅名称
	 */
	private String subscribeName;

	/**
	 * 设备或者通道编号
	 */
	private String nodeCode;

}

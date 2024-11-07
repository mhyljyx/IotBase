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
 * @description  事件订阅类型关联表 
 * @author  tztang
 * @Date 2024-11-07
 */
@Data
@TableName("event_subscribe_type")
public class EventSubscribeType  implements Serializable {

	private static final long serialVersionUID =  6043657433396403721L;

	/**
	 * 事件订阅名称
	 */
	private String subscribeName;

	/**
	 * 事件类型
	 */
	private String type;

}

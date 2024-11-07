package com.tztang.dahua.pojo.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import io.swagger.annotations.ApiModelProperty;

/**
 * @description  事件订阅组织关联表 
 * @author  tztang
 * @Date 2024-11-07
 */
@Data
@TableName("event_subscribe_org")
public class EventSubscribeOrg  implements Serializable {

	private static final long serialVersionUID =  4246385693551041321L;

	/**
	 * 事件订阅名称
	 */
	private String subscribeName;

	/**
	 * 组织代码
	 */
	private String org;

}

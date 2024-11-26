package com.tztang.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.io.Serializable;
import com.tztang.data.BaseTableData;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

/**
 * @description  事件订阅类型关联表 
 * @author  tztang
 * @Date 2024-11-21
 */
@Data
@TableName("event_subscribe_type")
public class EventSubscribeType extends BaseTableData implements Serializable {

	private static final long serialVersionUID =  6211828511225266788L;

	/**
	 * 事件订阅id一致
	 */
	private Integer subscribeId;

	/**
	 * 事件订阅名称
	 */
	private String subscribeName;

	/**
	 * 事件类型
	 */
	private String type;

}

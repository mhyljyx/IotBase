package com.tztang.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.io.Serializable;
import com.tztang.data.BaseTableData;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

/**
 * @description  事件订阅（设备||通道）关联表 
 * @author  tztang
 * @Date 2024-11-21
 */
@Data
@TableName("event_subscribe_node_code")
public class EventSubscribeNodeCode extends BaseTableData implements Serializable {

	private static final long serialVersionUID =  5934713997497025097L;

	/**
	 * 事件订阅id一致
	 */
	private Integer subscribeId;

	/**
	 * 事件订阅名称
	 */
	private String subscribeName;

	/**
	 * 设备或者通道编号
	 */
	private String nodeCode;

}

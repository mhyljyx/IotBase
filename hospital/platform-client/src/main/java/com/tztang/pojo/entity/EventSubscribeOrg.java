package com.tztang.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.io.Serializable;
import com.tztang.data.BaseTableData;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

/**
 * @description  事件订阅组织关联表 
 * @author  tztang
 * @Date 2024-11-21
 */
@Data
@TableName("event_subscribe_org")
public class EventSubscribeOrg extends BaseTableData implements Serializable {

	private static final long serialVersionUID =  9111678284319328558L;

	/**
	 * 事件订阅id一致
	 */
	private Integer subscribeId;

	/**
	 * 事件订阅名称
	 */
	private String subscribeName;

	/**
	 * 组织代码
	 */
	private String org;

}

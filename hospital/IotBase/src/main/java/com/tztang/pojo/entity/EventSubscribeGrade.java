package com.tztang.pojo.entity;

import lombok.Data;
import java.io.Serializable;
import com.tztang.data.BaseTableData;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

/**
 * @description  事件订阅报警关联表 
 * @author  tztang
 * @Date 2024-11-21
 */
@Data
public class EventSubscribeGrade extends BaseTableData implements Serializable {

	private static final long serialVersionUID =  3411952192902657646L;

	/**
	 * 事件订阅id一致
	 */
	private Integer subscribeId;

	/**
	 * 事件订阅名称
	 */
	private String subscribeName;

	/**
	 * 告警等级
	 */
	private Integer grade;

}

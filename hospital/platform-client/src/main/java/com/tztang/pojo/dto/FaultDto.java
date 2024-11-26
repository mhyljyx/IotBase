package com.tztang.pojo.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.tztang.data.BaseTableData;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @description  故障信息表 
 * @author  tztang
 * @Date 2024-11-21
 */
@Data
public class FaultDto {

	/**
	 * 故障事件唯
一编码
	 */
	private String id;

	/**
	 * 事件源类型
	 */
	private Integer deviceCategory;

	/**
	 * 事件源编码
	 */
	private String deviceId;

	/**
	 * 运营服务机
构唯一编码
	 */
	private String parentId;

	/**
	 * 故障类型
	 */
	private Integer type;

	/**
	 * 事件发生时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date eventTime;

	/**
	 * 故障发生位置
	 */
	private String location;

	/**
	 * 故障原因
	 */
	private String reason;

}
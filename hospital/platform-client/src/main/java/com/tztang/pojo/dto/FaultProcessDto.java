package com.tztang.pojo.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.tztang.data.BaseTableData;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @description  故障处理信息表 
 * @author  tztang
 * @Date 2024-11-21
 */
@Data
public class FaultProcessDto {

	/**
	 * 与故障信息上报时编码一致
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
	 * 故障恢复时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date happenTime;

	/**
	 * 故障处理方式
	 */
	private String processType;

	/**
	 * 故障处理情况（人工处理时需填写）
	 */
	private String faultContent;

	/**
	 * 处理人员名称
	 */
	private String handleUserId;

}

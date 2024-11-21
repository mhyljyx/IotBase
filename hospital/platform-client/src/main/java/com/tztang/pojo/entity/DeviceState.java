package com.tztang.pojo.entity;

import lombok.Data;
import java.io.Serializable;
import com.tztang.data.BaseTableData;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

/**
 * @description  运行状态表 
 * @author  tztang
 * @Date 2024-11-21
 */
@Data
@TableName("device_state")
public class DeviceState extends BaseTableData implements Serializable {

	private static final long serialVersionUID =  8327535048710297312L;

	/**
	 * 事件唯一编码
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
	 * 运营服务机构唯一编码
	 */
	private String parentId;

	/**
	 * 在离线状态 0-离线，1-在线
	 */
	private Integer onlineStatus;

	/**
	 * 运行状态 0-离线，1-在线
	 */
	private Integer workStatus;

	/**
	 * 事件发生时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date eventTime;

}

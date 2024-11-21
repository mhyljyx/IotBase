package com.tztang.pojo.entity;

import lombok.Data;
import java.io.Serializable;
import com.tztang.data.BaseTableData;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

/**
 * @description  火灾预警信息 
 * @author  tztang
 * @Date 2024-11-21
 */
@Data
@TableName("fire_alarm")
public class FireAlarm extends BaseTableData implements Serializable {

	private static final long serialVersionUID =  5947881808703587834L;

	/**
	 * 火灾预警事件唯一编码
	 */
	private String id;

	/**
	 * 运营服务机构唯一编码
	 */
	private String parentId;

	/**
	 * 事件源类型
	 */
	private Integer deviceCategory;

	/**
	 * 事件源编码
	 */
	private String deviceId;

	/**
	 * 火灾预警类型
	 */
	private String alarmType;

	/**
	 * 事件发生时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date eventTime;

	/**
	 * 火灾预警等级
	 */
	private Integer alarmLevel;

	/**
	 * 火灾预警图片信息
	 */
	private String imageUrls;

	/**
	 * 火灾预警视频信息
	 */
	private String videoUrls;

}

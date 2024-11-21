package com.tztang.pojo.entity;

import lombok.Data;
import java.io.Serializable;
import com.tztang.data.BaseTableData;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

/**
 * @description  事件预警信息 
 * @author  tztang
 * @Date 2024-11-21
 */
@Data
@TableName("warning")
public class Warning extends BaseTableData implements Serializable {

	private static final long serialVersionUID =  2671748808833799853L;

	/**
	 * 事件预警事件唯一编码
	 */
	private String id;

	/**
	 * 运营服务机
构唯一编码
	 */
	private String parentId;

	/**
	 * 事件源编码
	 */
	private String deviceId;

	/**
	 * 事件发生时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date eventTime;

	/**
	 * 事件预警类型
	 */
	private String alarmType;

	/**
	 * 报警时刻的图片，多个url通过逗号分隔
	 */
	private String imageUrls;

	/**
	 * 实时视频，多个url通过逗号分隔，需要考虑链接的安全
	 */
	private String videoUrls;

}

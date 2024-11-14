package com.tztang.pojo.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

/**
 * @description  火灾预警处置信息 
 * @author  tztang
 * @Date 2024-11-14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FireAlarmProcess  implements Serializable {

	private static final long serialVersionUID =  4018502526672625499L;

	/**
	 * 火灾预警事件唯一编码
	 */
	private String id;

	/**
	 * 运营服务机
构唯一编码
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
	 * 火警类型
	 */
	private String alarmType;

	/**
	 * 火灾预警复核时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date checkTime;

	/**
	 * 处理完成时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date handleTime;

	/**
	 * 火灾预警复核方式
	 */
	private String processType;

	/**
	 * 现场处置人员姓名
	 */
	private String handleUserName;

	/**
	 * 值守处置人员编号
	 */
	private String handleUserId;

	/**
	 * 复核结果
	 */
	private String handleStatus;

	/**
	 * 火灾预警处理记录
	 */
	private String handleContext;

	/**
	 * 现场处理图片信息
	 */
	private String handleImageUrls;

	/**
	 * 现场处理视频信息
	 */
	private String handleVideoUrls;

	/**
	 * 更新时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date updateTime;

	/**
	 * 创建时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date createTime;

	/**
	 * 0:正常 1:删除
	 */
	private Integer isDel;

}
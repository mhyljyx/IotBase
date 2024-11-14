package com.tztang.pojo.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

/**
 * @description  事件预警信息 
 * @author  tztang
 * @Date 2024-11-14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Warning  implements Serializable {

	private static final long serialVersionUID =  6269958214490729799L;

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

package com.tztang.pojo.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

/**
 * @description  运行状态表 
 * @author  tztang
 * @Date 2024-11-15
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeviceState  implements Serializable {

	private static final long serialVersionUID =  8707108810120995117L;

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

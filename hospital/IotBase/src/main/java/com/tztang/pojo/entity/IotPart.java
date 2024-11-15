package com.tztang.pojo.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

/**
 * @description  部件表 
 * @author  tztang
 * @Date 2024-11-15
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IotPart  implements Serializable {

	private static final long serialVersionUID =  3935099545278035338L;

	/**
	 * 部件唯一编号
	 */
	private String id;

	/**
	 * 部件名称
	 */
	private String name;

	/**
	 * 运营服务机
构唯一编码
	 */
	private String parentId;

	/**
	 * 部件识别码
	 */
	private String sensorCode;

	/**
	 * 安装位置
	 */
	private String address;

	/**
	 * 部件类型
	 */
	private Integer type;

	/**
	 * 关联编码
	 */
	private String relationId;

	/**
	 * 所属建筑物编号
	 */
	private String buildingId;

	/**
	 * 所属设备编码
	 */
	private String deviceId;

	/**
	 * 3C证书编号
	 */
	private String code3C;

	/**
	 * 型式检验报告编号
	 */
	private String qualifiedCode;

	/**
	 * 部件生产厂商
	 */
	private String manufactory;

	/**
	 * 部件生产时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date produceDate;

	/**
	 * 部件安装时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date installDate;

	/**
	 * 部件到期时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date expireDate;

	/**
	 * 地图类型
	 */
	private Integer mapType;

	/**
	 * 经度
	 */
	private String lng;

	/**
	 * 维度
	 */
	private String lat;

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

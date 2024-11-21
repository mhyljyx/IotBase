package com.tztang.pojo.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.tztang.data.BaseTableData;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @description  物联设备表 
 * @author  tztang
 * @Date 2024-11-21
 */
@Data
public class IotDeviceDto {

	/**
	 * 设备编号
	 */
	private String id;

	/**
	 * 设备名称
	 */
	private String name;

	/**
	 * 运营服务机
构唯一编码
	 */
	private String parentId;

	/**
	 * 设备识别码
	 */
	private String deviceCode;

	/**
	 * 安装位置
	 */
	private String location;

	/**
	 * 设备厂商
	 */
	private String deviceManufactory;

	/**
	 * 设备类型
	 */
	private String deviceType;

	/**
	 * 3C证书编号
	 */
	private String code3C;

	/**
	 * 型式检验报告编号
	 */
	private String qualifiedCode;

	/**
	 * 关联编码
	 */
	private String relationId;

	/**
	 * 所属建筑物编号
	 */
	private String buildingId;

	/**
	 * 施工单位名称
	 */
	private String constructor;

	/**
	 * 设备生产时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date produceDate;

	/**
	 * 设备安装时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date installDate;

	/**
	 * 设备到期时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date expireDate;

	/**
	 * 部件总数
	 */
	private Integer partsNum;

	/**
	 * 设备报警通知号码
	 */
	private String notifyPhone;

	/**
	 * 硬件版本
	 */
	private String hardwareVersion;

	/**
	 * 软件版本
	 */
	private String softwareVersion;

	/**
	 * 消控室位置
	 */
	private String controlroomPosition;

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

}

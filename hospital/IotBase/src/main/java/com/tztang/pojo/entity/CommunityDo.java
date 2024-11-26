package com.tztang.pojo.entity;

import lombok.Data;
import java.io.Serializable;
import com.tztang.data.BaseTableData;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

/**
 * @description  互联网单位信息表 
 * @author  tztang
 * @Date 2024-11-21
 */
@Data
@TableName("community")
public class CommunityDo extends BaseTableData implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	/**
	 * 联网单位编码
	 */
	private String code;

	/**
	 * 联网单位名称
	 */
	private String name;

	/**
	 * 运营服务机构唯一编码
	 */
	private String parentId;

	/**
	 * 联网单位地址编码
	 */
	private String creditCode;

	/**
	 * 联网单位地址
	 */
	private String address;

	/**
	 * 行政区域编码
	 */
	private String regionCode;

	/**
	 * 管辖单位联系电话
	 */
	private String phoneNum;

	/**
	 * 管辖单位
	 */
	private String managerCompany;

	/**
	 * 单位占地面积
	 */
	private String occaupyArea;

	/**
	 * 总建筑面积
	 */
	private String buildArea;

	/**
	 * 单位类型（该巡查点位属于联网单位或住宅小区：1-联网单位，2-住宅小区）
	 */
	private String type;

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
	 * 是否启用上传(false:关闭上传 true:开启上传)
	 */
	private Boolean isOpen;

}

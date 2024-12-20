package com.tztang.pojo.entity;

import lombok.Data;
import java.io.Serializable;
import com.tztang.data.BaseTableData;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

/**
 * @description  巡更记录表 
 * @author  tztang
 * @Date 2024-11-21
 */
@Data
@TableName("patrol_record")
public class PatrolRecord extends BaseTableData implements Serializable {

	private static final long serialVersionUID =  6606143474192414199L;

	/**
	 * 任务唯一id
	 */
	private String id;

	/**
	 * 运营服务机构唯一编码
	 */
	private String parentId;

	/**
	 * 巡检点位名称
	 */
	private String name;

	/**
	 * 巡更任务结果
	 */
	private Integer result;

	/**
	 * 巡更任务状态
	 */
	private Integer status;

	/**
	 * 巡更任务类型 0：安保巡更，1：消防巡更
	 */
	private Integer type;

	/**
	 * 计划开始时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date scheduledStartTime;

	/**
	 * 计划截止时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date scheduledEndTime;

	/**
	 * 实际开始时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date actualStartTime;

	/**
	 * 实际截止时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date actualEndTime;

	/**
	 * 路线id
	 */
	private String routeId;

	/**
	 * 巡检点位唯一编码
	 */
	private String pointId;

	/**
	 * 点位顺序
	 */
	private Integer order;

	/**
	 * 完成时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date finishTime;

	/**
	 * 巡更点位状态(0：待核查，1：预约维修，2：消防整改，3：其它处理，4：已处理，5：无需处理)
	 */
	private Integer pointStatus;

	/**
	 * 单位编码
	 */
	private String relationId;

}

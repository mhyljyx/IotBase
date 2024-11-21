package com.tztang.pojo.entity;

import lombok.Data;
import java.io.Serializable;
import com.tztang.data.BaseTableData;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

/**
 * @description  隐患信息表 
 * @author  tztang
 * @Date 2024-11-21
 */
@Data
@TableName("hidden_danger")
public class HiddenDanger extends BaseTableData implements Serializable {

	private static final long serialVersionUID =  1942476307970387654L;

	/**
	 * 事件id
	 */
	private String id;

	/**
	 * 运营服务机构唯一编码
	 */
	private String parentId;

	/**
	 * 巡更任务id（当danger_source=1时，表示巡更任务id）
	 */
	private String taskId;

	/**
	 * 路线id
	 */
	private String routeId;

	/**
	 * 巡检点位唯一编码
	 */
	private String pointId;

	/**
	 * 用户id
	 */
	private String userId;

	/**
	 * 隐患说明
	 */
	private String description;

	/**
	 * 隐患位置
	 */
	private String position;

	/**
	 * 隐患状态（0待核查，1处理中，2已办结，3超时完成）
	 */
	private String status;

	/**
	 * 隐患来源 0隐患上报，1巡检异常，2消防投诉
	 */
	private String source;

	/**
	 * 隐患标签：0其他隐患，1消防给水管道没水，2消防设施故障，3消防器材缺失，4安全通道堵塞或关闭，5电线老化，6物联设备故障
	 */
	private String labelList;

}

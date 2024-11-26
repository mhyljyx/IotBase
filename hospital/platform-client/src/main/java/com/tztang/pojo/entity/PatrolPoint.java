package com.tztang.pojo.entity;

import lombok.Data;
import java.io.Serializable;
import com.tztang.data.BaseTableData;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

/**
 * @description  巡更点位 
 * @author  tztang
 * @Date 2024-11-21
 */
@Data
@TableName("patrol_point")
public class PatrolPoint extends BaseTableData implements Serializable {

	private static final long serialVersionUID =  6689124191158813442L;

	/**
	 * 巡更点位
	 */
	private String id;

	/**
	 * 巡更点位名称
	 */
	private String name;

	/**
	 * 运营服务机构唯一编码
	 */
	private String parentId;

	/**
	 * 巡检点位类型
	 */
	private String pointType;

	/**
	 * 关联编码
	 */
	private String relationId;

}

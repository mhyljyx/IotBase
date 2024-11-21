package com.tztang.pojo.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import com.tztang.data.BaseTableData;
import lombok.Data;

import java.io.Serializable;

/**
 * @description  巡更点位 
 * @author  tztang
 * @Date 2024-11-21
 */
@Data
public class PatrolPointDto {

	/**
	 * 巡更点位
	 */
	private String id;

	/**
	 * 巡更点位名称
	 */
	private String name;

	/**
	 * 运营服务机
构唯一编码
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

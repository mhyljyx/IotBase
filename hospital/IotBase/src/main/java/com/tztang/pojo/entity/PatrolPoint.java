package com.tztang.pojo.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

/**
 * @description  巡更点位 
 * @author  tztang
 * @Date 2024-11-14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatrolPoint  implements Serializable {

	private static final long serialVersionUID =  1301844423239037577L;

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

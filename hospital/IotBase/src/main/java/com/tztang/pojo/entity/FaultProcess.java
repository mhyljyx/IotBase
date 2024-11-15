package com.tztang.pojo.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

/**
 * @description  故障处理信息表 
 * @author  tztang
 * @Date 2024-11-15
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FaultProcess  implements Serializable {

	private static final long serialVersionUID =  5614916655973367605L;

	/**
	 * 与故障信息上报时编码一致
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
	 * 运营服务机
构唯一编码
	 */
	private String parentId;

	/**
	 * 故障恢复时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date happenTime;

	/**
	 * 故障处理方式
	 */
	private String processType;

	/**
	 * 故障处理情况（人工处理时需填写）
	 */
	private String faultContent;

	/**
	 * 处理人员名称
	 */
	private String userId;

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

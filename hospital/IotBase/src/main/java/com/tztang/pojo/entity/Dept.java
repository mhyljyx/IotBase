package com.tztang.pojo.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

/**
 * @description  部门表 
 * @author  tztang
 * @Date 2024-11-15
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dept  implements Serializable {

	private static final long serialVersionUID =  8124555064593080979L;

	/**
	 * 部门id
	 */
	private String id;

	/**
	 * 地方三方部门id
	 */
	private String openId;

	/**
	 * 部门名称
	 */
	private String name;

	/**
	 * 父级部门id
	 */
	private Integer parentId;

	/**
	 * 描述
	 */
	private String remark;

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

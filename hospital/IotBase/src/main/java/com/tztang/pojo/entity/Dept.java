package com.tztang.pojo.entity;

import lombok.Data;
import java.io.Serializable;
import com.tztang.data.BaseTableData;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

/**
 * @description  部门表 
 * @author  tztang
 * @Date 2024-11-21
 */
@Data
public class Dept extends BaseTableData implements Serializable {

	private static final long serialVersionUID =  7126502851515130067L;

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
	private String parentId;

	/**
	 * 描述
	 */
	private String remark;

}

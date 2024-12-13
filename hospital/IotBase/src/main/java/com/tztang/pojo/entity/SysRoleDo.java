package com.tztang.pojo.entity;

import lombok.Data;
import java.io.Serializable;
import com.tztang.data.BaseTableData;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

/**
 * @description  系统角色表 
 * @author  tztang
 * @Date 2024-12-10
 */
@Data
@TableName("sys_role")
public class SysRoleDo extends BaseTableData implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 角色ID（主键）
	 */
	private Long id;

	/**
	 * 角色名称
	 */
	private String name;

	/**
	 * 描述
	 */
	private String description;

}

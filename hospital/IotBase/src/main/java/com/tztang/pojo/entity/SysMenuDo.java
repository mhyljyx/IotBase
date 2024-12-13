package com.tztang.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import java.io.Serializable;
import com.tztang.data.BaseTableData;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

/**
 * @description  系统菜单表 
 * @author  tztang
 * @Date 2024-12-10
 */
@Data
@TableName("sys_menu")
public class SysMenuDo extends BaseTableData implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 菜单ID（主键）
	 */
	@TableId(type = IdType.AUTO)
	private Long id;

	/**
	 * 菜单名称
	 */
	private String name;

	/**
	 * 前端路由地址

	 */
	private String url;

	/**
	 * 父菜单ID（支持菜单树）
	 */
	private Integer parentId;

	/**
	 * 类型（0目录，1菜单）
	 */
	private Integer type;

}

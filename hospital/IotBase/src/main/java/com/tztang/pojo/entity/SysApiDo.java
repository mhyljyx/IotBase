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
 * @description  系统接口表 
 * @author  tztang
 * @Date 2024-11-27
 */
@Data
@TableName("sys_api")
public class SysApiDo extends BaseTableData implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableId(type = IdType.AUTO)
	private Long id;

	/**
	 * 接口名称
	 */
	private String name;

	/**
	 * 接口路径
	 */
	private String url;

	/**
	 * 请求方法(GET/POST/PUT/DELETE)
	 */
	private String method;

	/**
	 * 描述
	 */
	private String description;

	public SysApiDo(String name, String url, String method, String description) {
		this.name = name;
		this.url = url;
		this.method = method;
		this.description = description;
	}

	public SysApiDo(Long id, String name, String url, String method, String description) {
		this.id = id;
		this.name = name;
		this.url = url;
		this.method = method;
		this.description = description;
	}

}

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
public class SysApi extends BaseTableData implements Serializable {

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
	private String isDel;

	public SysApi(String name, String url, String method, String description) {
		this.name = name;
		this.url = url;
		this.method = method;
		this.description = description;
	}

}

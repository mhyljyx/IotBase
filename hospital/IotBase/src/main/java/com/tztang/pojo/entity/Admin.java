package com.tztang.pojo.entity;

import lombok.Data;
import java.io.Serializable;
import com.tztang.data.BaseTableData;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

/**
 * @description  管理员表 
 * @author  tztang
 * @Date 2024-11-21
 */
@Data
public class Admin extends BaseTableData implements Serializable {

	private static final long serialVersionUID =  1348897486995432116L;

	/**
	 * 管理员id
	 */
	private String id;

	/**
	 * 账号
	 */
	private String account;

	/**
	 * 管理员名称
	 */
	private String name;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 管理员角色
	 */
	private String role;

	/**
	 * 状态 0.正常 1.锁定
	 */
	private String status;

}

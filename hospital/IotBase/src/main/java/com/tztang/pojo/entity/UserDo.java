package com.tztang.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.io.Serializable;
import com.tztang.data.BaseTableData;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

/**
 * @description  用户信息表 
 * @author  tztang
 * @Date 2024-11-21
 */
@Data
@TableName("sys_user")
public class UserDo extends BaseTableData implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 用户id
	 */
	private String id;

	/**
	 * 用户姓名
	 */
	private String name;

	/**
	 * 性别 0女 1男 9未知
	 */
	private String sex;

	/**
	 * 身份证信息
	 */
	private String idNumber;

	/**
	 * 所属部门
	 */
	private String deptId;

	/**
	 * 账号
	 */
	private String account;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 手机号
	 */
	private String mobilePhone;

	/**
	 * 座机号
	 */
	private String phone;

	/**
	 * 地址
	 */
	private String address;

	/**
	 * 角色类型
	 */
	private String roleType;

	/**
	 * 人员类型
	 */
	private String type;

	/**
	 * 状态 0.正常 1.锁定
	 */
	private String status;

}

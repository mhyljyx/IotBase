package com.tztang.pojo.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

/**
 * @description  用户信息表 
 * @author  tztang
 * @Date 2024-11-15
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User  implements Serializable {

	private static final long serialVersionUID =  2301310286348125498L;

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

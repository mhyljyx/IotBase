package com.tztang.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * @description  管理员信息
 * @author  tztang
 * @Date 2024-11-27
 */
@Data
public class AdminVo {

	@ApiModelProperty(name ="id", dataType ="String", value ="管理员id")
	private String id;

	@ApiModelProperty(name ="account", dataType ="String", value ="账号")
	private String account;

	@ApiModelProperty(name ="mail", dataType ="String", value ="邮箱")
	private String mail;

	@ApiModelProperty(name ="name", dataType ="String", value ="管理员名称")
	private String name;

	@ApiModelProperty(name ="password", dataType ="String", value ="密码")
	private String password;

	@ApiModelProperty(name ="role", dataType ="Integer", value ="管理员角色")
	private Integer roleId;

	@ApiModelProperty(name ="status", dataType ="String", value ="状态 0.正常 1.锁定")
	private String status;

}

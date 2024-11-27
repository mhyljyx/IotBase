package com.tztang.pojo.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import com.tztang.data.BaseTableData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @description  新增管理员
 * @author  tztang
 * @Date 2024-11-27
 */
@Data
@ApiModel("新增管理员DTO")
public class AdminDto {

	@NotBlank(message = "账号不能为空")
	@Length(max = 64, message = "账号长度不能超过64")
	@ApiModelProperty(name ="account", dataType ="String", value ="账号", required = true)
	private String account;

	@Length(max = 32, message = "邮箱长度不能超过32")
	@ApiModelProperty(name ="mail", dataType ="String", value ="邮箱", required = true)
	private String mail;

	@NotBlank(message = "管理员名称不能为空")
	@Length(max = 255, message = "管理员名称长度不能超过255")
	@ApiModelProperty(name ="name", dataType ="String", value ="管理员名称", required = true)
	private String name;

	@NotBlank(message = "密码不能为空")
	@Length(max = 32, message = "密码长度不能超过32")
	@ApiModelProperty(name ="password", dataType ="String", value ="密码", required = true)
	private String password;

	@Length(max = 1, min = 1, message = "管理员角色长度必须为1")
	@ApiModelProperty(name ="role", dataType ="String", value ="管理员角色", required = true)
	private String role;

}

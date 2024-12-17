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
 * @description  修改管理员
 * @author  tztang
 * @Date 2024-11-21
 */
@Data
@ApiModel("修改管理员DTO")
public class AdminUpdateDto {

	@NotBlank(message = "管理员id不能为空")
	@Length(max = 35, message = "管理员id长度不能超过35")
	@ApiModelProperty(name ="id", dataType ="String", value ="管理员id", required = true)
	private String id;

	@Length(max = 32, message = "邮箱长度不能超过32")
	@ApiModelProperty(name ="mail", dataType ="String", value ="邮箱", required = true)
	private String mail;

	@NotBlank(message = "管理员名称不能为空")
	@Length(max = 255, message = "管理员名称长度不能超过255")
	@ApiModelProperty(name ="name", dataType ="String", value ="管理员名称", required = true)
	private String name;

	@NotBlank(message = "角色类型不能为空")
	@ApiModelProperty(name ="roleType", dataType ="String", value ="角色类型", required = true)
	private String roleType;

}

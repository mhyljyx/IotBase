package com.tztang.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @description  更新部门
 * @author  tztang
 * @Date 2024-11-27
 */
@Data
@ApiModel("更新部门信息DTO")
public class DeptUpdateDto {

	@NotBlank(message = "部门id不能为空")
	@Length(max = 35, message = "部门id长度不能超过35")
	@ApiModelProperty(name ="id", dataType ="String", value ="部门id",required = true)
	private String id;

	@NotBlank(message = "部门名称不能为空")
	@Length(max = 255, message = "部门名称长度不能超过255")
	@ApiModelProperty(name ="name", dataType ="String", value ="部门名称", required = true)
	private String name;

	@NotBlank(message = "父级部门id不能为空")
	@Length(max = 32, message = "父级部门id长度不能超过32")
	@ApiModelProperty(name ="parentId", dataType ="String", value ="父级部门id")
	private String parentId;

	@Length(max = 255, message = "描述不能超过255")
	@ApiModelProperty(name ="remark", dataType ="String", value ="描述")
	private String remark;

}

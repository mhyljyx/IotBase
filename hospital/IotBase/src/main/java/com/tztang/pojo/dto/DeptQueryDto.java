package com.tztang.pojo.dto;

import com.tztang.dto.BasePageDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * @description  查询部门
 * @author  tztang
 * @Date 2024-11-27
 */
@Data
@ApiModel("查询部门信息DTO")
public class DeptQueryDto extends BasePageDto {

	@NotBlank(message = "父部门唯一编码不能为空")
	@ApiModelProperty(name ="parentId", dataType ="String", value ="父部门唯一编码")
	private String parentId;

	@Length(max = 255, message = "部门名称长度不能超过255")
	@ApiModelProperty(name ="name", dataType ="String", value ="部门名称")
	private String name;

}

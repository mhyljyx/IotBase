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
 * @description  新增部门
 * @author  tztang
 * @Date 2024-11-27
 */
@Data
@ApiModel("新增部门信息DTO")
public class DeptDto {

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

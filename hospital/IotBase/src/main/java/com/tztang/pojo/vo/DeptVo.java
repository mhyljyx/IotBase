package com.tztang.pojo.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.tztang.data.BaseTableData;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @description  部门信息
 * @author  tztang
 * @Date 2024-11-27
 */
@Data
public class DeptVo extends BaseTableData implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(name ="id", dataType ="String", value ="部门id")
	private String id;

	@ApiModelProperty(name ="openId", dataType ="String", value ="地方三方部门id")
	private String openId;

	@ApiModelProperty(name ="name", dataType ="String", value ="部门名称")
	private String name;

	@ApiModelProperty(name ="parentId", dataType ="String", value ="父级部门id")
	private String parentId;

	@ApiModelProperty(name ="remark", dataType ="String", value ="描述")
	private String remark;

}

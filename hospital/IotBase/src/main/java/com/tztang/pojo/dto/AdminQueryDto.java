package com.tztang.pojo.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import com.tztang.data.BaseTableData;
import com.tztang.dto.BasePageDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @description  查询管理员
 * @author  tztang
 * @Date 2024-11-27
 */
@Data
@TableName("查询管理员DTO")
public class AdminQueryDto extends BasePageDto {

	@ApiModelProperty(name ="account", dataType ="String", value ="账号")
	private String account;

	@ApiModelProperty(name ="name", dataType ="String", value ="管理员名称")
	private String name;

	@ApiModelProperty(name ="status", dataType ="String", value ="状态 0.正常 1.锁定")
	private String status;

}

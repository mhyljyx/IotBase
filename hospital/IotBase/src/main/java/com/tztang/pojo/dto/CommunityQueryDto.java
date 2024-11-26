package com.tztang.pojo.dto;

import com.tztang.dto.BasePageDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * @description  互联网单位信息
 * @author  tztang
 * @Date 2024-11-21
 */
@Data
@ApiModel("查询互联网单位信息DTO")
public class CommunityQueryDto extends BasePageDto {

	@NotBlank(message = "运营服务机构唯一编码不能为空")
	@ApiModelProperty(name ="parentId", dataType ="String", value ="运营服务机构唯一编码")
	private String parentId;

	@Length(max = 32, message = "联网单位名称长度不能超过32")
	@ApiModelProperty(name ="name", dataType ="String", value ="联网单位名称")
	private String name;

}

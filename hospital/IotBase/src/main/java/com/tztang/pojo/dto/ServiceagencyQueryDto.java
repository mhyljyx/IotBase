package com.tztang.pojo.dto;

import com.tztang.dto.BasePageDto;
import com.tztang.page.PageUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * @description  物联网运营服务机构
 * @author  tztang
 * @Date 2024-11-21
 */
@Data
@ApiModel("查询物联网运营服务机构DTO")
public class ServiceAgencyQueryDto extends BasePageDto {

	@Length(max = 32, message = "物联网运营服务机构名称长度不能超过32")
	@ApiModelProperty(name ="name", dataType ="String", value ="物联网运营服务机构名称")
	private String name;

}

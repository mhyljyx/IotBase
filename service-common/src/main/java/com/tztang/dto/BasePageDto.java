package com.tztang.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @program: 
 * @description: 分页dto
 * @author: tztang
 **/
@Data
@ApiModel(value="BasePageDto", description ="分页")
public class BasePageDto {

    @NotNull(message = "页码不能为空")
    @ApiModelProperty(name ="pageNumber", dataType ="Integer", value ="页码",required = true)
    private Integer pageNumber;

    @NotNull(message = "页大小不能为空")
    @ApiModelProperty(name ="pageSize", dataType ="Integer", value ="页大小",required = true)
    private Integer pageSize;

}

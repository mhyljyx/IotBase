package com.tztang.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * UUID生成
 * @author tztang
 * @since 2024-11-26
 */
@Data
@ApiModel("UUID生成DTO")
public class UUIDDto {

    @ApiModelProperty(name ="head", dataType ="String", value ="UUID头部")
    private String head;

    @ApiModelProperty(name ="length", dataType ="Integer", value ="UUID长度")
    private Integer length;

    public UUIDDto(String head, Integer length) {
        this.head = head;
        this.length = length;
    }

}

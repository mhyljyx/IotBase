package com.tztang.dahua.pojo.dto;

import com.tztang.dto.BasePageDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Set;

/**
 * 事件订阅查询
 * @author tztang
 * @since 2024-11-06
 */
@Data
@ApiModel("事件订阅查询参数")
public class EventSubscribeQueryDto extends BasePageDto {

    @ApiModelProperty(name="categories", dataType = "Set<String>", value="事件大类集合")
    private Set<String> categories;

//    @ApiModelProperty(name="startTime", dataType = "Date", value="开始时间")
//    private Date startTime;
//
//    @ApiModelProperty(name="endTime", dataType = "Date", value="结束时间")
//    private Date endTime;

}

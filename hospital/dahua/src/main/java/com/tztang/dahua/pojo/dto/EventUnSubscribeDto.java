package com.tztang.dahua.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * 取消事件订阅
 * @author tztang
 * @since 2024-11-06
 */
@Data
@ApiModel("取消事件订阅参数")
public class EventUnSubscribeDto {

    @NotEmpty(message = "事件订阅id集合不能为空")
    @ApiModelProperty(name="ids", dataType = "List<Integer>", value="事件订阅id集合")
    private List<Integer> ids;

}

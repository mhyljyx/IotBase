package com.tztang.pojo.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @description  接口Vo
 * @author  tztang
 * @Date 2024-12-10
 */
@Data
public class SysApiVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(name ="id", dataType ="Long", value ="接口id")
    private Long id;

    @ApiModelProperty(name ="name", dataType ="String", value ="接口名称")
    private String name;

    @ApiModelProperty(name ="url", dataType ="String", value ="接口路径")
    private String url;

    @ApiModelProperty(name ="method", dataType ="String", value ="请求方法(GET/POST/PUT/DELETE)")
    private String method;

    @ApiModelProperty(name ="description", dataType ="String", value ="描述")
    private String description;

}

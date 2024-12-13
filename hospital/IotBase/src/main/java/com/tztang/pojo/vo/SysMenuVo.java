package com.tztang.pojo.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @description  菜单Vo
 * @author  tztang
 * @Date 2024-12-10
 */
@Data
public class SysMenuVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(name ="id", dataType ="Long", value ="菜单id")
    private Long id;

    @ApiModelProperty(name ="name", dataType ="String", value ="菜单名称")
    private String name;

    @ApiModelProperty(name ="url", dataType ="String", value ="前端路由地址")
    private String url;

    @ApiModelProperty(name ="parentId", dataType ="Integer", value ="父菜单ID（支持菜单树）")
    private Integer parentId;

    @ApiModelProperty(name ="type", dataType ="Integer", value ="类型（0目录，1菜单）")
    private Integer type;

}

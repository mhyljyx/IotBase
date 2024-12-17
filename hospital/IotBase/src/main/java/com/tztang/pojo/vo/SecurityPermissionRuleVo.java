package com.tztang.pojo.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * security动态权限校验
 * @author tztang
 * @since 2024-12-17
 */
@Data
@AllArgsConstructor
public class SecurityPermissionRuleVo {

    @ApiModelProperty(name ="path", dataType ="String", value ="接口路径")
    private String path;

    @ApiModelProperty(name ="roles", dataType ="List<String>", value ="允许访问的角色")
    private List<String> roles;

}

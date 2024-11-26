package com.tztang.pojo.dto;

import com.tztang.dto.BasePageDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 查询用户信息DTO
 * @author tztang
 * @since 2024-11-26
 */
@Data
@ApiModel("查询用户信息DTO")
public class UserQueryDto extends BasePageDto {

    @ApiModelProperty(name ="name", dataType ="String", value ="用户名称")
    private String name;

    @ApiModelProperty(name ="deptId", dataType ="String", value ="部门id")
    private String deptId;

    @ApiModelProperty(name ="role", dataType ="String", value ="角色")
    private String role;

    @ApiModelProperty(name ="type", dataType ="String", value ="人员类型")
    private String type;

    @ApiModelProperty(name ="status", dataType ="String", value ="状态 0.正常 1.锁定")
    private String status;

}

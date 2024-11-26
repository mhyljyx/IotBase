package com.tztang.pojo.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
public class UserVo {

    @ApiModelProperty(name ="id", dataType ="String", value ="用户id")
    private String id;

    @ApiModelProperty(name ="name", dataType ="String", value ="用户姓名")
    private String name;

    @ApiModelProperty(name ="sex", dataType ="String", value ="性别 0女 1男 9未知")
    private String sex;

    @ApiModelProperty(name ="idNumber", dataType ="String", value ="身份证信息")
    private String idNumber;

    @ApiModelProperty(name ="deptId", dataType ="String", value ="所属部门")
    private String deptId;

    @ApiModelProperty(name ="account", dataType ="String", value ="账号")
    private String account;

    @ApiModelProperty(name ="password", dataType ="String", value ="密码")
    private String password;

    @ApiModelProperty(name ="mobilePhone", dataType ="String", value ="手机号")
    private String mobilePhone;

    @ApiModelProperty(name ="phone", dataType ="String", value ="座机号")
    private String phone;

    @ApiModelProperty(name ="address", dataType ="String", value ="地址")
    private String address;

    @ApiModelProperty(name ="role", dataType ="String", value ="角色")
    private String role;

    @ApiModelProperty(name ="type", dataType ="String", value ="人员类型")
    private String type;

    @ApiModelProperty(name ="status", dataType ="String", value ="状态 0.正常 1.锁定")
    private String status;
    
}

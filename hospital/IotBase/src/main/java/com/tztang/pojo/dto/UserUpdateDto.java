package com.tztang.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * 更新用户
 * @author tztang
 * @since 2024-11-26
 */
@Data
@ApiModel("更新用户信息DTO")
public class UserUpdateDto {

    @NotBlank(message = "用户id不能为空")
    @Length(max = 32, message = "用户id长度不能超过32")
    @ApiModelProperty(name ="id", dataType ="String", value ="用户id", required = true)
    private String id;

    @NotBlank(message = "用户姓名不能为空")
    @Length(max = 255, message = "用户姓名长度不能超过255")
    @ApiModelProperty(name ="name", dataType ="String", value ="用户姓名", required = true)
    private String name;

    @NotBlank(message = "性别不能为空")
    @Length(max = 1, min = 1, message = "性别长度必须为1")
    @ApiModelProperty(name ="sex", dataType ="String", value ="性别 0女 1男 9未知", required = true)
    private String sex;

    @Length(max = 64,  message = "身份证信息长度不能超过64")
    @ApiModelProperty(name ="idNumber", dataType ="String", value ="身份证信息")
    private String idNumber;

    @NotBlank(message = "所属部门不能为空")
    @Length(max = 32,  message = "所属部门长度不能超过32")
    @ApiModelProperty(name ="deptId", dataType ="String", value ="所属部门", required = true)
    private String deptId;

    @Length(max = 32,  message = "账号长度不能超过32")
    @ApiModelProperty(name ="account", dataType ="String", value ="账号")
    private String account;

    @Length(max = 32,  message = "密码长度不能超过32")
    @ApiModelProperty(name ="password", dataType ="String", value ="密码")
    private String password;

    @Length(max = 32,  message = "手机号长度不能超过32")
    @Pattern(regexp = "^1[3-9]\\\\d{9}$", message = "手机号格式不正确")
    @ApiModelProperty(name ="mobilePhone", dataType ="String", value ="手机号")
    private String mobilePhone;

    @Length(max = 32,  message = "座机号长度不能超过32")
    @ApiModelProperty(name ="phone", dataType ="String", value ="座机号")
    private String phone;

    @Length(max = 1024,  message = "地址长度不能超过32")
    @ApiModelProperty(name ="address", dataType ="String", value ="地址")
    private String address;

    @NotBlank(message = "角色不能为空")
    @Length(max = 3,  message = "角色长度不能超过3")
    @ApiModelProperty(name ="role", dataType ="String", value ="角色", required = true)
    private String role;

    @NotBlank(message = "人员类型不能为空")
    @Length(max = 3,  message = "人员类型长度不能超过3")
    @ApiModelProperty(name ="type", dataType ="String", value ="人员类型")
    private String type;

}

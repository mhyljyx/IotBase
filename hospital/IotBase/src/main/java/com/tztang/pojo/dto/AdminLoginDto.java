package com.tztang.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * @author tztang
 * @since 2024-12-11
 */
@Data
public class AdminLoginDto {

    @NotBlank(message = "账号不能为空")
    @Length(max = 64, message = "账号长度不能超过64")
    @ApiModelProperty(name ="account", dataType ="String", value ="账号", required = true)
    private String account;

    @NotBlank(message = "密码不能为空")
    @Length(max = 64, message = "密码长度不能超过64")
    @ApiModelProperty(name ="password", dataType ="String", value ="密码", required = true)
    private String password;

}

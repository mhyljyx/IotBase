package com.tztang.dahua.pojo.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 公共订阅参数
 * @author tztang
 */
@Data
public class PublicSubscribeDto {

  /**
   * 接收端ip
   */
  @NotBlank(message = "接收端ip不能为空")
  private String receiveIp;

  /**
   * 接收端端口号
   */
  @NotNull(message = "接收端端口号不能为空")
  private Integer receivePort;

  /**
   * 订阅名称
   */
  @NotBlank(message = "订阅名称不能为空")
  private String name;

}

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

  /**
   * 接收地址(写死)
   * /dahua/receive/api/eventMsg 事件接收地址
   * /dahua/receive/api/businessMsg 业务接收地址
   * /dahua/receive/api/deviceStatusMsg 设备状态接收地址
   */
  @NotBlank(message = "接收地址不能为空")
  private String receiveUri;

  /**
   * 标签
   * 例如：报警事件标签 alarm_event
   *      业务事件标签 business_event
   *      设备状态标签 device_status
   */
  @NotBlank(message = "标签不能为空")
  private String sign;

}

package com.xinran.dahua.pojo.params;

import lombok.Data;

/**
 * 公共订阅参数
 * @author tztang
 */
@Data
public class PublicSubscribeParams {

  /**
   * 接收端ip
   */
  private String receiveIp;

  /**
   * 接收端端口号
   */
  private String receivePort;

}

package com.xinran.dahua.pojo.params;

import lombok.Data;

import java.util.List;

@Data
public class EventSubscribeParams extends PublicSubscribeParams {

  /**
   * 事件大类,参考事件大类枚举 EventCategoryEnums
   */
  private String category;

  /**
   * 类型列表,没有该字段就是订阅所有，空数组代表不订阅
   * 当category是alarm时，为设备或子系统自定义的报警消息，types参考事件类型-报警类型；
   * 当category为business时，为业务事件，一般是子系统上报的业务消息，types参考事件类型-业务类型；
   * 当category为perception时，为移动设备上报的消息，types参考事件类型-感知类类型；
   * 当category为state时，设备状态变化推送消息，无需送
   */
  private List<String> types;

  /**
   * 设备和通道列表,没有该字段就是订阅所有，空数组代表不订阅，参考"基础资源>设备管理"获取的设备编码和通道编码
   */
  private List<String> nodeCodes;

  /**
   * 组织列表,没有该字段就是订阅所有，空数组代表不订阅，参考"基础资源>组织管理"获取的组织编码
   */
  private List<String> orgs;

  /**
   * 报警等级列表，1>2>3 没有该字段就是所有，空数组代表不订阅
   */
  private List<Integer> grades;

}

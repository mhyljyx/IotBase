package com.tztang.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class EventSubscribeDto extends PublicSubscribeDto {

  /**
   * 事件大类,参考事件大类枚举 EventCategoryEnums
   */
  @NotBlank(message = "事件大类不能为空")
  @ApiModelProperty(name="category", dataType = "String", value="事件大类")
  private String category;

  /**
   * 订阅平台
   */
  @NotBlank(message = "订阅平台不能为空")
  @ApiModelProperty(name="platform", dataType = "String", value="订阅平台")
  private String platform;

  /**
   * 类型列表,没有该字段就是订阅所有，空数组代表不订阅
   * 当category是alarm时，为设备或子系统自定义的报警消息，types参考事件类型-报警类型；
   * 当category为business时，为业务事件，一般是子系统上报的业务消息，types参考事件类型-业务类型；
   * 当category为perception时，为移动设备上报的消息，types参考事件类型-感知类类型；
   * 当category为state时，设备状态变化推送消息，无需送
   */
  @NotEmpty(message = "类型列表不能为空")
  @ApiModelProperty(name="types", dataType = "List<String>", value="类型列表")
  private List<String> types;

  /**
   * 设备和通道列表,没有该字段就是订阅所有，空数组代表不订阅，参考"基础资源>设备管理"获取的设备编码和通道编码
   */
  @ApiModelProperty(name="nodeCodes", dataType = "List<String>", value="设备和通道列表")
  private List<String> nodeCodes;

  /**
   * 组织列表,没有该字段就是订阅所有，空数组代表不订阅，参考"基础资源>组织管理"获取的组织编码
   */
  @ApiModelProperty(name="orgs", dataType = "List<String>", value="组织列表")
  private List<String> orgs;

  /**
   * 报警等级列表，1>2>3 没有该字段就是所有，空数组代表不订阅
   */
  @ApiModelProperty(name="grades", dataType = "List<Integer>", value="报警等级列表")
  private List<Integer> grades;

}

package com.tztang.dahua.util;

import cn.hutool.core.util.StrUtil;
import com.dahuatech.hutool.http.Method;
import com.dahuatech.hutool.json.JSONUtil;
import com.dahuatech.icc.event.model.v202011.EventSubscribeDelRequest;
import com.dahuatech.icc.exception.ClientException;
import com.dahuatech.icc.oauth.http.DefaultClient;
import com.dahuatech.icc.oauth.http.IClient;
import com.dahuatech.icc.oauth.http.IccResponse;
import com.dahuatech.icc.oauth.model.v202010.GeneralRequest;
import com.dahuatech.icc.oauth.model.v202010.GeneralResponse;
import com.tztang.dahua.pojo.dto.*;
import com.tztang.dahua.request.EventSubscribeQueryRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class EventSubscribeHelper {

  @Value("${dahua.icc.event.event-subscribe-url}")
  private String eventSubscribeUrl;

  /**
   * 订阅事件
   * 一般接收地址一个monitor信息即可，如果要按照不同的类型，写多个monitor信息即可
   */
  public IccResponse subscribeEvent(EventSubscribeDto params) throws ClientException {
    List<EventDto> eventDtos = new ArrayList<>();
    eventDtos.add(buildEvent(params));
    String alarmMonitor = "http://" + params.getReceiveIp() + ":" + params.getReceivePort() + "/dahua/eventMsg/receive";
    String magic = params.getReceiveIp() + "_" + params.getReceivePort();
    if (StrUtil.isBlank(params.getName())) {
      params.setName(magic);
    }
    SubscribeDto subscribeDto = buildParams(params.getName(), magic, eventDtos, alarmMonitor);
    IClient iClient = new DefaultClient();
    GeneralRequest generalRequest =
      new GeneralRequest(eventSubscribeUrl, Method.POST);
    // 设置参数
    generalRequest.body(JSONUtil.toJsonStr(subscribeDto));
    GeneralResponse response = iClient.doAction(generalRequest, generalRequest.getResponseClass());
    return response;
  }

  /**
   * 订阅事件记录查询示例
   */
  public IccResponse subscribeEventQuery(String category) throws ClientException {
    IClient iClient = new DefaultClient();
    EventSubscribeQueryRequest subscribeRequest = new EventSubscribeQueryRequest(category);
    IccResponse res =
            iClient.doAction(subscribeRequest, subscribeRequest.getResponseClass());
    return res;
  }

  /**
   * 事件取消订阅示例
   */
  public IccResponse eventUnSubscribe(String subscribeName) throws ClientException {
    IClient iClient = new DefaultClient();
    // 事件订阅按`name`字段取消
    EventSubscribeDelRequest subscribeRequest = new EventSubscribeDelRequest(subscribeName);
    IccResponse res = iClient.doAction(subscribeRequest, subscribeRequest.getResponseClass());
    return res;
  }

  /**
   * 参数设置可自行调整，默认是订阅报警+事件、本机+下级
   * @return
   */
  private EventDto buildEvent(EventSubscribeDto params){
    EventDto eventDto = new EventDto();
    eventDto.setAuthorities(buildAuthority(params.getTypes(), params.getNodeCodes(), params.getOrgs()));//设为空是订阅所有
    eventDto.setCategory(params.getCategory());
    eventDto.setGrades(params.getGrades());
    return eventDto;
  }

  private SubscribeDto buildParams(String name, String magic, List<EventDto> eventDtos, String monitor){
    List<MonitorDto> monitorDtos = new ArrayList<>();
    MonitorDto monitorDto = new MonitorDto();
    monitorDto.setEvents(eventDtos);
    monitorDto.setMonitor(monitor);//第三方接收URL
    monitorDtos.add(monitorDto);

    SubsystemDto subsystemDto = new SubsystemDto();
    subsystemDto.setMagic(magic);
    subsystemDto.setName(name);

    SubscribeParamDto subscribeParamDto = new SubscribeParamDto();
    subscribeParamDto.setSubsystem(subsystemDto);
    subscribeParamDto.setMonitors(monitorDtos);

    SubscribeDto subscribeDto = new SubscribeDto();
    subscribeDto.setParam(subscribeParamDto);
    return subscribeDto;
  }

  /**
   *  orgs与nodeCodes并集，即或的概念
   *  只订阅orgs,nodeCodes需new 空数组；
   *  只订阅nodeCodes,orgs需new 空数组；(二者是或的取值)
   * @param types
   * @param nodeCodes
   * @param orgs
   * @return
   */
  private List<AuthorityDto> buildAuthority(List<String> types, List<String> nodeCodes, List<String> orgs){
    List<AuthorityDto> list = new ArrayList<>();
    AuthorityDto authorityDto = new AuthorityDto();
    authorityDto.setNodeCodes(nodeCodes);//调设备/通道分页查询、设备数获取列表
    authorityDto.setOrgs(orgs);//调组织分页查询或组织树
    authorityDto.setTypes(types);//指定订阅报警类型，业务类型、感知类型
    list.add(authorityDto);
    return list;
  }


}

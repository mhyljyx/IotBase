package com.xinran.dahua.util;

import com.dahuatech.hutool.http.Method;
import com.dahuatech.hutool.json.JSONUtil;
import com.dahuatech.icc.exception.ClientException;
import com.dahuatech.icc.oauth.http.DefaultClient;
import com.dahuatech.icc.oauth.http.IClient;
import com.dahuatech.icc.oauth.model.v202010.GeneralRequest;
import com.dahuatech.icc.oauth.model.v202010.GeneralResponse;
import com.xinran.dahua.model.event.*;
import com.xinran.dahua.pojo.params.EventSubscribeParams;
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
   * 订阅报警事件
   * 一般接收地址一个monitor信息即可，如果要按照不同的类型，写多个monitor信息即可
   */
  public GeneralResponse subscribeAlarm(EventSubscribeParams params) throws ClientException {
    List<EventVo> eventVos = new ArrayList<>();
    eventVos.add(buildEvent(params));
    String alarmMonitor = "http://" + params.getReceiveIp() + ":" + params.getReceivePort() + "/dahua/eventMsg/receive";
    String magic = params.getReceiveIp() + "_" + params.getReceivePort() + "_alarm";
    SubscribeVo subscribeVo = buildParams(magic, eventVos, alarmMonitor);
    IClient iClient = new DefaultClient();
    GeneralRequest generalRequest =
      new GeneralRequest(eventSubscribeUrl, Method.POST);
    // 设置参数
    generalRequest.body(JSONUtil.toJsonStr(subscribeVo));
    System.out.println(JSONUtil.toJsonStr(subscribeVo));
    GeneralResponse response = iClient.doAction(generalRequest, generalRequest.getResponseClass());
    return response;
  }

  /**
   * 参数设置可自行调整，默认是订阅报警+事件、本机+下级
   * @return
   */
  private EventVo buildEvent(EventSubscribeParams params){
    EventVo eventVo = new EventVo();
    eventVo.setAuthorities(buildAuthority(params.getTypes(), params.getNodeCodes(), params.getOrgs()));//设为空是订阅所有
    eventVo.setCategory(params.getCategory());
    eventVo.setGrades(params.getGrades());
    return eventVo;
  }

  private SubscribeVo buildParams(String magic, List<EventVo> eventVos, String monitor){
    List<MonitorVo> monitorVos = new ArrayList<>();
    MonitorVo monitorVo = new MonitorVo();
    monitorVo.setEvents(eventVos);
    monitorVo.setMonitor(monitor);//第三方接收URL
    monitorVos.add(monitorVo);

    SubsystemVo subsystemVo = new SubsystemVo();
    subsystemVo.setMagic(magic);
    subsystemVo.setName(subsystemVo.getMagic());//默认与magic一样

    SubscribeParamVo subscribeParamVo = new SubscribeParamVo();
    subscribeParamVo.setSubsystem(subsystemVo);
    subscribeParamVo.setMonitors(monitorVos);

    SubscribeVo subscribeVo = new SubscribeVo();
    subscribeVo.setParam(subscribeParamVo);
    return subscribeVo;
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
  private List<AuthorityVo> buildAuthority(List<String> types, List<String> nodeCodes, List<String>orgs){
    List<AuthorityVo> list = new ArrayList<>();
    AuthorityVo authorityVo = new AuthorityVo();
    authorityVo.setNodeCodes(nodeCodes);//调设备/通道分页查询、设备数获取列表
    authorityVo.setOrgs(orgs);//调组织分页查询或组织树
    authorityVo.setTypes(types);//指定订阅报警类型，业务类型、感知类型
    list.add(authorityVo);
    return list;
  }


}

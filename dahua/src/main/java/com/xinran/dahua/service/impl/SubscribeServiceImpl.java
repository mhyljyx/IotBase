package com.xinran.dahua.service.impl;

import com.dahuatech.icc.exception.ClientException;
import com.dahuatech.icc.oauth.model.v202010.GeneralResponse;
import com.xinran.common.util.Result;
import com.xinran.dahua.enums.EventCategoryEnums;
import com.xinran.dahua.enums.TypeFireAlarmEnums;
import com.xinran.dahua.pojo.params.EventSubscribeParams;
import com.xinran.dahua.pojo.params.PublicSubscribeParams;
import com.xinran.dahua.service.SubscribeService;
import com.xinran.dahua.util.EventSubscribeHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class SubscribeServiceImpl implements SubscribeService {

  @Resource
  private EventSubscribeHelper eventSubscribeHelper;

  @Override
  public Result eventSubscribe(EventSubscribeParams params) throws ClientException {
    GeneralResponse response = eventSubscribeHelper.subscribeAlarm(params);
    log.info("自定义事件订阅:{}", response.toString());
    if ("0".equals(response.getCode())) {
      return Result.errParam(response.getErrMsg());
    }
    return Result.success(response.getResult());
  }

  @Override
  public Result fireAlarmSubscribe(PublicSubscribeParams params) {
    EventSubscribeParams eventSubscribeParams = new EventSubscribeParams();
    params.setReceiveIp(params.getReceiveIp());
    params.setReceivePort(params.getReceivePort());
    eventSubscribeParams.setCategory(EventCategoryEnums.alarm.code);
    eventSubscribeParams.setTypes(TypeFireAlarmEnums.values().);
    return null;
  }

  @Override
  public Result securityMachineSubscribe(PublicSubscribeParams params) {
    EventSubscribeParams eventSubscribeParams = new EventSubscribeParams();
    return null;
  }

}

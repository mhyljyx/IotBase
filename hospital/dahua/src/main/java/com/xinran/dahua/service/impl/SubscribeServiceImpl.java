package com.xinran.dahua.service.impl;

import com.dahuatech.icc.exception.ClientException;
import com.dahuatech.icc.oauth.http.IccResponse;
import com.xinran.util.Result;
import com.xinran.dahua.enums.EventCategoryEnums;
import com.xinran.dahua.enums.TypeFireAlarmEnums;
import com.xinran.dahua.enums.TypeSecurityBusinessEnums;
import com.xinran.dahua.pojo.params.EventSubscribeParams;
import com.xinran.dahua.pojo.params.PublicSubscribeParams;
import com.xinran.dahua.service.SubscribeService;
import com.xinran.dahua.util.EventSubscribeHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class SubscribeServiceImpl implements SubscribeService {

  @Resource
  private EventSubscribeHelper eventSubscribeHelper;

  @Override
  public Result eventSubscribe(EventSubscribeParams params) throws ClientException {
    IccResponse res = eventSubscribeHelper.subscribeEvent(params);
    log.info("自定义事件订阅:{}", res.toString());
    if (!"0".equals(res.getCode())) {
      return Result.fail(res.getErrMsg());
    }
    return Result.success(res.getResult());
  }

  @Override
  public Result fireAlarmSubscribe(PublicSubscribeParams params) throws ClientException {
    EventSubscribeParams eventSubscribeParams = new EventSubscribeParams();
    eventSubscribeParams.setReceiveIp(params.getReceiveIp());
    eventSubscribeParams.setReceivePort(params.getReceivePort());
    eventSubscribeParams.setCategory(EventCategoryEnums.alarm.code);
    eventSubscribeParams.setTypes(TypeFireAlarmEnums.getCodes());
    IccResponse res = eventSubscribeHelper.subscribeEvent(eventSubscribeParams);
    log.info("消防报警事件订阅:{}", res.toString());
    if (!"0".equals(res.getCode())) {
      return Result.fail(res.getErrMsg());
    }
    return Result.success(res.getResult());
  }

  @Override
  public Result securityBusinessSubscribe(PublicSubscribeParams params) throws ClientException {
    EventSubscribeParams eventSubscribeParams = new EventSubscribeParams();
    eventSubscribeParams.setReceiveIp(params.getReceiveIp());
    eventSubscribeParams.setReceivePort(params.getReceivePort());
    eventSubscribeParams.setCategory(EventCategoryEnums.business.code);
    eventSubscribeParams.setTypes(TypeSecurityBusinessEnums.getCodes());
    IccResponse res = eventSubscribeHelper.subscribeEvent(eventSubscribeParams);
    log.info("安检业务事件订阅:{}", res.toString());
    if (!"0".equals(res.getCode())) {
      return Result.fail(res.getErrMsg());
    }
    return Result.success(res.getResult());
  }

  @Override
  public Result eventSubscribeQuery(String category) throws ClientException {
    IccResponse res = eventSubscribeHelper.subscribeEventQuery(category);
    log.info("事件订阅查询:{}", res.toString());
    if (!"0".equals(res.getCode())) {
      return Result.fail(res.getErrMsg());
    }
    return Result.success(res.getResult());
  }

  @Override
  public Result eventUnSubscribe(List<String> subscribeNames) {
    subscribeNames.forEach(subscribeName -> {
      try {
        IccResponse res = eventSubscribeHelper.eventUnSubscribe(subscribeName);
        log.info("事件订阅取消:{}", res.toString());
        //todo 后续更新数据库
      } catch (ClientException e) {
        e.printStackTrace();
      }
    });
    return Result.success();
  }

}

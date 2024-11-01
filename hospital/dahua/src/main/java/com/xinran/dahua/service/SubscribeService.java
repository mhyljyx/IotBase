package com.xinran.dahua.service;

import com.dahuatech.icc.exception.ClientException;
import com.xinran.util.Result;
import com.xinran.dahua.pojo.params.EventSubscribeParams;
import com.xinran.dahua.pojo.params.PublicSubscribeParams;

import java.util.List;

/**
 * 事件订阅
 * @author tztang
 */
public interface SubscribeService {

  //事件订阅
  Result eventSubscribe(EventSubscribeParams params) throws ClientException;

  //消防报警事件订阅
  Result fireAlarmSubscribe(PublicSubscribeParams params) throws ClientException;

  //安检业务订阅
  Result securityBusinessSubscribe(PublicSubscribeParams params) throws ClientException;

  //事件订阅查询
  Result eventSubscribeQuery(String category) throws ClientException;

  //取消事件订阅
  Result eventUnSubscribe(List<String> subscribeNames);

}

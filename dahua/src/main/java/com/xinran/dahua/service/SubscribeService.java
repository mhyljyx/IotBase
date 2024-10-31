package com.xinran.dahua.service;

import com.dahuatech.icc.exception.ClientException;
import com.xinran.common.util.Result;
import com.xinran.dahua.pojo.params.EventSubscribeParams;
import com.xinran.dahua.pojo.params.PublicSubscribeParams;

/**
 * 事件订阅
 * @author tztang
 */
public interface SubscribeService {

  //事件订阅
  Result eventSubscribe(EventSubscribeParams params) throws ClientException;

  //消防报警事件订阅
  Result fireAlarmSubscribe(PublicSubscribeParams params);

  //安检业务订阅
  Result securityMachineSubscribe(PublicSubscribeParams params);

}

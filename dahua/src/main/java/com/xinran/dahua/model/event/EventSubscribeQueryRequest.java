package com.xinran.dahua.model.event;

import com.dahuatech.hutool.http.Method;
import com.dahuatech.icc.event.constant.EventConstant;
import com.dahuatech.icc.exception.ClientException;
import com.dahuatech.icc.oauth.http.AbstractIccRequest;

/**
 * 事件取消订阅请求
 * 234271
 */
public class EventSubscribeQueryRequest extends AbstractIccRequest<EventSubscribeQueryResponse> {
  /** 事件订阅查询 */
  public static final String EVENT_URL_SUBSCRIBE_QUERY = "/evo-apigw/evo-event/%s/subscribe/subscribe-list";

  public EventSubscribeQueryRequest(String category) throws ClientException {
    super(EventConstant.url(EVENT_URL_SUBSCRIBE_QUERY +  "?monitorType=url&category=" + category), Method.GET);
  }

  @Override
  public Class<EventSubscribeQueryResponse> getResponseClass() {
    return EventSubscribeQueryResponse.class;
  }
}

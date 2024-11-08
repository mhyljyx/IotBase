package com.tztang.dahua.service;

import com.dahuatech.icc.exception.ClientException;
import com.tztang.page.PageVo;
import com.tztang.common.ApiResponse;
import com.tztang.dahua.pojo.dto.EventSubscribeDto;
import com.tztang.dahua.pojo.dto.EventSubscribeQueryDto;
import com.tztang.dahua.pojo.dto.EventUnSubscribeDto;
import com.tztang.dahua.pojo.dto.PublicSubscribeDto;
import com.tztang.dahua.pojo.vo.EventSubscribeQueryVo;

/**
 * 事件订阅
 * @author tztang
 */
public interface SubscribeService {

  //事件订阅
  ApiResponse<String> eventSubscribe(EventSubscribeDto dto) throws ClientException;

  //消防报警事件订阅
  ApiResponse<String> fireAlarmSubscribe(PublicSubscribeDto dto) throws ClientException;

  //安检业务订阅
  ApiResponse<String> securityBusinessSubscribe(PublicSubscribeDto dto) throws ClientException;

  //设备状态信息订阅
  ApiResponse<String> deviceStatusSubscribe(PublicSubscribeDto dto) throws ClientException;

  //事件订阅查询
  ApiResponse<PageVo<EventSubscribeQueryVo>> eventSubscribeQuery(EventSubscribeQueryDto dto);

  //取消事件订阅
  ApiResponse<String> eventUnSubscribe(EventUnSubscribeDto dto);

}

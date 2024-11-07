package com.tztang.haikang.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson2.JSON;
import com.tztang.util.ApiResponse;
import com.tztang.haikang.pojo.params.EventSubscribeParams;
import com.tztang.haikang.service.SubscribeService;
import com.tztang.haikang.util.HaiKangRequestHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class SubscribeServiceImpl implements SubscribeService {

    @Value("${haikang.isc.event.event-subscribe-url}")
    private String eventSubscribeUrl;
    @Value("${haikang.isc.event.event-subscribe-query-url}")
    private String eventSubscribeQueryUrl;

    @Resource
    private HaiKangRequestHelper haiKangRequestHelper;

    @Override
    public ApiResponse eventSubscribe(EventSubscribeParams params) {
        if (CollUtil.isEmpty(params.getEventTypes())) {
          return ApiResponse.errParam("事件类型[eventTypes]不能为空");
        } else if (StrUtil.isBlank(params.getEventDest())) {
          return ApiResponse.errParam("事件的接收地址[eventDest]不能为空");
        }
        String res = haiKangRequestHelper.post(eventSubscribeUrl, JSON.toJSONString(params));
        if ("0".equals(JSON.parseObject(res).get("code")))
          return ApiResponse.success(res);
        return ApiResponse.errParam(res);
    }

    @Override
    public ApiResponse eventSubscribeQuery() {
      String res = haiKangRequestHelper.post(eventSubscribeQueryUrl, null);
      if ("0".equals(JSON.parseObject(res).get("code")))
        return ApiResponse.success(res);
      return ApiResponse.errParam(res);
    }

}

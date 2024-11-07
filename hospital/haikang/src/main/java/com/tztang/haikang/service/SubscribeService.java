package com.tztang.haikang.service;

import com.tztang.common.ApiResponse;
import com.tztang.haikang.pojo.params.EventSubscribeParams;

/**
 * 订阅服务
 * @author tztang
 * @since 2024/10/28
 */
public interface SubscribeService {

    //事件订阅
    ApiResponse eventSubscribe(EventSubscribeParams params);

    //事件订阅查询
    ApiResponse eventSubscribeQuery();

}

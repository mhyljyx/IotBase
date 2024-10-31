package com.xinran.haikang.service;

import com.xinran.common.util.Result;
import com.xinran.haikang.pojo.params.EventSubscribeParams;

/**
 * 订阅服务
 * @author tztang
 * @since 2024/10/28
 */
public interface SubscribeService {

    //事件订阅
    Result eventSubscribe(EventSubscribeParams params);

    //事件订阅查询
    Result eventSubscribeQuery();

}

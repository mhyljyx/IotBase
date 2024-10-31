package com.xinran.haikang.service.impl;

import com.alibaba.fastjson2.JSON;
import com.xinran.common.util.Result;
import com.xinran.haikang.pojo.params.IUAlarmEventEventParams;
import com.xinran.haikang.service.AlarmEventService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class AlarmEventServiceImpl implements AlarmEventService {

    @Override
    public Result intrusionAlarmReceive(String data) {
        log.info("入侵报警事件接收:{}", data);
        List<IUAlarmEventEventParams> events = JSON.parseObject(data).getJSONObject("params").getJSONArray("events").toList(IUAlarmEventEventParams.class);
        return Result.success(events);
    }

    @Override
    public Result urgentAlarmReceive(String data) {
        log.info("紧急报警事件接收:{}", data);
        List<IUAlarmEventEventParams> events = JSON.parseObject(data).getJSONArray("events").toList(IUAlarmEventEventParams.class);
        return Result.success(events);
    }

}

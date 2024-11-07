package com.tztang.haikang.service;

import com.tztang.common.ApiResponse;
import com.tztang.haikang.pojo.params.IUAlarmEventEventParams;

import java.util.List;

/**
 * 报警事件接收
 * @author tztang
 * @since 2023/11/27
 */
public interface AlarmEventService {

    //入侵报警接收
    ApiResponse<List<IUAlarmEventEventParams>> intrusionAlarmReceive(String data);

    //紧急报警接收
    ApiResponse<List<IUAlarmEventEventParams>> urgentAlarmReceive(String data);

}

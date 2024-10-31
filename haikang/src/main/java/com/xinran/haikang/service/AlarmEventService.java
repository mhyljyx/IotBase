package com.xinran.haikang.service;

import com.xinran.common.util.Result;

/**
 * 报警事件接收
 * @author tztang
 * @since 2023/11/27
 */
public interface AlarmEventService {

    //入侵报警接收
    Result intrusionAlarmReceive(String data);

    //紧急报警接收
    Result urgentAlarmReceive(String data);

}

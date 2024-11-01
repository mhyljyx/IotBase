package com.xinran.haikang.service;

import com.xinran.util.Result;

/**
 * 设备查询
 * @author tztang
 * @since 2024/10/28
 */
public interface DeviceService {

    //紧急报警设备查询
    Result urgentAlarmDeviceQuery(int pageNo, int pageSize);

}

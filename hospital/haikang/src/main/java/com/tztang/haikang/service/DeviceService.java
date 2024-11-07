package com.tztang.haikang.service;

import com.tztang.util.ApiResponse;

/**
 * 设备查询
 * @author tztang
 * @since 2024/10/28
 */
public interface DeviceService {

    //紧急报警设备查询
    ApiResponse urgentAlarmDeviceQuery(int pageNo, int pageSize);

}

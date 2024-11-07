package com.tztang.haikang.service;

import com.tztang.util.ApiResponse;

/**
 * 主机查询
 * @author tztang
 * @since 2024-10-28
 */
public interface HostService {

    //入侵报警主机查询
    ApiResponse intrusionAlarmHostQuery(int pageNo, int pageSize);

}

package com.xinran.haikang.service;

import com.xinran.common.util.Result;

/**
 * 主机查询
 * @author tztang
 * @since 2024-10-28
 */
public interface HostService {

    //入侵报警主机查询
    Result intrusionAlarmHostQuery(int pageNo, int pageSize);

}

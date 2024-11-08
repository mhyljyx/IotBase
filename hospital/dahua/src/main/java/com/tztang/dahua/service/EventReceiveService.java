package com.tztang.dahua.service;

import com.tztang.common.ApiResponse;

import java.text.ParseException;

public interface EventReceiveService {

    //消防事件接收
    ApiResponse<String> fireAlarmReceive(String data) throws ParseException;

    //业务事件接收
    ApiResponse<String> businessEventReceive(String data) throws ParseException;

    //设备状态信息接收
    ApiResponse<String> deviceStatusReceive(String data) throws ParseException;

}

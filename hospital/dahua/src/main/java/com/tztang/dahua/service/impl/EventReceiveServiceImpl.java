package com.tztang.dahua.service.impl;

import com.tztang.common.ApiResponse;
import com.tztang.dahua.service.EventReceiveService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.ParseException;

@Slf4j
@Service
public class EventReceiveServiceImpl implements EventReceiveService {

    @Override
    public ApiResponse<String> fireAlarmReceive(String data) throws ParseException {
        return null;
    }

    @Override
    public ApiResponse<String> businessEventReceive(String data) throws ParseException {
        return null;
    }

    @Override
    public ApiResponse<String> deviceStatusReceive(String data) throws ParseException {
        return null;
    }

}

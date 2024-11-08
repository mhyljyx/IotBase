package com.tztang.dahua.controller;

import com.tztang.common.ApiResponse;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Api(tags = "事件订阅接收相关接口")
@Validated
@RestController
@RequestMapping("/dahua/receive/api/")
public class EventReceiveController {

    @PostMapping("eventMsg")
    public ApiResponse<String> eventMsg(@RequestBody String data) {
        return ApiResponse.ok();
    }

    @PostMapping("businessMsg")
    public ApiResponse<String> businessMsg(@RequestBody String data) {
        return ApiResponse.ok();
    }

    @PostMapping("deviceStatusMsg")
    public ApiResponse<String> deviceStatusMsg(@RequestBody String data) {
        return ApiResponse.ok();
    }

}

package com.tztang.dahua.controller;

import com.dahuatech.icc.exception.ClientException;
import com.tztang.page.PageVo;
import com.tztang.common.ApiResponse;
import com.tztang.dahua.pojo.dto.EventSubscribeDto;
import com.tztang.dahua.pojo.dto.EventSubscribeQueryDto;
import com.tztang.dahua.pojo.dto.EventUnSubscribeDto;
import com.tztang.dahua.pojo.dto.PublicSubscribeDto;
import com.tztang.dahua.pojo.vo.EventSubscribeQueryVo;
import com.tztang.dahua.service.SubscribeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@Slf4j
@Api(tags = "事件订阅相关接口")
@Validated
@RestController
@RequestMapping("/dahua/subscribe/api/")
public class EventSubscribeController {

    @Resource
    private SubscribeService subscribeService;

    @ApiOperation("事件订阅")
    @PostMapping("eventSubscribe")
    public ApiResponse<String> eventSubscribe(@Valid @RequestBody EventSubscribeDto params) throws ClientException {
        return subscribeService.eventSubscribe(params);
    }

    @ApiOperation("消防报警事件订阅")
    @PostMapping("fireAlarmSubscribe")
    public ApiResponse<String> fireAlarmSubscribe(@Valid @RequestBody PublicSubscribeDto params) throws ClientException {
        return subscribeService.fireAlarmSubscribe(params);
    }

    @ApiOperation("安检业务订阅")
    @PostMapping("securityBusinessSubscribe")
    public ApiResponse<String> securityBusinessSubscribe(@Valid @RequestBody PublicSubscribeDto params) throws ClientException {
        return subscribeService.securityBusinessSubscribe(params);
    }

    @ApiOperation("事件订阅查询")
    @PostMapping("eventSubscribeQuery")
    public ApiResponse<PageVo<EventSubscribeQueryVo>> eventSubscribeQuery(@Valid @RequestBody EventSubscribeQueryDto params) {
        return subscribeService.eventSubscribeQuery(params);
    }

    @ApiOperation("取消事件订阅")
    @PostMapping("eventUnSubscribe")
    public ApiResponse<String> eventUnSubscribe(@Valid @RequestBody EventUnSubscribeDto params) {
        return subscribeService.eventUnSubscribe(params);
    }

}

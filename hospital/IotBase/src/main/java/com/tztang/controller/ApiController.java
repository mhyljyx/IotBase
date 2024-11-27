package com.tztang.controller;

import com.tztang.common.ApiResponse;
import com.tztang.config.ApiScanner;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@Api(tags = "系统接口")
@Validated
@RestController
@RequestMapping("/common/sys/api/")
public class ApiController {

    @Resource
    private ApiScanner apiScanner;

    @ApiOperation(value = "系统接口同步")
    @PostMapping("/sync-sysApi")
    public ApiResponse<Void> syncSysApi() {
        apiScanner.scanApis();
        return ApiResponse.ok();
    }

}

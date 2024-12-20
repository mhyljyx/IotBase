package com.tztang.controller;

import com.tztang.common.ApiResponse;
import com.tztang.page.PageVo;
import com.tztang.pojo.dto.ServiceAgencyDto;
import com.tztang.pojo.dto.ServiceAgencyQueryDto;
import com.tztang.pojo.dto.ServiceAgencyUpdateDto;
import com.tztang.pojo.vo.ServiceAgencyVo;
import com.tztang.service.ServiceAgencyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Slf4j
@Api(tags = "物联网运营服务机构接口")
@Validated
@RestController
@RequestMapping("/common/serviceagency/api/")
public class ServiceAgencyController {

    @Resource
    private ServiceAgencyService serviceagencyService;

    @ApiOperation(value = "新增物联网运营服务机构")
    @PostMapping(value = "/create")
    public ApiResponse<Void> create(@Valid @RequestBody ServiceAgencyDto serviceagencyDto){
        serviceagencyService.create(serviceagencyDto);
        return ApiResponse.ok();
    }

    @ApiOperation(value = "删除物联网运营服务机构")
    @DeleteMapping(value = "/delete")
    public ApiResponse<Void> delete(@NotEmpty(message = "物联网运营服务机构编码不能为空") @RequestBody Set<String> ids){
        serviceagencyService.delete(ids);
        return ApiResponse.ok();
    }

    @ApiOperation(value = "修改物联网运营服务机构")
    @PostMapping(value = "/update")
    public ApiResponse<Void> update(@Valid @RequestBody ServiceAgencyUpdateDto serviceagencyUpdateDto){
        serviceagencyService.update(serviceagencyUpdateDto);
        return ApiResponse.ok();
    }

    @ApiOperation(value = "查询物联网运营服务机构")
    @PostMapping(value = "/query")
    public ApiResponse<PageVo<ServiceAgencyVo>> query(@Valid @RequestBody ServiceAgencyQueryDto serviceagencyQueryDto){
        return ApiResponse.ok(serviceagencyService.query(serviceagencyQueryDto));
    }

}

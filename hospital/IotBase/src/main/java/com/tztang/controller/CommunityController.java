package com.tztang.controller;

import com.tztang.common.ApiResponse;
import com.tztang.page.PageVo;
import com.tztang.pojo.dto.*;
import com.tztang.pojo.vo.CommunityVo;
import com.tztang.service.CommunityService;
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
@Api(tags = "互联网单位接口")
@Validated
@RestController
@RequestMapping("/common/community/api/")
public class CommunityController {

    @Resource
    private CommunityService communityService;

    @ApiOperation(value = "新增物联网运营服务机构")
    @PostMapping(value = "/create")
    public ApiResponse<Void> create(@Valid @RequestBody CommunityDto communityDto){
        communityService.create(communityDto);
        return ApiResponse.ok();
    }

    @ApiOperation(value = "删除互联网单位信息")
    @DeleteMapping(value = "/delete")
    public ApiResponse<Void> delete(@NotEmpty(message = "互联网单位id不能为空") @RequestBody Set<Integer> ids){
        communityService.delete(ids);
        return ApiResponse.ok();
    }

    @ApiOperation(value = "修改互联网单位信息")
    @PostMapping(value = "/update")
    public ApiResponse<Void> update(@Valid @RequestBody CommunityUpdateDto communityUpdateDto){
        communityService.update(communityUpdateDto);
        return ApiResponse.ok();
    }

    @ApiOperation(value = "查询互联网单位信息")
    @PostMapping(value = "/query")
    public ApiResponse<PageVo<CommunityVo>> query(@Valid @RequestBody CommunityQueryDto communityQueryDto){
        return ApiResponse.ok(communityService.query(communityQueryDto));
    }

}

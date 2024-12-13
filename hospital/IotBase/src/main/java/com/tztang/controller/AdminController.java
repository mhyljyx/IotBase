package com.tztang.controller;

import com.tztang.common.ApiResponse;
import com.tztang.page.PageVo;
import com.tztang.pojo.dto.*;
import com.tztang.pojo.vo.AdminVo;
import com.tztang.pojo.vo.UserVo;
import com.tztang.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.Map;
import java.util.Set;

@Slf4j
@Api(tags = "管理员接口")
@Validated
@RestController
@RequestMapping("/common/admin/api/")
public class AdminController {

    @Resource
    private AdminService adminService;

    @ApiOperation(value = "管理员登录")
    @PostMapping(value = "login")
    public ApiResponse<Map<String, Object>> login(@Valid @RequestBody AdminLoginDto adminLoginDto){
        return ApiResponse.ok(adminService.login(adminLoginDto));
    }

    @ApiOperation(value = "新增管理员")
    @PostMapping(value = "create")
    public ApiResponse<Void> create(@Valid @RequestBody AdminDto adminDto){
        adminService.create(adminDto);
        return ApiResponse.ok();
    }

    @ApiOperation(value = "删除管理员")
    @DeleteMapping(value = "delete")
    public ApiResponse<Void> delete(@NotEmpty(message = "管理员id不能为空") @RequestBody Set<String> ids){
        adminService.delete(ids);
        return ApiResponse.ok();
    }

    @ApiOperation(value = "修改管理员")
    @PostMapping(value = "update")
    public ApiResponse<Void> update(@Valid @RequestBody AdminUpdateDto adminUpdateDto){
        adminService.update(adminUpdateDto);
        return ApiResponse.ok();
    }

    @ApiOperation(value = "查询管理员")
    @PostMapping(value = "query")
    public ApiResponse<PageVo<AdminVo>> query(@Valid @RequestBody AdminQueryDto adminQueryDto){
        return ApiResponse.ok(adminService.query(adminQueryDto));
    }

}

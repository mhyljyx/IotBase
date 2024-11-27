package com.tztang.controller;

import com.tztang.common.ApiResponse;
import com.tztang.page.PageVo;
import com.tztang.pojo.dto.*;
import com.tztang.pojo.vo.UserVo;
import com.tztang.service.UserService;
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
@Api(tags = "用户接口")
@Validated
@RestController
@RequestMapping("/common/user/api/")
public class UserController {

    @Resource
    private UserService userService;

    @ApiOperation(value = "新增用户")
    @PostMapping(value = "/create")
    public ApiResponse<Void> create(@Valid @RequestBody UserDto userDto){
        userService.create(userDto);
        return ApiResponse.ok();
    }

    @ApiOperation(value = "删除用户")
    @DeleteMapping(value = "/delete")
    public ApiResponse<Void> delete(@NotEmpty(message = "用户id不能为空") @RequestBody Set<String> ids){
        userService.delete(ids);
        return ApiResponse.ok();
    }

    @ApiOperation(value = "修改用户")
    @PostMapping(value = "/update")
    public ApiResponse<Void> update(@Valid @RequestBody UserUpdateDto userUpdateDto){
        userService.update(userUpdateDto);
        return ApiResponse.ok();
    }

    @ApiOperation(value = "查询用户")
    @PostMapping(value = "/query")
    public ApiResponse<PageVo<UserVo>> query(@Valid @RequestBody UserQueryDto userQueryDto){
        return ApiResponse.ok(userService.query(userQueryDto));
    }

}

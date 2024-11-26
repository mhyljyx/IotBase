package com.tztang.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tztang.page.PageVo;
import com.tztang.pojo.dto.UserDto;
import com.tztang.pojo.dto.UserQueryDto;
import com.tztang.pojo.dto.UserUpdateDto;
import com.tztang.pojo.entity.UserDo;
import com.tztang.pojo.vo.UserVo;

import java.util.Set;

public interface UserService extends IService<UserDo> {

    //新增用户
    void create(UserDto dto);

    //删除用户
    void delete(Set<String> ids);

    //修改用户
    void update(UserUpdateDto dto);

    //查询用户
    PageVo<UserVo> query(UserQueryDto dto);

}

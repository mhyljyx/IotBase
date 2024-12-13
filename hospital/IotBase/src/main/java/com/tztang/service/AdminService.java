package com.tztang.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tztang.page.PageVo;
import com.tztang.pojo.dto.AdminDto;
import com.tztang.pojo.dto.AdminLoginDto;
import com.tztang.pojo.dto.AdminQueryDto;
import com.tztang.pojo.dto.AdminUpdateDto;
import com.tztang.pojo.entity.AdminDo;
import com.tztang.pojo.vo.AdminVo;

import java.util.Map;
import java.util.Set;

public interface AdminService extends IService<AdminDo> {

    Map<String, Object> login(AdminLoginDto dto);

    //新增管理员
    void create(AdminDto dto);

    //删除管理员
    void delete(Set<String> ids);

    //修改管理员
    void update(AdminUpdateDto dto);

    //查询管理员
    PageVo<AdminVo> query(AdminQueryDto dto);

}

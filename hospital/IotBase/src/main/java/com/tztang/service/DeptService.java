package com.tztang.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tztang.page.PageVo;
import com.tztang.pojo.dto.DeptDto;
import com.tztang.pojo.dto.DeptQueryDto;
import com.tztang.pojo.dto.DeptUpdateDto;
import com.tztang.pojo.entity.DeptDo;
import com.tztang.pojo.vo.DeptVo;

import java.util.Set;

public interface DeptService extends IService<DeptDo> {

    //新增部门
    void create(DeptDto dto);

    //删除部门
    void delete(Set<String> ids);

    //修改部门
    void update(DeptUpdateDto dto);

    //查询部门
    PageVo<DeptVo> query(DeptQueryDto dto);

}

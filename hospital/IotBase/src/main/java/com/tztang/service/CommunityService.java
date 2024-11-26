package com.tztang.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tztang.page.PageVo;
import com.tztang.pojo.dto.*;
import com.tztang.pojo.entity.CommunityDo;
import com.tztang.pojo.vo.CommunityVo;
import com.tztang.pojo.vo.ServiceagencyVo;

import java.util.Set;

/**
 * @description  互联网单位信息service
 * @author  tztang
 * @Date 2024-11-25
 */
public interface CommunityService extends IService<CommunityDo> {

    //新增互联网单位信息
    void create(CommunityDto dto);

    //删除互联网单位信息
    void delete(Set<Integer> ids);

    //修改互联网单位信息
    void update(CommunityUpdateDto dto);

    //查询互联网单位信息
    PageVo<CommunityVo> query(CommunityQueryDto dto);

}

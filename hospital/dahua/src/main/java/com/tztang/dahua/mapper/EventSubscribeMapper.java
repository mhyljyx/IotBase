package com.tztang.dahua.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tztang.dahua.pojo.dto.EventSubscribeDto;
import com.tztang.dahua.pojo.dto.EventSubscribeQueryDto;
import com.tztang.dahua.pojo.entity.EventSubscribe;
import com.tztang.dahua.pojo.vo.EventSubscribeQueryVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface EventSubscribeMapper extends BaseMapper<EventSubscribe> {

    //事件订阅查询
    IPage<EventSubscribeQueryVo> eventSubscribeQuery(IPage<EventSubscribeQueryVo> page, @Param("dto") EventSubscribeQueryDto dto);

}
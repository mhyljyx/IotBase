package com.tztang.dahua.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tztang.pojo.dto.EventSubscribeQueryDto;
import com.tztang.pojo.entity.EventSubscribe;
import com.tztang.pojo.vo.EventSubscribeQueryVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface EventSubscribeMapper extends BaseMapper<EventSubscribe> {

    //事件订阅查询
    IPage<EventSubscribeQueryVo> eventSubscribeQuery(IPage<EventSubscribeQueryVo> page, @Param("dto") EventSubscribeQueryDto dto);

}

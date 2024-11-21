package com.tztang.dahua.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EventSubscribeTypeMapper extends BaseMapper<EventSubscribeType> {

    @Insert({
            "<script>",
            "INSERT INTO event_subscribe_type (subscribe_name, `type`) VALUES",
            "<foreach collection='types' item='type' separator=','>",
            "(#{type.subscribeName}, #{type.type})",
            "</foreach>",
            "</script>"
    })
    int batchInsert(@Param("types") List<String> types);

}

package com.tztang.dahua.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tztang.dahua.pojo.entity.EventSubscribeGrade;
import com.tztang.dahua.pojo.entity.EventSubscribeNodeCode;
import com.tztang.dahua.pojo.entity.EventSubscribeOrg;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EventSubscribeNodeCodeMapper extends BaseMapper<EventSubscribeNodeCode> {

    @Insert({
            "<script>",
            "INSERT INTO event_subscribe_node_code (subscribe_name, node_code) VALUES",
            "<foreach collection='nodeCodes' item='nodeCode' separator=','>",
            "(#{nodeCodes.subscribeName}, #{nodeCodes.nodeCode})",
            "</foreach>",
            "</script>"
    })
    int batchInsert(@Param("nodeCodes") List<String> nodeCodes);

}

package com.tztang.dahua.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tztang.pojo.entity.EventSubscribeOrg;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EventSubscribeOrgMapper extends BaseMapper<EventSubscribeOrg> {

    @Insert({
            "<script>",
            "INSERT INTO event_subscribe_org (subscribe_name, org) VALUES",
            "<foreach collection='orgs' item='org' separator=','>",
            "(#{org.subscribeName}, #{org.org})",
            "</foreach>",
            "</script>"
    })
    int batchInsert(@Param("orgs") List<String> orgs);

}

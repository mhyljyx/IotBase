package com.tztang.dahua.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tztang.dahua.pojo.entity.EventSubscribeGrade;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EventSubscribeGradeMapper extends BaseMapper<EventSubscribeGrade> {

    @Insert({
            "<script>",
            "INSERT INTO event_subscribe_grade (subscribe_name, grade) VALUES",
            "<foreach collection='grades' item='grade' separator=','>",
            "(#{grade.subscribeName}, #{grade.grade})",
            "</foreach>",
            "</script>"
    })
    int batchInsert(@Param("grades") List<Integer> grades);

}

package com.tztang.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tztang.pojo.entity.SysApiDo;
import com.tztang.pojo.vo.SecurityPermissionRuleVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SysApiMapper extends BaseMapper<SysApiDo> {

    //查询接口对应的角色权限
    List<SecurityPermissionRuleVo> queryAllPermissionRule(@Param("roleType") String roleType);

}

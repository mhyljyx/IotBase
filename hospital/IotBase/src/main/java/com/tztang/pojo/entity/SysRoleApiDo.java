package com.tztang.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 角色接口关联表
 */
@Data
@TableName("sys_role_api")
public class SysRoleApiDo {

    private Long roleId;

    private Long apiId;

}

package com.xinran.common.constant;

import cn.hutool.core.collection.CollUtil;

import java.util.Set;

/**
 * 系统模块
 * @author xuehy
 * @since 2021/9/6
 */
public interface CmModuleConst {

    Set<String> MODULE_SET = CollUtil.newHashSet(
            //公共模块
            "common"
    );

}

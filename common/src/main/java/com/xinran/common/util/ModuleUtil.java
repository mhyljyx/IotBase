package com.xinran.common.util;

import cn.hutool.core.util.StrUtil;
import com.xinran.common.constant.CmModuleConst;
import com.xinran.common.constant.StrConst;

/**
 * @author xuehy
 * @since 2021/10/11
 */
public class ModuleUtil {

    /**
     * 获取请求所属模块
     * @param uri 请求路径
     * @return 所属模块
     */
    public static String getModuleByUri(String uri) {
        if (StrUtil.isBlank(uri)) {
            return null;
        }
        if (uri.startsWith(StrConst.SLASH)) {
            uri = uri.substring(1);
        }
        for (String module : CmModuleConst.MODULE_SET) {
            if (uri.startsWith(module)) {
                return module;
            }
        }
        return null;
    }

}

package com.xinran.common.util;

import cn.hutool.core.util.ObjectUtil;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author xuehy
 * @since 2023/3/10
 */
public class RequestUtil {

    //获取HttpServletRequest
    public static HttpServletRequest getRequest() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return ObjectUtil.isNull(attributes) ? null : attributes.getRequest();
    }

}

package com.tztang.handler;

import com.alibaba.fastjson2.JSON;
import com.tztang.common.ApiResponse;
import com.tztang.enums.BaseCode;
import com.tztang.util.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 认证异常
 */
@Component
public class AuthenticationEntryPointHandler implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        ApiResponse<Object> res = ApiResponse.error(HttpStatus.UNAUTHORIZED.value(), "用户认证失败：" + authException.getLocalizedMessage());
        WebUtils.renderString(response, JSON.toJSONString(res));
    }

}

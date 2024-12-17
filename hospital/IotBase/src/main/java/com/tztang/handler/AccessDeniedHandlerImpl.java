package com.tztang.handler;

import com.alibaba.fastjson2.JSON;
import com.tztang.common.ApiResponse;
import com.tztang.util.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        ApiResponse<Object> res = ApiResponse.error(HttpStatus.FORBIDDEN.value(), "您无此权限：" + accessDeniedException.getLocalizedMessage());
        WebUtils.renderString(response, JSON.toJSONString(res));
    }

}

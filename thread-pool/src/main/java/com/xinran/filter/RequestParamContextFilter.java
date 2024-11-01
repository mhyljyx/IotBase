package com.xinran.filter;


import com.xinran.util.StringUtil;
import org.slf4j.MDC;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.xinran.constant.Constant.TRACE_ID;

/**
 * @program: 
 * @description: 链路过滤器
 * @author: tztang
 **/

public class RequestParamContextFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String traceId = request.getHeader(TRACE_ID);
        if (StringUtil.isNotEmpty(traceId)){
            MDC.put(TRACE_ID,traceId);
        }
        try {
            filterChain.doFilter(request, response);
        }finally {
            MDC.remove(TRACE_ID);
        }
    }
}

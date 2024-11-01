package com.xinran.filter;

import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * @program: 
 * @description: 过滤器配置
 * @author: tztang
 **/
public class FilterConfig {

    @Bean
    public OncePerRequestFilter requestParamContextFilter(){
        return new RequestParamContextFilter();
    }
}

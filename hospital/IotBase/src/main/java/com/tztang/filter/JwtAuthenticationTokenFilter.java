package com.tztang.filter;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.tztang.service.TokenService;
import com.tztang.service.impl.TokenServiceImpl;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.security.sasl.AuthenticationException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Resource
    private TokenServiceImpl tokenService;

    @SneakyThrows
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 获取token
        String token = request.getHeader("token");
        if (StrUtil.isBlank(token)) {
            // 放行
            filterChain.doFilter(request, response);
            return;
        }
        // 解析token
        boolean verifyToken = tokenService.verifyToken(token);
        if (!verifyToken) {
            log.error("当前token已过期");
            throw new AuthenticationException("当前token已过期");
        }
        // 从redis中获取用户信息
        String info = tokenService.getBaseInfo(token);
        Object baseInfo = JSON.parseObject(info).get("base_info");
        JSONArray apiIds = JSON.parseObject(info).getJSONArray("api_permission");
        List<GrantedAuthority> authorities = new ArrayList<>();
        if (CollUtil.isNotEmpty(apiIds)) {
            apiIds.forEach(api -> authorities.add(new SimpleGrantedAuthority("ROLE_" + api)));
        }
        // 更新存活时间

        // 存入SecurityContextHolder
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(baseInfo, null, authorities);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        // 放行
        filterChain.doFilter(request, response);
    }

}

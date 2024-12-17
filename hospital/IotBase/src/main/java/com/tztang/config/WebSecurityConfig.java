package com.tztang.config;

import cn.hutool.core.util.ObjectUtil;
import com.tztang.exception.DemoFrameException;
import com.tztang.filter.JwtAuthenticationTokenFilter;
import com.tztang.handler.AccessDeniedHandlerImpl;
import com.tztang.handler.AuthenticationEntryPointHandler;
import com.tztang.mapper.SysApiMapper;
import com.tztang.pojo.vo.SecurityPermissionRuleVo;
import com.tztang.service.AdminService;
import com.tztang.service.impl.AdminServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Resource
    private SysApiMapper sysApiMapper;

    @Resource
    private AccessDeniedHandlerImpl accessDeniedHandler;
    @Resource
    private AuthenticationEntryPointHandler authenticationEntryPoint;
    @Resource
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // 不使用session存储信息
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        // 前后端分离, 使用自定义的token
        http.csrf().disable();
        // 配置异常捕获
        http.exceptionHandling().authenticationEntryPoint(authenticationEntryPoint).accessDeniedHandler(accessDeniedHandler);
        http.authorizeRequests()
                .antMatchers("/common/admin/api/login").anonymous()
                .and()
                .authorizeRequests(authorize -> {
                    // 动态加载权限规则
                    List<SecurityPermissionRuleVo> permissionRules = sysApiMapper.queryAllPermissionRule(null);
                    authorize.antMatchers("/**").hasAnyAuthority("SUPER_ADMIN");
                    for (SecurityPermissionRuleVo rule : permissionRules) {
                        authorize.antMatchers(rule.getPath())
                                .hasAnyAuthority(rule.getRoles().toArray(new String[0])); // 动态绑定角色权限
                    }
                    // 默认规则：所有请求需要认证
                    authorize.anyRequest().authenticated();
                });
        // 把jwt认证过滤器放到用户密码认证前面
        http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

}

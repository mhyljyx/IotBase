package com.tztang.config;

import cn.hutool.core.util.ObjectUtil;
import com.tztang.exception.DemoFrameException;
import com.tztang.filter.JwtAuthenticationTokenFilter;
import com.tztang.handler.AccessDeniedHandlerImpl;
import com.tztang.service.AdminService;
import com.tztang.service.impl.AdminServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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

@Slf4j
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Resource
    private AdminServiceImpl adminService;

    @Resource
    private PwdConfig pwdConfig;

    @Resource
    private AccessDeniedHandlerImpl accessDeniedHandler;
    @Resource
    private AuthenticationEntryPoint authenticationEntryPoint;
    @Resource
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    /**
     * 用户和密码认证
     */
    @Bean
    public AuthenticationProvider authenticationProvider() {
        return new AuthenticationProvider() {
            @Override
            public Authentication authenticate(Authentication authentication) throws AuthenticationException {
                String name = authentication.getName();
                String pwd = authentication.getCredentials().toString();
                UserDetails loginUser = adminService.loadUserByUsername(name);
                if (ObjectUtil.isNull(loginUser) || !pwdConfig.passwordEncoder().matches(pwd, loginUser.getPassword())) {
                    //密码匹配失败。抛出异常
                    log.error("访问拒绝，用户名或密码错误!");
                    throw new DemoFrameException("访问拒绝，用户名或密码错误!");
                }
                log.info("访问成功" + loginUser);
                return new UsernamePasswordAuthenticationToken(loginUser, pwd, loginUser.getAuthorities());
            }

            @Override
            public boolean supports(Class<?> authentication) {
                return authentication.equals(UsernamePasswordAuthenticationToken.class);
            }
        };
    }

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
                .authorizeRequests()
                .anyRequest().authenticated();
        // 把jwt认证过滤器放到用户密码认证前面
        http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

}

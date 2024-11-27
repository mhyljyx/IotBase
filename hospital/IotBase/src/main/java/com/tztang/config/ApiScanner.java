package com.tztang.config;

import com.tztang.pojo.entity.SysApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class ApiScanner {

    @Resource
    private RequestMappingHandlerMapping requestMappingHandlerMapping;

    /**
     * 获取所有接口信息
     */
    public List<SysApi> scanApis() {
        // 获取所有的映射信息
        Map<RequestMappingInfo, HandlerMethod> handlerMethods = requestMappingHandlerMapping.getHandlerMethods();

        List<SysApi> apiList = new ArrayList<>();
        handlerMethods.forEach((requestMappingInfo, handlerMethod) -> {
            // 获取 URL 路径
            assert requestMappingInfo.getPatternsCondition() != null;
            String url = requestMappingInfo.getPatternsCondition().getPatterns().iterator().next();
            // 获取请求方法
            String method = requestMappingInfo.getMethodsCondition().getMethods().iterator().next().name();
            // 获取方法上的描述信息 (例如注解中的描述)
            String description = handlerMethod.getMethod().getName(); // 或从自定义注解中提取
            // 构建 API 信息对象
            apiList.add(new SysApi(description, url, method, description));
        });

        return apiList;
    }
}
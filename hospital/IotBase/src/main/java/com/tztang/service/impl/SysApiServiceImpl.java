package com.tztang.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tztang.common.ApiResponse;
import com.tztang.mapper.SysApiMapper;
import com.tztang.pojo.entity.SysApiDo;
import com.tztang.service.SysApiService;
import org.springframework.stereotype.Service;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class SysApiServiceImpl extends ServiceImpl<SysApiMapper, SysApiDo> implements SysApiService {

    @Resource
    private RequestMappingHandlerMapping requestMappingHandlerMapping;

    /**
     * 获取所有接口信息并增量更新
     */
    public void scanApis() {
        Map<String, Long> urlAndIdMap = this.baseMapper.selectList(Wrappers.emptyWrapper()).stream().collect(Collectors.toMap(SysApiDo::getUrl, SysApiDo::getId));
        Set<String> sysApiSet = urlAndIdMap.keySet();
        // 获取所有的映射信息
        Map<RequestMappingInfo, HandlerMethod> handlerMethods = requestMappingHandlerMapping.getHandlerMethods();
        List<SysApiDo> apiList = new ArrayList<>();
        handlerMethods.forEach((requestMappingInfo, handlerMethod) -> {
            // 获取 URL 路径
            assert requestMappingInfo.getPatternsCondition() != null;
            String url = requestMappingInfo.getPatternsCondition().getPatterns().iterator().next();
            // 获取请求方法
            String method = requestMappingInfo.getMethodsCondition().getMethods().iterator().next().name();
            // 获取方法上的描述信息 (例如注解中的描述)
            String description = handlerMethod.getMethod().getName(); // 或从自定义注解中提取
            // 构建 API 信息对象
            if (sysApiSet.contains(url)) {
                //更新
                apiList.add(new SysApiDo(urlAndIdMap.get(url), description, url, method, description));
            }
            //新增
            apiList.add(new SysApiDo(description, url, method, description));
        });
        saveOrUpdateBatch(apiList);
    }

}

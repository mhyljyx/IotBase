package com.tztang.swagger;

import cn.hutool.core.collection.CollUtil;
import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.List;

/**
 * @program: 
 * @description: swagger配置
 * @author: tztang
 **/
@EnableKnife4j
public class SwaggerConfiguration {

    @Bean
    @Order(value = 1)
    public Docket groupRestApi() {
        
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(groupApiInfo())
                .useDefaultResponseMessages(false)
                .forCodeGeneration(true)
                .select()
                .apis((requestHandler) -> {
                    boolean controllerStandardDocument = requestHandler.findControllerAnnotation(Api.class).isPresent();
                    boolean methodStandardDocument = requestHandler.findAnnotation(ApiOperation.class).isPresent();
                    return controllerStandardDocument || methodStandardDocument;
                })
                .build();
    }

    private ApiInfo groupApiInfo(){
        return new ApiInfoBuilder()
                .title("swagger文档")
                .description("<div style='font-size:14px;color:red;'>前端开发人员使用</div>")
                .termsOfServiceUrl("http://www.group.com/")
                .contact(new Contact("tztang", "", ""))
                .version("1.0")
                .build();
    }

    private ApiKey apiKey() {
        return new ApiKey("BearerToken", "Authorization", "header");
    }
    private ApiKey apiKey1() {
        return new ApiKey("BearerToken1", "Authorization-x", "header");
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.regex("/.*"))
                .build();
    }
    private SecurityContext securityContext1() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth1())
                .forPaths(PathSelectors.regex("/.*"))
                .build();
    }

    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return CollUtil.newArrayList(new SecurityReference("BearerToken", authorizationScopes));
    }
    List<SecurityReference> defaultAuth1() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return CollUtil.newArrayList(new SecurityReference("BearerToken1", authorizationScopes));
    }
}


package com.ljfl.server.common.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Description: java类作用描述
 * @Author: zwx
 * @CreateDate: 2020/1/12 16:49
 */
@Configuration
@EnableSwagger2
@Profile({"dev", "offline", "test"})
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                // 详细信息定制
                .apiInfo(apiInfo())
                .select()
                // 指定当前包路径
                .apis(RequestHandlerSelectors.basePackage("com.ljfl"))
                // 扫描所有 .apis(RequestHandlerSelectors.any())
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation
                        .class))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 添加摘要信息
     */
    private ApiInfo apiInfo() {
        // 用ApiInfoBuilder进行定制
        return new ApiInfoBuilder()
                .title("标题：垃圾分类API文档")
//                .description("描述：文档构建器")
                .contact(new Contact("拯救地球小分队", null, null))
                .version("1.0")
                .build();
    }
}

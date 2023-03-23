package com.pikachu.takeaway.config;


import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import com.pikachu.takeaway.common.JacksonObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

/**
 * @Author: 橙子
 * @Date: 2022/11/16 18:57
 */
@Slf4j
@Configuration
@EnableKnife4j
@EnableSwagger2
public class

WebMvcConfig extends WebMvcConfigurationSupport {
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        log.info("开始映射静态资源");
        //swagger要用    前两个
        registry.addResourceHandler("doc.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");

        registry.addResourceHandler("/backend/**").addResourceLocations("classpath:/backend/");
        registry.addResourceHandler("/front/**").addResourceLocations("classpath:/front/");
    }


    /**
     * 扩展mvc框架的消息转换器
     *
     * @param converters
     */
    @Override
    protected void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        //创建消息转换器
        MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();
        //设置对象转换器
        messageConverter.setObjectMapper(new JacksonObjectMapper());

        converters.add(0, messageConverter);
        super.extendMessageConverters(converters);
    }

    public Docket createRestApi() {
        //文档整理
        return new Docket(DocumentationType.SWAGGER_2).
                apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.pikachu.takeaway.controller"))//扫描需要生成接口文档的包
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("皮卡丘外卖")
                .version("1.0")
                .description("皮卡丘外卖接口文档")
                .build();
    }
}

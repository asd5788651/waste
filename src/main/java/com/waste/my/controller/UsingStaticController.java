package com.waste.my.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @Author wykun
 * @Date 2022/3/23 22:54
 */

@Configuration
public class UsingStaticController extends WebMvcConfigurationSupport {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
// classpath表示在resource目录下，/static/** 表示在URL路径中访问如
// http://localhost:28000/static/ 即可访问到resource下的static目录
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

}
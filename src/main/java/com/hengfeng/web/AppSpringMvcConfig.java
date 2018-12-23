package com.hengfeng.web;

import com.hengfeng.web.config.RouteConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

public class AppSpringMvcConfig extends WebMvcConfigurationSupport {
    @Autowired
    private  RouteConfig routeConfig;
    /**
     * <p>Title:</p>
     * <p>Description:重写增加自定义拦截器的注册，某一个拦截器需要先注册进来，才能工作</p>
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //registry.addInterceptor(routeConfig).addPathPatterns("/**");

        super.addInterceptors(registry);
    }
}

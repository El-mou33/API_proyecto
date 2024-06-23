package com.example.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvsConfig implements WebMvcConfigurer {

    @Autowired
    @Qualifier("timeInterceptor")
    HandlerInterceptor handlerInterceptor;


    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry) {

        interceptorRegistry.addInterceptor(handlerInterceptor).addPathPatterns("/api/**");
    }

}

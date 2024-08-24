package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final DemoHandlerInterceptor demoHandlerInterceptor;

    @Autowired
    public WebConfig(DemoHandlerInterceptor demoHandlerInterceptor) {
        this.demoHandlerInterceptor = demoHandlerInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(demoHandlerInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/api");
    }
}

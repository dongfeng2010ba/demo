package com.dong.config;

import com.dong.resolver.LoginHeaderHandlerMethodArgumentResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebMvcConfig {
    @Autowired
    private LoginHeaderHandlerMethodArgumentResolver loginHeaderHandlerMethodArgumentResolver;
}

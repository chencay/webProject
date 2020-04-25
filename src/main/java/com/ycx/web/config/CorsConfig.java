package com.ycx.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author ycx
 * @description 描述
 * @date 2020/4/219:49 下午
 **/
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    /** * **/
    private static final String ALL = "*";
    @Override
    public void addCorsMappings(CorsRegistry corsRegistry) {
        corsRegistry.addMapping("/**")
                .allowedOrigins(ALL)
                .allowedMethods(ALL)
                .allowedHeaders(ALL)
                .allowCredentials(true)
                .maxAge(1800);
    }
}

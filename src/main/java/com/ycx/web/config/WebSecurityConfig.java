package com.ycx.web.config;

import com.ycx.web.mongo.service.impl.UserInfoServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

/**
 * @author ycx
 * @description Spring Security的配置类
 * @date 2020/5/7 11:28 下午
 **/
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /** UserInfoService **/
    @Resource
    UserInfoServiceImpl userInfoServiceImpl;

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userInfoServiceImpl);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

    }
}

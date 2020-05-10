package com.ycx.web.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ycx.web.dto.ResponseBean;
import com.ycx.web.mysql.service.UserService;
import com.ycx.web.utils.PublicUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author ycx
 * @description Spring Security的配置类
 * @date 2020/5/7 11:28 下午
 **/
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /** UserService **/
    @Resource
    UserService userService;
    @Resource
    CustomUrlFilterInvocationSecurityMetadataSource customUrlFilterInvocationSecurityMetadataSource;
    @Resource
    CustomUrlAccessDecisionManager customUrlAccessDecisionManager;
    @Resource
    CustomAuthenticationAccessDeniedHandler customAuthenticationAccessDeniedHandler;


    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //忽略的请求url
        web.ignoring().antMatchers("/index.html", "/static/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    //注入请求url所需角色和当前用户的角色比对bean
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                        o.setSecurityMetadataSource(customUrlFilterInvocationSecurityMetadataSource);
                        o.setAccessDecisionManager(customUrlAccessDecisionManager);
                        return o;
                    }
                })
                .and()
                .formLogin()
//                .loginPage("/login_p")
                .loginProcessingUrl("/login")
//                .usernameParameter("username")
//                .passwordParameter("password")
                .permitAll()
                .failureHandler(new AuthenticationFailureHandler() {
                    //登录失败的处理
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest httpServletRequest
                            , HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException
                            , ServletException {
                        httpServletResponse.setContentType("application/json;charset=utf-8");
                        ResponseBean responseBean = null;
                        if (e instanceof UsernameNotFoundException || e instanceof BadCredentialsException) {
                            responseBean = ResponseBean.error("用户名或密码输入错误，登录失败!");
                        } else if (e instanceof LockedException) {
                            responseBean = ResponseBean.error("账户被锁定，登录失败，请联系管理员!");
                        } else if (e instanceof CredentialsExpiredException) {
                            responseBean = ResponseBean.error("密码过期，登录失败，请联系管理员!");
                        } else if (e instanceof AccountExpiredException) {
                            responseBean = ResponseBean.error("账户过期，登录失败，请联系管理员!");
                        } else if (e instanceof DisabledException) {
                            responseBean = ResponseBean.error("账户被禁用，登录失败，请联系管理员!");
                        } else {
                            responseBean = ResponseBean.error("登录失败!");
                        }
                        httpServletResponse.setStatus(401);
                        ObjectMapper objectMapper = new ObjectMapper();
                        PrintWriter out = httpServletResponse.getWriter();
                        out.write(objectMapper.writeValueAsString(responseBean));
                        out.flush();
                        out.close();
                    }
                })
                .successHandler(new AuthenticationSuccessHandler() {
                    //登录成功的处理
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest
                            , HttpServletResponse httpServletResponse, Authentication authentication) throws IOException
                            , ServletException {
                        httpServletResponse.setContentType("application/json;charset=utf-8");
                        ResponseBean responseBean = ResponseBean.ok("登录成功！", PublicUtil.getCurrentUser());
                        PrintWriter out = httpServletResponse.getWriter();
                        ObjectMapper objectMapper = new ObjectMapper();
                        out.write(objectMapper.writeValueAsString(responseBean));
                        out.flush();
                        out.close();
                    }
                })
                .and()
                .logout()
                .permitAll()
                .and()
                .csrf()
                .disable()
                .exceptionHandling()
                .accessDeniedHandler(customAuthenticationAccessDeniedHandler);
    }
}

package com.ycx.web.service;

import com.ycx.web.mysql.entity.Menu;
import com.ycx.web.mysql.entity.Role;
import com.ycx.web.mysql.service.MenuService;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

/**
 * @author ycx
 * @description 通过当前的请求地址，获取该地址需要的用户角色
 * @date 2020/5/8 9:13 下午
 **/
@Component
public class CustomUrlFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    /** MenuDao **/
    @Resource
    MenuService menuService;

    AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        //获取请求地址
        String requestUrl = ((FilterInvocation) o).getRequestUrl();
        //如果是登录url，返回null，即当前请求不需要任何角色就能访问
        if ("/login".equals(requestUrl)) {
            return null;
        }
        //获取动态的权限配置资源
        List<Menu> allMenu = menuService.getAllMenus();
        if (null == allMenu || allMenu.isEmpty()) {
            return null;
        }
        //遍历menu获取匹配url的角色
        for (Menu menu : allMenu) {
            List<Role> roles = menu.getRoles();
            if (antPathMatcher.match(menu.getUrl(), requestUrl) && null != roles && !roles.isEmpty()) {
                int size = roles.size();
                String[] values = new String[size];
                for (int i = 0; i < size; i++) {
                    values[i] = roles.get(i).getRoleName();
                }
                return SecurityConfig.createList(values);
            }
        }
        //没有匹配上的资源，都是登录访问
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        //此方法用于返回所用定义好的权限资源，springSecurity会在启动时校验相关配置是否正确，如果不需要校验，返回null
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        //返回类对象是否支持校验
        return FilterInvocation.class.isAssignableFrom(aClass);
    }
}

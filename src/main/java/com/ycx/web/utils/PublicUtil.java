package com.ycx.web.utils;

import com.ycx.web.mysql.entity.User;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author ycx
 * @description 项目公用工具类
 * @date 2020/4/2 19:53 下午
 **/
public class PublicUtil {

    /** 空字符串 **/
    public static final String EMPTY_STR = "";

    /**
     * 获取当前用户
     * @return User
     */
    public static User getCurrentUser(){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user;
    }
}

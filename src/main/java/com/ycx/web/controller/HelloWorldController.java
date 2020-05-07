package com.ycx.web.controller;

import com.ycx.web.mongo.entity.UserInfo;
import com.ycx.web.mongo.service.UserInfoService;
import com.ycx.web.mysql.entity.User;
import com.ycx.web.mysql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author ycx
 * @description 项目第一个controller
 * @date 2020/4/2 19:55 下午
 **/
@Controller
public class HelloWorldController {

    /** UserInfoService **/
    @Resource
    private UserInfoService userInfoService;
    /** UserService **/
    @Resource
    private UserService userService;

    /**
     * helloWorld
     * @return String
     */
    @GetMapping("/hello")
    @ResponseBody
    public String helloWorld() {
        User userInfo = new User();
        userInfo.setUsername("yuchengxin");
        userInfo.setPassword("666666");
        userService.save(userInfo);
        return "hello, world!";
    }
}

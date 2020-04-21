package com.ycx.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ycx
 * @description 项目第一个controller
 * @date 2020/4/2 19:55 下午
 **/
@Controller
@RequestMapping("/hello")
public class HelloWorldController {
    /**
     * helloWorld
     * @return String
     */
    @GetMapping("/world")
    @ResponseBody
    public String helloWorld() {
        return "hello, world!";
    }
}

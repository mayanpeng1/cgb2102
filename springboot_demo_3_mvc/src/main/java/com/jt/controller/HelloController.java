package com.jt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller// 1.将该类交由Spring容器管理   2.同时开启SpringMVC机制
public class HelloController {
    /**
     * 需求: http://localhost:8090/hello   访问hello.html
     *      http://localhost:8090/say   访问say.html
     * 实现步骤:
     *      1.拦截用户请求 @RequestMapping("/hello")
     *      2.String 类型的返回值 表示返回页面名称
     *      3.根据YML配置文件中的内容 动态的拼接前缀和后缀 形成页面唯一路径
     */

    @RequestMapping("/hello")
    public String hello(){
        //动态的拼接前缀+后缀
        //classpath:/templates/hello.html
        return "hello";
    }

    @RequestMapping("/say")
    public String say(){
        return "say";
    }

}

package com.jt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RequestController {

    @GetMapping("/getA")
    public String getA(Integer id){
        System.out.println("我是A请求:"+id);
        //当用户访问A时,由服务器动态的将请求发送给B
        //关键字 forward  转发: 地址不发生变化  可以携带用户信息(request对象)   请求一次
        //      redirect  重定向  地址栏发生改变  不可携带用户信息  请求多次   request对象不是同一个
        return "redirect:/getB";
    }

    @GetMapping("/getB")
    @ResponseBody
    public String getB(Integer id){
        System.err.println("我是B请求:"+id);
        return "我是B请求:"+id;
    }
}

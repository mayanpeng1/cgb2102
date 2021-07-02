package com.jt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RestFulController {
    /**
     * 常规的get请求:
     * url地址: http://localhost:8090/restFul?id=1&mane=tom
     * get请求弊端: 如果参数有多个,则key-value的结构需要多份
     * RestFul结构:
     *  url地址: http://localhost:8090/restFul/1tom
     *      1.参数之间使用/分割
     *      2.参数的位置一旦确定,不可更改
     *      3.参数使用{}号的形式进行包裹,并且设定形参
     */
    @RequestMapping("/restFul/{id}/{name}")
    public String restrFul(
            @PathVariable Integer id, @PathVariable String name){
        System.err.println("获取参数:"+id+"|"+name);
        return "success";
    }

}

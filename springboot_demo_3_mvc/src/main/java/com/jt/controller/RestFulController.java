package com.jt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
     * @PathVariable:参数说明
     *      1.name/value 动态接受形参的数据 如果参数相同则省略不写
     *      2.必填项 required 默认为true
     */
   // @RequestMapping(value = "/restFul/{id}/{name}" ,method = RequestMethod.DELETE )
   // @RequestMapping(value = "/restFul/{id}/{name}" ,method = RequestMethod.POST )
   // @RequestMapping(value = "/restFul/{id}/{name}" ,method = RequestMethod.PUT )
   // @RequestMapping(value = "/restFul/{id}/{name}" ,method = RequestMethod.GET )
    @GetMapping("/restFul/{id}/{name}")
    // @DeleteMapping(value = "/restFul/{id}/{name}")
    // @PutMapping(value = "/restFul/{id}/{name}")
    // @PostMapping(value = "/restFul/{id}/{name}")
    // @RequestMapping(value = "/restFul/{id}/{name}")  //默认支持所有的请求类型
    public String restrFul(
            @PathVariable Integer id, @PathVariable String name){
        System.err.println("获取参数:"+id+"|"+name);
        return "success";
    }

}

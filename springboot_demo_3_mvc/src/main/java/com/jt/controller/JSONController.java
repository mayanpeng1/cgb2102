package com.jt.controller;

import com.jt.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JSONController {
    /**
     * 需求: 要求根据getJSON的请求,获取User对象的JSON数据
     * 用法: 如果需要返回JSON数据则使用注解@ResponseBody
     * 知识点讲解:
     *      返回的对象之后,springVC通过内部API(ObjectMapper)
     *      调用对象的getXXX() 方法动态的获取属性和属性值
     * 演化规则:
     *      getAge()  --- 去掉get首字母  --- Age()
     *      -- 首字母小写  age()  -- 获取属性  age
     *      -- 通过getAge() 动态获取属性的值
     * JSON: {"age":"今年18岁!!!"}
     * 注意事项:
     *      必须添加get/set方法
     * @return
     */
    @RequestMapping("/getJSON")
    @ResponseBody
    public User getJSON(){
        User user = new User();
        user.setId(1).setName("JSON测试");
        return user;
    }
}

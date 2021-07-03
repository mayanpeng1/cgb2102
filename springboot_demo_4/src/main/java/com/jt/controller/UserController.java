package com.jt.controller;

import com.jt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/demo")
    @ResponseBody
    public String demo(){
        return "框架整合初步完成";
    }

    /**
     * 查询所有的用户列表数据  在  userList。html中展现数据
     */

}

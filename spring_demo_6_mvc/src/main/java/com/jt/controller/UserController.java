package com.jt.controller;

import com.jt.pojo.User;
import com.jt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    public void addUser(){
        User user = new User();
        user.setId(101);
        user.setUsername("你好啊哈哈哈哈");
        userService.addUser(user);
    }
}

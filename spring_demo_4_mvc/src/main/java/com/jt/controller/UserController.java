package com.jt.controller;

import com.jt.pojo.User;
import com.jt.service.UserService;

public class UserController {

    //spring容器负责注入Service对象
    private UserService userService;
    private User user;  //代替用户传入的数据

    public void setUser(User user) {
        this.user = user;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void addUser(){
        //手动的构建一个user参数
        User user = new User();
        userService.addUser(user);
    }


}

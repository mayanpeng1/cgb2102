package com.jt.controller;

import com.jt.pojo.User;
import com.jt.service.UserService;
import com.jt.vo.SysResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 刘昱江
 * 时间 2021/5/11
 */
@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 需求: 根据用户名和密码实现用户登录,要求返回token
     * URL: /user/login
     * 请求参数: post JSON{username:"xxx" , password:"xxxx"}
     * 返回值: SysResult 对象  (token)
     */
    @PostMapping("/user/login")
    public SysResult login(User user){
        String token = userService.login(user);
        if(StringUtils.hasLength(token)){
            return SysResult.success(token);
        }else {
            return SysResult.fall();
        }
    }


    @GetMapping("/hello")
    public List<User> hello(){

        return userService.findAll();
    }
}

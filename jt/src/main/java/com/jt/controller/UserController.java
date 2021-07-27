package com.jt.controller;

import com.jt.pojo.User;
import com.jt.service.UserService;
import com.jt.vo.PageResult;
import com.jt.vo.SysResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 刘昱江
 * 时间 2021/5/11
 */
@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 需求: 根据用户名和密码实现用户登录,要求返回token
     * URL: /user/login
     * 请求参数: post JSON{username:"xxx" , password:"xxxx"}
     * 返回值: SysResult 对象  (token)
     */
    @PostMapping("/login")
    public SysResult login(@RequestBody User user){
        System.err.println(user);
        String token = userService.login(user);
        if(StringUtils.hasLength(token)){
            return SysResult.success(token);
        }else {
            return SysResult.fall();
        }
    }

    /**
     * 1.业务需求: 根据条件进行分页查询
     * 请求路径:/user/list
     * 请求类型: get
     * 请求参数: 后台使用PageResult对象接受
     * 返回值: SysResult(pageResult 对象)
     *
     * 1.用户参数3个
     * 2.要求返回值5个
     */
    @GetMapping("/list")
    public SysResult getUserList(PageResult pageResult){
        pageResult = userService.getUserList(pageResult);
        return SysResult.success(pageResult);
    }

    @PutMapping("/status/{id}/{status}")
    public SysResult updateStatus(@PathVariable Integer id, @PathVariable boolean status){
        System.err.println("aa:"+status);
        return SysResult.success();
    }


    @GetMapping("/hello")
    public List<User> hello(){

        return userService.findAll();
    }
}

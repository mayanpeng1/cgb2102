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
    public SysResult updateStatus(User user){
        userService.updateStatus(user);
        return SysResult.success();
    }
    //修改用户状态
    @RequestMapping("/status1")
    public SysResult updateStatus1(Integer id,boolean status){
        User user = new User();
        user.setId(id).setStatus(status);
        userService.updateStatus(user);
        return SysResult.success();
    }
    //根据id 删除用户
    @DeleteMapping("/{id}")
    public SysResult deleteUserById(@PathVariable Integer id){
        userService.deleteUserById(id);
        return SysResult.success();
    }

    /**
     * 业务分析: 根据用户ID查询数据库
     * URL地址:/user/{id}
     * 返回值: SysResult对象
     */
    @GetMapping("/{id}")
    public SysResult getUserById(@PathVariable Integer id){
        User user = userService.getUserById(id);
        return SysResult.success(user);
    }


    /**
     * 业务需求: 实现用户新增
     * URL: /user/addUser
     * 参数: form 表单进行提交  JSON串
     * 类型: post请求
     * 返回值: SysResult对象
     */
    @PostMapping("/addUser")
    public SysResult addUser(@RequestBody User user){
        userService.addUser(user);
        return SysResult.success();
    }

    @PutMapping("/updateUser")
    public SysResult updateUser(@RequestBody User user){
        userService.updateUser(user);
        return SysResult.success();
    }

    @GetMapping("/hello")
    public List<User> hello(){

        return userService.findAll();
    }
}

package com.jt.service;

import com.jt.pojo.User;
import com.jt.vo.PageResult;

import java.util.List;

/**
 * @author 刘昱江
 * 时间 2021/5/11
 */
public interface UserService {
    List<User> findAll();

    //用户登录判断
    String login(User user);

    //分页查询
    PageResult getUserList(PageResult pageResult);

    //修改用户状态  是否是禁用
    void updateStatus(User user);
    
    //删除用户
    void deleteUserById(Integer id);

    //添加用户
    void addUser(User user);
}

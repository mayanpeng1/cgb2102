package com.jt.service;

import com.jt.pojo.User;

public interface UserService {

    //根据 User对象 查询用户信息
    void findUserById(User user);
}

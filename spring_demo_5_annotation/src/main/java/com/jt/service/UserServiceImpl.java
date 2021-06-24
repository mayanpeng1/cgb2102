package com.jt.service;

import com.jt.dao.UserDao;
import com.jt.pojo.User;

public class UserServiceImpl implements UserService{

    private UserDao userDao;//基于Spring注入dao  面向接口编程

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void addUser(User user) {
        String name = user.getName() + "加工数据";
        user.setName(name);
        userDao.addUser(user);
    }
}

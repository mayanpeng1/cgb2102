package com.jt.service;

import com.jt.pojo.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{


    @Override
    public void findUserById(User user) {
        System.out.println("从数据库当中查询数据："+user);
    }
}

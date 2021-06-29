package com.jt.mapper;

import com.jt.pojo.DemoUser;

import java.util.List;

public interface UserMapper {

    List<DemoUser> findAll();

    //添加用户
    void insertUser(DemoUser user);


}

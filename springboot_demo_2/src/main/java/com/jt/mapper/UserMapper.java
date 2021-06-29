package com.jt.mapper;

import com.jt.pojo.DemoUser;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface UserMapper {

    List<DemoUser> findAll();

    //添加用户
    void insertUser(DemoUser user);

    //修改 用户信息
    void updateUser(String oldName, String nowName, String sex);
}

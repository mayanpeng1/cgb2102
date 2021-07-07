package com.jt.service;

import com.jt.pojo.User;

import java.util.List;

public interface UserService {


    List<User> findAll();

    User getUserById(Integer id);

    void insertUser(User user);

    void updateUser(User user);

    void deleteUser(Integer id);
}

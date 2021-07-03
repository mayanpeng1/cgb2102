package com.jt.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jt.mapper.UserMapper;
import com.jt.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;


    @Override
    public List<User> findAll() {
        return userMapper.selectList(null);
    }

    @Override
    public void insertUser(User user) {
        Integer row = userMapper.insert(user);
    }

    //修改
    @Override
    public void updateUser(User user) {
        // QueryWrapper queryWrapper = new QueryWrapper();
        // queryWrapper.eq("id", user.getId());
        Integer row = userMapper.updateById(user);
    }

    @Override
    public void deleteUser(Integer id) {

        userMapper.deleteById(id);
    }
}

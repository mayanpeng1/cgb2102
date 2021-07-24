package com.jt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jt.mapper.UserMapper;
import com.jt.pojo.User;
import com.jt.service.UserService;
import com.jt.vo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;
import java.util.UUID;

/**
 * @author 刘昱江
 * 时间 2021/5/11
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.selectList(null);
    }

    @Override
    public String login(User user) {
        String password = user.getPassword();
        //md5hash相对于MD5冯家安全  没有绝对安全的系统
        String md5Pass = DigestUtils.md5DigestAsHex(password.getBytes());
        user.setPassword(md5Pass);
        //根据其中不为null 的数据当做where 条件
        //sql: select * from user where u = #{u} and p = #{p}
        QueryWrapper<User> queryWrapper = new QueryWrapper<>(user);
        User userDB = userMapper.selectOne(queryWrapper);
        if (userDB==null){
            return null;
        }
        String token = UUID.randomUUID().toString().replace("-", "");
        return token;

    }

    @Override
    public PageResult getUserList(PageResult pageResult) {
        return null;
    }


}

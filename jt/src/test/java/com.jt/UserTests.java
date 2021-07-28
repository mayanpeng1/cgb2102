package com.jt;

import com.jt.pojo.User;
import com.jt.service.UserService;
import com.jt.vo.PageResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UserTests {
    @Autowired
    UserService userService;

    @Test
    public void login(){
        User user = new User();
        user.setUsername("admin123");
        user.setPassword("admin123456.");
        String token = userService.login(user);
        System.err.println(token);
    }

    @Test
    public void getUserList(){
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(2);
        pageResult.setPageSize(3);
        pageResult.setQuery("");

        pageResult = userService.getUserList(pageResult);
        System.err.println(pageResult);
    }

    @Test
    public void updateStatus(){
        User user = new User();
        user.setId(6).setStatus(true);
        userService.updateStatus(user);
        System.err.println("OK");
    }
}

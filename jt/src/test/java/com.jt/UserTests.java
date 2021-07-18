package com.jt;

import com.jt.pojo.User;
import com.jt.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
}

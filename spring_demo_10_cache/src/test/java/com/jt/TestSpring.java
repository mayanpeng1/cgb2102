package com.jt;

import com.jt.config.SpringConfig;
import com.jt.pojo.User;
import com.jt.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestSpring {

    @Test
    public void test01(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService userService = context.getBean(UserService.class);
        User user = new User();
        user.setId(100);
        user.setUsername("缓存");
        //1.第一次查询时
        userService.findUserById(user);
        //2.第二次查询  走缓存
        userService.findUserById(user);
    }
}

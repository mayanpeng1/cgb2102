package com.jt;

import com.jt.controller.UserController;
import com.jt.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {

    @Test
    public void test01(){
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        // UserController userController = context.getBean(UserController.class);
        UserController userController = (UserController) context.getBean("userController");
        userController.addUser();
    }
}

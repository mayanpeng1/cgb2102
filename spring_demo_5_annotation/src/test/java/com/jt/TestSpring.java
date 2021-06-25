package com.jt;

import com.jt.controller.UserController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {

    @Test
    public void testSpringMVC(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("application.xml");
        UserController userController = (UserController) context.getBean("userController");
        userController.addUser();
        System.out.println("恭喜学会MVC结构");
    }

    //不好用
    @Test
    public void testSpring(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("application-annotation.xml");
        UserController userController = (UserController) context.getBean("userController");
        userController.addUser();
        System.out.println(userController);
    }



    @Test
    public void testController(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("application-annotation.xml");
        UserController userController = (UserController) context.getBean("userController");

        System.out.println(userController);
    }
}

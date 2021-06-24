package com.jt;

import com.jt.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {

    @Test
    public void testDI(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("application.xml");
        User user = context.getBean(User.class);
        System.out.println(user);
    }
}

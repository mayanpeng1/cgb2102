package com.jt;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Calendar;

public class TestSpring {

    @Test
    public void testStatic(){
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        Calendar calendar1 = (Calendar) context.getBean("calendar1");
        System.out.println("当前时间为："+calendar1.getTime());
    }
}

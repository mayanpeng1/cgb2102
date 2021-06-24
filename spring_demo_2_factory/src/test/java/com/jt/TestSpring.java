package com.jt;

import com.jt.pojoo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Calendar;

public class TestSpring {

    @Test
    public void testStatic() {
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        Calendar calendar1 = (Calendar) context.getBean("calendar1");
        System.out.println("当前时间为：" + calendar1.getTime());
    }

    @Test
    public void testInstance() {
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        Calendar calendar2 = (Calendar) context.getBean("calendar2");
        System.out.println("当前时间为：" + calendar2.getTime());

    }


    @Test
    public void testSpringFactory() {
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        Calendar calendar3 = (Calendar) context.getBean("calendar3");
        System.out.println("当前时间为：" + calendar3.getTime());

    }

    //测试单例多例/懒加载
    @Test
    public void testUser() {
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        context.getBean("user");
        context.getBean("user");
        context.getBean("user");
        context.getBean("user");
    }

    //测试声明周期运行
    @Test
    public void testLife() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        //获取对象
        User user = (User) context.getBean("user");
        //3.用户调用方法
        user.say();
        //4.只要容器失败,则对象想回
        context.close();

    }
}
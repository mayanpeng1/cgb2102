package com.jt;

import com.jt.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sun.util.resources.cldr.ss.CalendarData_ss_SZ;

import java.util.Calendar;

public class UserTest {

    //测试方法返回值必须为void
    @Test
    public void testSpring01(){
        //1.通过加载配置文件，创建Spring容器对象  容器创建对象创建
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");

        //2.从容器中获取对象  通过bean 的ID获取对象
        User user = (User) context.getBean("user");
//      User user2 = context.getBean(User.class);
//      User user3 = context.getBean("user",User.class);

        //3.执行方法
        user.say();
    }

    @Test
    public void demo2() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        //1.通过类的路径实例化类型
        Class userClass = Class.forName("com.jt.pojo.User");

        //2.实例化对象
        User user = (User) userClass.newInstance();

        //3.执行
        user.say();

    }
}

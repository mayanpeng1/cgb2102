package com.jt;

import com.jt.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
    public void Demo(){

    }
}

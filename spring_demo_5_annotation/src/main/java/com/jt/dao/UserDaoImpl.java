package com.jt.dao;

import com.jt.pojo.User;
import org.springframework.stereotype.Repository;

/**
 * <bean id="类名首字母小写~~userDaoImpl class=""UserDaoImpl.class">
 * 如果需要修改beanId 则手动添加value属性即可
 *
 * Controller 用来表示Controller层的代码  相当于对象交给Spring管理
 * @Service 用来表示Service层代码
 * @Repository 用来标识持久层
 * @Component 万用注解
 */
@Repository(value = "userDao")
public class UserDaoImpl implements UserDao{

    @Override
    public void addUser(User user) {
        System.out.println("链接数据库执行insert into :"+user);
    }
}

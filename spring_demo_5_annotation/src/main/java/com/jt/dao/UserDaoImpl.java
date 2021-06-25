package com.jt.dao;

import com.jt.pojo.User;
import org.springframework.stereotype.Repository;

/**
 * <bean id="类名首字母小写~~userDaoImpl class=""UserDaoImpl.class">
 * 如果需要修改beanId 则手动添加value属性即可
 */
@Repository(value = "userDao")
public class UserDaoImpl implements UserDao{

    @Override
    public void addUser(User user) {
        System.out.println("链接数据库执行insert into :"+user);
    }
}

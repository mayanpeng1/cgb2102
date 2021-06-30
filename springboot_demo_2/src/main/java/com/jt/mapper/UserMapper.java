package com.jt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jt.pojo.DemoUser;
import org.springframework.stereotype.Repository;

import java.util.List;
//注意事项:basemapper必须添加泛型对象  切记!!!
public interface UserMapper extends BaseMapper<DemoUser> {
    //使用MP 不要重载里面的方法容易解析 异常
    List<DemoUser> findAll();

    //添加用户
    void insertUser(DemoUser user);

    //修改 用户信息
    void updateUser(String oldName, String nowName, String sex);
}

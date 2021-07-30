package com.jt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jt.mapper.UserMapper;
import com.jt.pojo.User;
import com.jt.service.UserService;
import com.jt.vo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.UUID;

/**
 * @author 刘昱江
 * 时间 2021/5/11
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.selectList(null);
    }

    @Override
    public String login(User user) {
        String password = user.getPassword();
        //md5hash相对于MD5冯家安全  没有绝对安全的系统
        String md5Pass = DigestUtils.md5DigestAsHex(password.getBytes());
        user.setPassword(md5Pass);
        //根据其中不为null 的数据当做where 条件
        //sql: select * from user where u = #{u} and p = #{p}
        QueryWrapper<User> queryWrapper = new QueryWrapper<>(user);
        User userDB = userMapper.selectOne(queryWrapper);
        if (userDB==null){
            return null;
        }
        String token = UUID.randomUUID().toString().replace("-", "");
        return token;

    }

    @Override
    public PageResult getUserList(PageResult pageResult) {
        //1.定义分页对象
        IPage<User> page = new Page<>(pageResult.getPageNum(),pageResult.getPageSize());
        //2.构建查询的条件构造器
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //判断传递过来的数据是否为空
        boolean flag = StringUtils.hasLength(pageResult.getQuery());
        //根据判断条件决定是否拼接where 条件
        queryWrapper.like(flag, "username", pageResult.getQuery());
        //MP提供的分页查询的方法,返回值page分页  其他包含分页的数据结果信息
        page = userMapper.selectPage(page,queryWrapper);
        List<User>list = page.getRecords();
        long total = page.getTotal();
        pageResult.setRows(list).setTotal(total);
        return pageResult;
     }

    @Override
    public void updateStatus(User user) {
        userMapper.updateById(user);
    }

    @Override
    public void deleteUserById(Integer id) {
        userMapper.deleteById(id);
    }

    //添加用户

    /**
     * 1.要求将密码加密处理
     * 2.入库/更新得我时间(框架帮助完成)
     * 3.什么是事务:操作成功  数据库提交事务  操作失败  事务回滚
     * 关于事务控制说明:
     *      rollbackFor: 遇到某种异常时,回滚事务
     *      noRollbackFor: 遇到某种异常,不会滚事务
     *      特殊环境下使用, 一般条件下采用默认行为
     * @param user
     */
    @Override
    @Transactional
    public void addUser(User user) {
        String md5Pass = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        user.setPassword(md5Pass);
        user.setStatus(true);//状态默认值为true
        userMapper.insert(user);
    }

    @Override
    public User getUserById(Integer id) {
        User user = userMapper.selectById(id);
        return user;
    }
    //修改用户信息 sql: update user set xxxx where id...
    @Override
    public void updateUser(User user) {
        userMapper.updateById(user);
    }


}

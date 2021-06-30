package com.jt;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jt.mapper.UserMapper;
import com.jt.pojo.DemoUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.xmlunit.util.Mapper;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class TestMp {
    @Autowired
    private UserMapper userMapper;

    @Test
    void insert(){
        DemoUser user = new DemoUser();
        user.setName("MP测试").setSex("男").setAge(19);
        userMapper.insert(user);
    }

    //测试更新操作  修改id=231的数据  name="中午吃什么"  age = 18
    //原则: 根据对象中不为null的属性当做set条件。 set name = "xxx"
    //如果ById的操作,则id必须赋值 弄清Id当做唯一的where条件
    @Test
    void updateById(){
        DemoUser user = new DemoUser();
        user.setName("中午吃什么").setAge(18).setId(231);
        userMapper.updateById(user);
    }

    /*
     * 1.查询id = 21的用户 根据ID查询  1条记录
     * 2.查询name = "白骨精" sex="女"  list
     * 知识点:
     *      1.QueryMapper 条件构造器  拼接wher条件
     *      原则:根据对象中不为null的属性进行拼接where条件
     */
    @Test
    void testSelect(){
        //单一
        DemoUser user = userMapper.selectById(21);
        System.err.println(user);

        //一对多
        DemoUser user2 = new DemoUser();
        user2.setName("白骨精").setSex("女");
        QueryWrapper<DemoUser> queryWrapper = new QueryWrapper<>(user2);
        List<DemoUser> list = userMapper.selectList(queryWrapper);
        System.err.println(list);
    }

    /**
     * 需求:查找age>18  并且为女的信息
     * select * from demo_user where age>18 and sex = '女'
     * 特殊字符:  > (gt)  < (lt)  = (eq)
     *          >= (ge)  <=(le)
     * 默认连接符: and
     */
    @Test
    void testSelect2(){
        QueryWrapper<DemoUser> queryWrapper = new QueryWrapper<>();

        queryWrapper.gt("age", 18)
                    .eq("sex","女");
        List<DemoUser> users = userMapper.selectList(queryWrapper);
        System.err.println(users);
    }

    /**  模糊查询 like
     * 练习like关键字查询
     *      查询name 中包含"精"字的数据
     * select * from demo_user where user like "%精%"
     *      包含      like "%精%"
     *      以精开头   like "精%"   likeRight
     *      以精结尾   like "%精"   likeLeft
     */
    @Test
    void testSelect3(){
        QueryWrapper<DemoUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", "精");
        List<DemoUser> users = userMapper.selectList(queryWrapper);
        for (DemoUser user : users) {
            System.err.println(user);
        }
    }

    /** 关键字  Order By
     * 查询sex = 男的数据 ,以id倒叙排序
     * sql: select * from demo_user where sex = "男" order by id desc
     *  .orderBy()     .orderByDesc()
     */
    @Test
    void testSelect4(){
        QueryWrapper<DemoUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("sex", "男")
                    .orderByDesc("id");
        List<DemoUser> users = userMapper.selectList(queryWrapper);
        for (DemoUser user : users) {
            System.err.println(user);
        }
    }

    /** 多数据查询 in关键字
     * 5. 查询id为 1,3,5,6,7的用户
     * Sql: select * from demo_user where id in (x,x,x)
     */
    @Test
    void testService5(){
        QueryWrapper<DemoUser> queryWrapper = new QueryWrapper<>();
        Integer [] ids = {1,3,5,6,7};
        //List idList = Arrays.asList(ids);//将数组转换为集合
        queryWrapper.in("id", ids);
        List<DemoUser> users = userMapper.selectList(queryWrapper);
        for (DemoUser user : users) {
            System.err.println(user);
        }
    }


}

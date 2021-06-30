package com.jt;

import com.jt.mapper.UserMapper;
import com.jt.pojo.DemoUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootDemo2ApplicationTests {

	@Autowired
	private UserMapper userMapper;

	//数据库查询
	@Test
	void testFindAll() {
		//代理的测试  jdk动态代理

		List<DemoUser> list = userMapper.findAll();
		System.out.println(userMapper.getClass());
		System.out.println(list);
	}

	@Test
	void testInsert(){
		DemoUser user = new DemoUser();
		user.setId(null).setName("mybatis信息").setAge(18).setSex("男");
		userMapper.insertUser(user);
	}

	@Test
	void testUpdate(){
		String oldName = "mybatis信息";
		String nowName = "测试信息";
		String sex = "男";
		userMapper.updateUser(oldName,nowName,sex);
		System.err.println("ok");
	}

	//测试 MybatisPlus
	@Test
	void testSelect(){
		List<DemoUser> users = userMapper.selectList(null);
		System.out.println(users);
	}
}

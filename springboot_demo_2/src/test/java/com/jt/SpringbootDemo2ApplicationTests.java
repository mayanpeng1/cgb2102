package com.jt;

import com.jt.mapper.UserMapper;
import com.jt.pojo.DemoUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLOutput;
import java.util.List;

@SpringBootTest
class SpringbootDemo2ApplicationTests {

	@Autowired
	private UserMapper userMapper;
	@Test
	void contextLoads() {
		List<DemoUser> list = userMapper.findAll();
		System.out.println(list);
	}

}

package com.jt;

import com.jt.pojo.Dept;
import org.apache.catalina.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//在执行测试方法时自动的启动Spring容器
//注意事项:
@SpringBootTest
class SpringbootDemo1ApplicationTests {

	//当容器启动成功之后,SpringBoot负责将对象进行注入
	@Autowired
	private Dept dept;

	//如果没有自动提示set/get方法  1.检查包  2.卸载lombok插件 重新安装
	@Test
	void contextLoads() {
		System.out.println(dept);
	}
}

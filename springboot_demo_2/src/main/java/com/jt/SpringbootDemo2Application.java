package com.jt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//mapper 接口注解的包扫描  以后不需要再次编辑单个@Mapper注解
@MapperScan("com.jt.mapper")
public class SpringbootDemo2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDemo2Application.class, args);
	}

}

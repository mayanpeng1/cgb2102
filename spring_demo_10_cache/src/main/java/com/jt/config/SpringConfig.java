package com.jt.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

//用来自动注入bean的注解,不需要通过BeanFactory去获取 ,省略.xml文件配置
@Configuration
//作用就是根据定义的扫描路径，把符合扫描规则的类装配到spring容器中
@ComponentScan("com.jt")
//创建代理对象
@EnableAspectJAutoProxy
public class SpringConfig {
}

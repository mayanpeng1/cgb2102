package com.jt.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component  //将对象交给Spring容器管理
//加载指定配置文件
@PropertySource(value = "classpath:/dept.properties",encoding = "UTF-8")
@Data   //data是lombok使用最多的 自动生成get/set/toString/equals/hashcode等方法
@Accessors(chain = true) //重写set方法,返回this对象
@NoArgsConstructor  //无参构造
@AllArgsConstructor //全参构造
public class Dept {
    //spel表达式
    @Value("${dept.id}")
    private Integer id;
    @Value("${dept.name}")
    private String name;

    @Value("${dept.id2}")
    private Integer id2;
    @Value("${dept.name2}")
    private String name2;
}

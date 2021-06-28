package com.jt.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)//重写this的set方法
public class DemoUser {
    private Integer id;
    private String name;
    private Integer age;
    private String sex;
}

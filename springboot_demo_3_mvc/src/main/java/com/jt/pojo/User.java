package com.jt.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

//POJO 实体对象中 "必须" 使用包装类型
//规定说明:  1.基本类型有默认值    包装类型的默认值为null
//          2.基本类型中没有多余的方法  对后续的代码取值有问题
@Data
//重写set方法,返回this对象
@Accessors(chain = true) //几乎不用构造方法赋值
public class User {
    private Integer id;
    private String name;
    private String [] hobbys;
    private Dog dog;//为了实现数据封装,必须将对象进行嵌套(引用)

    public String getAge(){
        return "今年18岁了!!!";
    }
}

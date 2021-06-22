package com.jt.pojo;

public class User {

    //反射机制调用时，必然调用对象的无参构造，所以写构造方法时必须先写无参构造方法
    public User(){
        System.out.println("我是一个无参构造");
    }

    public void say(){
        System.out.println("Spring框架");
    }
}

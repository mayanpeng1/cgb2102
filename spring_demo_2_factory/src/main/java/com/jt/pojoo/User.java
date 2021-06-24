package com.jt.pojoo;

public class User {
    private String conn; //数据库连接

    //1.实例化对象
    public User(){
        System.out.println("创建对象");
    }

    //2.初始化方法
    public void init(){
        this.conn = "赋值数据源链接";
        System.out.println(this.conn);
    }

    //3.用户调用的方法
    public void say(){
        System.out.println("我是用户！！！");
    }

    //4.销毁方法
    public void destory(){
        this.conn=null;
        System.out.println("释放资源"+this.conn+"----");
    }

}

package com.jt.factory;

import org.springframework.beans.factory.FactoryBean;

import java.util.Calendar;

public class SpringFactory implements FactoryBean<Calendar> {

    //工厂模式实例化对象的方法
    @Override
    public Calendar getObject() throws Exception {
        return Calendar.getInstance();
    }

    //获取类型
    @Override
    public Class<?> getObjectType() {
        return Calendar.class;
    }

    //默认条件下Spring容器都是单例对象  节省空间

    @Override
    public boolean isSingleton() {
        return true;
    }
}

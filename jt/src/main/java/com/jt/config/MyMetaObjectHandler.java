package com.jt.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    //新增时自动填充  created ,updated
    @Override
    public void insertFill(MetaObject metaObject) {
        Date date = new Date();
        this.setFieldValByName("created", date, metaObject);
        this.setFieldValByName("update", date, metaObject);
    }

    //更新时自动填充
    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("update", new Date(), metaObject);
    }
}

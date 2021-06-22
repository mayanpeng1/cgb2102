package com.jt.factory;

import java.util.Calendar;

public class StaticFactory {

    /*通过静态工厂获取数据*/
    public static Calendar getCalendar(){
        return Calendar.getInstance();
    }
}

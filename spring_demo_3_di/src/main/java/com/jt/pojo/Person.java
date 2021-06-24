package com.jt.pojo;

import java.util.Map;

public class Person {
    private Map map;

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "Person{" +
                "map=" + map +
                '}';
    }
}

package com.jt;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jt.mapper.ItemMapper;
import com.jt.pojo.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@SpringBootTest
class ListTest {

    @Autowired
    ItemMapper itemMapper;

    @Test
    public void getList(){
        QueryWrapper<Item> queryWrapper = new QueryWrapper<>();
        List<Item> list = itemMapper.selectList(queryWrapper);
        list.stream()
                .filter(item -> item.getPrice()>8000)
                .forEach(System.out::println);
    }

    @Test
    public void streamDemo(){
        //创建一个顺序流
        Stream<Integer> stream = Stream.of(1,2,3,4,5,6);

        Stream<Integer> stream1 = Stream.iterate(0,x -> x+3).limit(4);
        stream1.forEach(System.out::println);
    }
}

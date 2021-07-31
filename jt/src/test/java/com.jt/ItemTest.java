package com.jt;

import com.jt.pojo.ItemCat;
import com.jt.service.ItemCatService;
import com.jt.service.impl.ItemCatServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
public class ItemTest {
    @Autowired
    private ItemCatService itemCatService;

    @Test
    public void getItem(){
        Map<Integer, List<ItemCat>> map = itemCatService.getMap();
        System.err.println(map);
        for (Integer integer : map.keySet()) {
            System.err.println("key="+integer+",value="+map.get(integer));
        }
    }

    @Test
    public void getItemCat(){
        List<ItemCat>list = itemCatService.findItemCatList(3);
        for (ItemCat itemCat : list) {
            System.err.println(itemCat);
        }

    }
}

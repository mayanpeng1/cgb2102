package com.jt.service;

import com.jt.pojo.ItemCat;

import java.util.List;
import java.util.Map;

public interface ItemCatService {
    List<ItemCat> findItemCatList(Integer type);
    Map<Integer,List<ItemCat>> getMap();

    void updateStatus(ItemCat itemCat);

    //商品新增业务接口
    void saveItemCat(ItemCat itemCat);

    //删除商品
    void deleteItemCat(Integer id, Integer level);
}

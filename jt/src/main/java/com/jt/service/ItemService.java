package com.jt.service;

import com.jt.pojo.Item;
import com.jt.vo.ItemVO;
import com.jt.vo.PageResult;

public interface ItemService {
    //分页查询 商品列表
    PageResult findItemByPage(PageResult pageResult);

    //修改商品详情 状态
    void updateItemStatus(Item item);

    //删除商品列表
    void deleteItemById(Integer id);

    //实现商品新增
    void saveItem(ItemVO itemVO);
}

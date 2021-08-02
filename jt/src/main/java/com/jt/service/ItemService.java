package com.jt.service;

import com.jt.vo.PageResult;

public interface ItemService {
    //分页查询 商品列表
    PageResult findItemByPage(PageResult pageResult);
}

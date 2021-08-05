package com.jt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jt.mapper.ItemDescMapper;
import com.jt.mapper.ItemMapper;
import com.jt.pojo.Item;
import com.jt.pojo.ItemDesc;
import com.jt.service.ItemService;
import com.jt.vo.ItemVO;
import com.jt.vo.PageResult;
import com.jt.vo.SysResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;


@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private ItemDescMapper itemDescMapper;

    @Override
    public PageResult findItemByPage(PageResult pageResult) {
        //1.定义分页对戏
        IPage<Item> page = new Page<>(pageResult.getPageNum(),pageResult.getPageSize());
        //2.创建查询的条件构造器
        QueryWrapper<Item> queryWrapper = new QueryWrapper();
        //3.判断传递过来的是否是空值
        boolean flag = StringUtils.hasLength(pageResult.getQuery());
        //进行分页查询
        queryWrapper.like(flag, "title", pageResult);
        //4.经过分页查询 获取其中全部的数据集
        //MP提供的分页查询的方法,返回值page分页  其他包含分页的数据结果信息
        page = itemMapper.selectPage(page,queryWrapper);
        Long total = page.getTotal();
        pageResult.setRows(page.getRecords()).setTotal(total);
        //返回分页对象
        return pageResult;
    }

    @Override
    public void updateItemStatus(Item item) {
        itemMapper.updateById(item);

    }

    @Override
    public void deleteItemById(Integer id) {
        itemMapper.deleteById(id);
    }

    //商品新增
    @Override
    @Transactional//事务
    public void saveItem(ItemVO itemVO) {
        //商品对象
        Item item = itemVO.getItem();
        item.setStatus(true);
        //MP已经实现了主键的自动回显 所以ID有值的
        itemMapper.insert(item);

        //商品详情
        ItemDesc itemDesc = itemVO.getItemDesc();
        itemDesc.setId(item.getId());
        itemDescMapper.insert(itemDesc);
    }
}

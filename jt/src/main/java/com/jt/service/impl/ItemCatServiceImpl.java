package com.jt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jt.mapper.ItemCatMapper;
import com.jt.pojo.ItemCat;
import com.jt.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ItemCatServiceImpl implements ItemCatService {
    @Autowired
    private ItemCatMapper itemCatMapper;

    //1.封装一个map集合
    public Map<Integer,List<ItemCat>> getMap(){
        Map<Integer,List<ItemCat>> map = new HashMap<>();
        //1.查询所有的数据信息
        List<ItemCat> list = itemCatMapper.selectList(null);
        //2.将list 集合封装到Map集合中
        for (ItemCat itemCat : list) {
            //规则:
            //没有key  该子集时第一个父级元素的孩子,应该声明父级并且将子级最为第一个子集保存
            //有key   找到父级的自己序列   将子集追加到序列中即可
            if(map.containsKey(itemCat.getParentId())){
                //获取父级的所有已知子集
                List<ItemCat> catList = map.get(itemCat.getParentId());
                catList.add(itemCat);//在父级的value中追加 子集
            }else {
                //没有父级 id  则  设置父级id为Key    list为value
                List<ItemCat> initList = new ArrayList<>();
                initList.add(itemCat);//设置父级的value
                map.put(itemCat.getParentId(), initList);
            }
        }
        return map;
    }

    @Override
    public List<ItemCat> findItemCatList(Integer type) {
        Map<Integer,List<ItemCat>> map = getMap();
        if(type == 1){
            return map.get(0);
        }

        if(type == 2){
            return getLevel2(map);
        }
        return getLevel3(map);
    }

    //2级菜单
    private List<ItemCat> getLevel2(Map<Integer, List<ItemCat>> map) {
        //获取1级菜单
        List<ItemCat> list = map.get(0);
        //获取二级菜单
        for (ItemCat itemCat : list) {//遍历二级菜单
            //二级菜单的 key 是 一级菜单的 id
            List<ItemCat> childCat = map.get(itemCat.getId());
            itemCat.setChildren(childCat);
        }
        return list;
    }

    private List<ItemCat> getLevel3(Map<Integer, List<ItemCat>> map) {
        //1.获取2级商品分类信息  1级里面套二级
        List<ItemCat> list = getLevel2(map);
        for (ItemCat itemCat : list) {
            //获取2级商品分类信息
           List<ItemCat> level2 = itemCat.getChildren();
           //根据2级查询3级信息
           if(level2 == null) continue;
           //三级
            for (ItemCat cat : level2) {
                List<ItemCat> leven3 = map.get(cat.getId());
                cat.setChildren(leven3);
            }
        }

        return list;
    }

    //修改菜单状态
    @Override
    public void updateStatus(ItemCat itemCat) {
        itemCatMapper.updateById(itemCat);
    }

    @Override
    public void saveItemCat(ItemCat itemCat) {
        itemCatMapper.insert(itemCat);
    }

    //删除商品
    @Override
    public void deleteItemCat(Integer id, Integer level) {
        //如果是一级菜单
        if(level==3){
            itemCatMapper.deleteById(id);
        }
        //如果是二级商品
        if(level==2){
            //先找到二级  菜单的  子级 3级菜单
            QueryWrapper<ItemCat> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("parent_id", id);
            itemCatMapper.delete(queryWrapper);
            //然后再删除 二级菜单
            itemCatMapper.deleteById(id);
        }

        //如果是一级菜单
        if(level==1){
            //先找到所有的二级菜单
            QueryWrapper<ItemCat> queryWrapper = new QueryWrapper();
            queryWrapper.eq("parent_id", id);
            List<Object> towList = itemCatMapper.selectObjs(queryWrapper);
            for (Object towId : towList) {
                //根据二级菜单id  找到 三级菜单id  进行删除
                QueryWrapper<ItemCat> queryWrapper2 = new QueryWrapper<>();
                queryWrapper2.eq("parent_id", towId);
                itemCatMapper.delete(queryWrapper2);

                //再根据2级id  删除 2级菜单
                Integer tow = (Integer) towId;
                //删除二级菜单
                itemCatMapper.deleteById(tow);
            }
            //删除三级
            itemCatMapper.deleteById(id);

        }



    }
}

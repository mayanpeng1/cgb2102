package com.jt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jt.mapper.RightsMapper;
import com.jt.pojo.Rights;
import com.jt.service.RightsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RightsServiceImpl implements RightsService {

    @Autowired
    private RightsMapper rightsMapper;

    /**
     * 1.查询一级列表信息  条件parent_id = 0
     * 2.查询一级目录下的二级列表信息  条件 parent_id = 1 的ID
     */
    @Override
    public List<Rights> getRightsList() {
        QueryWrapper<Rights> queryWrapper = new QueryWrapper<>();
        //获取父级菜单列表
        queryWrapper.eq("parent_id", 0);
        List<Rights> list = rightsMapper.selectList(queryWrapper);
        //遍历父级菜单
        for (Rights rights : list) {
            QueryWrapper<Rights>queryWrapper2 = new QueryWrapper<>();
            //根据一级ID ,查询子级信息
            queryWrapper2.eq("parent_id", rights.getId());
            List<Rights> children = rightsMapper.selectList(queryWrapper2);
            //将对象进行封装
            rights.setChildren(children);
        }
        return list;
    }
}

package com.jt.controller;

import com.jt.pojo.Item;
import com.jt.service.ItemService;
import com.jt.vo.ItemVO;
import com.jt.vo.PageResult;
import com.jt.vo.SysResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    /**
     * 业务说明: 实现商品列表分页查询
     * queryItemInfo 分页对象接收
     * 返回值: SysResult(分页对象)
     * @param pageResult
     * @return
     */
    @GetMapping("/getItemList")
    public SysResult getItemList(PageResult pageResult){
        pageResult = itemService.findItemByPage(pageResult);
        return SysResult.success(pageResult);
    }

    @PutMapping("/updateItemStatus")
    public SysResult updateItemStatus(@RequestBody  Item item){
        System.err.println("updateid="+item.getId());
        itemService.updateItemStatus(item);
        return SysResult.success();
    }

    @DeleteMapping("/deleteItemById")
    public SysResult deleteItemById(Integer id){
        System.err.println("deleteItemById:"+id);
        itemService.deleteItemById(id);
        return SysResult.success();
    }

    /**
     * 实现商品新镇操作
     * 参数:{item,itemDesc}
     */

    @PostMapping("/saveItem")
    public SysResult saveItem(@RequestBody ItemVO itemVO){
        itemService.saveItem(itemVO);
        return SysResult.success();
    }
}

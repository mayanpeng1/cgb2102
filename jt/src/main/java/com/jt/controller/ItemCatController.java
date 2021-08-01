package com.jt.controller;

import com.jt.pojo.ItemCat;
import com.jt.service.ItemCatService;
import com.jt.vo.SysResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/itemCat")
public class ItemCatController {
    @Autowired
    private ItemCatService itemCatService;

    @GetMapping("/findItemCatList/{type}")
    public SysResult findItemCatList(@PathVariable Integer type){
        List<ItemCat> data = itemCatService.findItemCatList(type);
        return SysResult.success(data);
    }

    @PutMapping("/status/{id}/{status}")
    public SysResult updateStatus(ItemCat itemCat){
        itemCatService.updateStatus(itemCat);
        return SysResult.success();
    }

    @PostMapping("/saveItemCat")
    public SysResult saveItemCat(@RequestBody ItemCat itemCat){
        itemCatService.saveItemCat(itemCat);
        return SysResult.success();
    }

    @DeleteMapping("/deleteItemCat")
    public SysResult deleteItemCat(Integer id,Integer level){
        itemCatService.deleteItemCat(id,level);
        return SysResult.success();
    }
}

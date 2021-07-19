package com.jt.controller;

import com.jt.pojo.Rights;
import com.jt.service.RightsService;
import com.jt.vo.SysResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rights")
@CrossOrigin  //跨域资源共享
public class RightsController {

    @Autowired
    private RightsService RightsService;

    @GetMapping("/getRightsList")
    public SysResult getRightsList(){
        List<Rights> data = RightsService.getRightsList();
        return SysResult.success(data);
    }

}

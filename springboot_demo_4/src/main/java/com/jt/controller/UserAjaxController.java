package com.jt.controller;

import com.jt.pojo.User;
import com.jt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserAjaxController {

    @Autowired
    private UserService userService;

    @RequestMapping("/deleteAjaxUser")

    public String deleteAjaxUser( Integer id){
        System.err.println(id);
        userService.deleteUser(id);
        System.err.println("OK");
        return "ok";
    }
}

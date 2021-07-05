package com.jt.controller;

import com.jt.pojo.User;
import com.jt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    // @RequestMapping("/deleteAjaxUser")
    // @ResponseBody
    // public String deleteAjaxUser(@PathVariable Integer id){
    //     System.err.println(id);
    //     userService.deleteUser(id);
    //     System.err.println("OK");
    //     return "ok";
    // }

    @RequestMapping("/userAjaxA")
    public String userAjaxA(){
        return "userAjaxA";
    }

    /**
     * 要求跳转到userAjax页面中
     * @return
     */
    @RequestMapping("/userAjax")
    public String userAjax(){
        return "userAjax";
    }

    /**
     * 接收Ajax请求  /findAjaxUser 查询所有的用户信息
     * 返回  Json字符串
     * @return
     */
    @RequestMapping("/findAjaxUser")
    @ResponseBody
    public List<User> findAjaxUser(){
        return userService.findAll();
    }


    @RequestMapping("/demo")
    @ResponseBody
    public String demo(){
        return "框架整合初步完成";
    }

    /**
     * 查询所有的用户列表数据  在  userList。html中展现数据
     */
    @RequestMapping("/userList")
    public String userList(Model model){
        //1.查询业务层获取数据
        List<User> userlist = userService.findAll();
        //2.将数据保存到model 对象中返回给页面
        model.addAttribute(userlist);
        return "userList";
    }

    /**
     * 需求:利用restFul 实现用户数据新增
     *      新增之后重定向到userList.html页面
     * 优化策略:
     *      1.如果有多个参数提交,则可以使用对象接收,但是要求
     *      参数名称必须与属性名称一致
     * @param user
     * @return
     */
    @RequestMapping("/user/{name}/{age}/{sex}")
    public String userAdd(User user){
        userService.insertUser(user);
        System.err.println("OK");
        return "redirect:/userList";
    }

    /**
     * 需求 1:   用户修改   /user/id/name
     * 需求 2:   删除数据   /user/id
     */

    @RequestMapping("/user/{id}/{name}")
    public String updateUser(User user){
        userService.updateUser(user);
        System.err.println("update-OK");
        return "redirect:/userList";
    }
    @RequestMapping("/user/{id}")
    public String deleteUser(@PathVariable Integer id){
        System.err.println(id);
        userService.deleteUser(id);
        System.err.println("delete-OK");
        return "redirect:/userList";
    }

}

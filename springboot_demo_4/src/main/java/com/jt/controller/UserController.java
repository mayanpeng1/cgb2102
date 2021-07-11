package com.jt.controller;

import com.jt.pojo.User;
import com.jt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin//ajax跨域请求
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

    @GetMapping("/getUser")
    @ResponseBody
    public List<User> getUser(){
        List<User> data = userService.findAll();
        System.err.println("1");
        return data;
    }

    @GetMapping("/getUserById")
    @ResponseBody
    public User getUserById(Integer id){
        System.err.println("getUserById");
        return userService.getUserById(id);
    }

    @GetMapping("/getUser/{id}")
    @ResponseBody
    public User getUser1(@PathVariable Integer id){
        return userService.getUserById(id);
    }

    @PostMapping("/addUser")
    @ResponseBody
    /**
     * 接收post请求:
     * 前端传递参数是一个JSON串
     *  {"name":"xxx","age":"xx","sex":"xxx"}
     *  解决方案: 可以将JSON数据根据key:value  转化为对象(get/set方法)
     */
    public String addUser(@RequestBody User user){
        userService.insertUser(user);
        return "新用户添加成功!";
    }

    @DeleteMapping("/deleteUser/{id}")
    @ResponseBody
    public String delete(@PathVariable  Integer id){
        System.err.println("22");
        userService.deleteUser(id);
        return "删除成功";
    }

    @PutMapping("/updateUserVUE")
    @ResponseBody
    public String updateUserVUE(@RequestBody User user){
        userService.updateUser(user);
        System.err.println("修改");
        return "修改成功!";
    }
}

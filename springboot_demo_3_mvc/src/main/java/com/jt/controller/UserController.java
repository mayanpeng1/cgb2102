package com.jt.controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {
    /**
     * 测试@RequestParam注解
     * @RequestParam 参数说明:
     *  1.name/value    接收参数的名称
     *  2.required      默认值true  该数据项为必填项
     *  3.defaultValue  设定数据默认值  如果参数为null 则设定默认值
     */
    @RequestMapping("/addUser")
    public String addUserParam(
            @RequestParam(value = "id",required = true ,defaultValue = "1001") Integer id,
            @RequestParam(value = "name",required = true ,defaultValue = "张三") String name
    ){
        System.err.println("参数:"+id+","+name);
        return "success";
    }

    /**
     * 请求路径 : httl://localhost:8090/addUser
     * 请求参数: id:100   name:张三
     * request/response对象说明 只要用户调用就会自动赋值
     * servlet缺点: 接收的参数都是String类型
     * SpringMVC赋值:
     *      内部根据request.getParameter("id") 方式获取数据
     * @param
     * @return
     */
    //@RequestMapping("/addUser")
    public String addUser(Integer id , String name){
        System.err.println("参数:"+id+","+name);
        return "success";
    }


    /*@RequestMapping("/addUser")
    public String addUser(HttpServletRequest request){
        //request.getParameter()  获取指定name 中的值
        Integer id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        System.err.println("参数:"+id+","+name);
        return "success";
    }*/

    //简化数据传递
    @RequestMapping("/user")
    public String toUser(Model model){
        model.addAttribute("id", 11111);
        model.addAttribute("name", "SpringMVC");
        return "user";
    }

    /**
     * mvc底层数据传输
     * ModelAndView:
     *      1.model 封装数据的
     *      2.View  封装视图页面的
     */
    // @RequestMapping("/user")
    // public ModelAndView toUser(){
    //     ModelAndView modelAndView = new ModelAndView();
    //     //封装数据
    //     modelAndView.addObject("id",1);
    //     modelAndView.addObject("name","安琪拉");
    //     //封装页面数据
    //     modelAndView.setViewName("user");
    //     return modelAndView;
    // }
}

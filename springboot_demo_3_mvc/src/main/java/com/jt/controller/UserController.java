package com.jt.controller;

import com.jt.pojo.User;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Controller
public class UserController {
    /**
     * 在内部封装引用对象,使用User接收全部数据
     * 通过对象.的方式 封装所属关系.
     */
    @RequestMapping("/addUser")
    public String addUserDog(User user){
        System.err.println(user);
        return "success";
    }


    /**
     * 使用对象的方式接受数据
     * 对象赋值的原理:
     *      要求:POJO 对象中必须有get/set方法
     *      1.当用户提交数据后 利用对象的set方法为属性赋值
     */
    //@RequestMapping("/addUser")
    public String addUser(User user){
        System.err.println(user);
        return "success";
    }

    /**
     * 同名提交信息
     * url参数: id:   name:  hobbys:
     * 参数提交的形式:springMVC自动的将参数进行了 "," 号拼接
     *
     * springMVC优化
     *  1.可以根据,号  自动的将字符串进行拆分
     *  2.如果数据类型不是String类型,这可以自动的转化
     *
     *  总结: 如果以后遇到了同名提交问题,则使用 数组或者 可变参数类型接收
     *  String...hobbys 可变参数类型  实质就是数组
     */
    //@RequestMapping("/addUser")
    public String addUserHobbys(Integer id , String name , String[] hobbys){
        System.err.println("参数:"+id+","+name+",爱好为:"+ Arrays.toString(hobbys));
        return "success";
    }


    /**
     * 测试@RequestParam注解
     * @RequestParam 参数说明:
     *  1.name/value    接收参数的名称
     *  2.required      默认值true  该数据项为必填项
     *  3.defaultValue  设定数据默认值  如果参数为null 则设定默认值
     */
    //@RequestMapping("/addUser")
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

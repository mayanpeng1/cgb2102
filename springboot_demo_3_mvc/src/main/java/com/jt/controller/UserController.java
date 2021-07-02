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
     * 测试转发和重定向
     * 1.准备一个请求 findUser请求
     * 2.要求用户 转发到 findDog请求中
     * 3.关键字  forward: 转发的是一个请求
     *          redirect: 多次请求多次响应
     * 4.特点:
     *      1.转发时 会携带用户提交的数据
     *      2.转发时 用户浏览器的地址不会发生改变
     *      3.重定向时  由于是多次请求,所以不会携带用户的数据
     *      4.重定向时  由于是多次请求,所以用户的浏览器地址会发生变化
     * 5.转发的意义:
     *      如果直接转发到页面中,如果页面需要额外的参数处理,则没有执行
     *      如果在该方法中添加业务处理,则方法的耦合性高,不方便后续维护
     *      所以方法应该尽可能松耦合
     *
     * 6.什么时候使用转发/什么时候使用重定向
     *      1.如果需要携带参数  使用转发
     *      2.如果一个业务已经完成  需要一个新的开始    使用重定向
     */
    @RequestMapping("/findUser")
    public String findUser(String name){
        //return 本身就是一个转发
        // return "user1";
        // return "dog"; 页面耦合性高
        // return "forward:/findDog";  转发到findDog请求
        return "redirect:/findDog";  //重定向到findDog请求
    }

    //需要将name属性返回给页面
    @RequestMapping("/findDog")
    public String findDog(String name,Model model){
        System.err.println("动态获取name属性值:"+name);
        model.addAttribute("name", name+"汪汪汪");
        return "dog";
    }


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

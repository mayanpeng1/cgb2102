package com.jt.aop;

import com.jt.pojo.User;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

//（把普通pojo实例化到spring容器中，相当于配置文件中的  <bean id="" class=""/>）
@Component
@Aspect//作用是把当前类标识为一个切面供容器读取
public class SpringAOP {
    private static Map<Integer,User> map = new HashMap();
    /**
     * 需求: 用户第一次查询走目标方法
     *      用户第二次执行走缓存
     * 判断依据: 如何判断用户是否是第一次执行
     *          通过Map集合进行判断 有数据 证明不是第一次查询
     * 执行步骤:
     *      1.获取用户查询的参数
     *      2.判断map集合中是否有该数据
     *      true:  从map集合中get之后返回
     *      false: 执行目标方法,之后将user保存在mao当中
     *
     * @return
     */
    //切入点表达式:拦截service包中的所有方法
    @Around("execution(* com.jt.service..*.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result=null;//定义 joinPoint的返回结果

        //ProceedingJoinPoint joinPoint 连接点
        //1.获取目标对象的参数
        Object [] args = joinPoint.getArgs();
        //2.强制类型转换为对象
        User user = (User) args[0];
        //3.判断mao集合中是否有该数据  user的id是唯一的标识
        int id = user.getId();
        if(map.containsKey(id)){
            //map 中有数据
            System.out.println("AOP缓存执行");
            return map.get(id);
        } else {
            //map中没有数据  执行目标方法
            result = joinPoint.proceed();//执行目标方法
            //将user对象保存到map中
            map.put(id, user);
            System.out.println("AOP执行目标方法");
        }

        return result;
    }
}

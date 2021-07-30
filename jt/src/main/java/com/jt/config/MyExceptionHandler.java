package com.jt.config;

import com.jt.vo.SysResult;
import org.apache.ibatis.session.SqlSessionException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//@ControllerAdvice  + @ResponseBody
@RestControllerAdvice//全局异常处理  返回值为JSON
public class MyExceptionHandler {

    @ExceptionHandler({RuntimeException.class, SqlSessionException.class})
    public Object handler(Exception e){
        //将报错信息控制台打印
        e.printStackTrace();
        return SysResult.fall();
    }
}

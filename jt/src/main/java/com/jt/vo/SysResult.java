package com.jt.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class SysResult {
    private Integer status;//定义状态码
    private String success;//错误信息
    private Object data;//服务器的返回值类型

    //重载:
    public static SysResult fall(){
        return new SysResult(201,"",null);
    }

    public static SysResult success(){
        return new SysResult(200,"服务器处理成功",null);
    }

    public static SysResult success(Object data){
        return new SysResult(200,"服务器处理成功",data);
    }

    public static SysResult success(String msg,Object data){
        return new SysResult(200,msg,data);
    }
}

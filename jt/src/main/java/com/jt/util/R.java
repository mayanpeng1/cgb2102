package com.jt.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class R<T> {
    private Integer status;//定义状态码  200成功  201失败
    private String message;//错误信息
    private T data;//值

    //响应成功
    public static R ok(){
        return new R().setStatus(State.OK).setMessage("OK");
    }

    //响应成功传递数据
    public static <T> R<T> ok(T data){
        return new R().setStatus(State.OK).setMessage("OK").setData(data);
    }

    public static R failure(Integer state,String message){
        return new R().setStatus(state).setMessage(message);
    }

    public static R failure(Integer state,Throwable e){
        return new R().setStatus(state).setMessage(e.getMessage());
    }

    public interface State{
        int OK = 200;
        int ERROR = 201;
    }
}

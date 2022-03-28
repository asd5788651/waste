package com.waste.my.util;

/**
 * @Author 10447
 * @Date 2022/3/11 22:08
 * @Version 1.0
 */

public class ResultUtil {

   final static  Result result=new Result();
    public static Result success(){
        result.setCode(0);
        result.setMessage("success");
        return  result;
    }

    public static Result success(Object data){
        result.setCode(0);
        result.setData(data);
        result.setMessage("success");
        return  result;
    }
    public static Result failed(String message){
        result.setCode(-1);
        result.setMessage(message);
        return  result;
    }
}

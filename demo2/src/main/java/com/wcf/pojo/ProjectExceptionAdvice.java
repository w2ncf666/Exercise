package com.wcf.pojo;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProjectExceptionAdvice {
    @ExceptionHandler(SystemException.class)
    public String doSystemException(SystemException systemException){
        System.out.println("不能删除第三本书");
        return ("返回代码:"+systemException.getCode()+"  返回消息:"+systemException.getMessage());
    }


@ExceptionHandler(RuntimeException.class)
    public String doNumberFormatException(){
        System.out.println("请正确输入格式!");
        return ("请正确输入格式!");
    }


@ExceptionHandler(Exception.class)
    public String doException(){
        System.out.println("系统错误!");
        return ("请速度联系管理员温超凡!!");
    }
}

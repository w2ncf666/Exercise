package com.wcf.pojo;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
/*要被springmvc扫描到*/
@RestControllerAdvice//@RestControllerAdvice用于标识当前类为REST风格对应的异常处理器
public class ProjectExceptionAdvice {

@ExceptionHandler(SystemException.class)
    public Result doSystemException(SystemException systemException){
        System.out.println("systemErr...");
        return new Result(systemException.getCode(),systemException.getMessage());

    }

    @ExceptionHandler(Exception.class)
    public Result doException(Exception exception){
        System.out.println("异常处理..");
        return new Result(333,null,"傻逼");
    }
}


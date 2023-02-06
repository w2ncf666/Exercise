package com.wcf.pojo;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

/*@RestControllerAdvice*/
public class GlobalExceptionAdvice {

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public R<String> doReDouble(){

        System.out.println("捉到");
        return R.error("用户名重复");
    }
}

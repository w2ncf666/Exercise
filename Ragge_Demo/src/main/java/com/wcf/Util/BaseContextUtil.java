package com.wcf.Util;

public class BaseContextUtil {


    private static ThreadLocal<Long> threadLocal=new ThreadLocal<>();


    public static void setCurrentId(Long id){
        threadLocal.set(id);
    }


    public static Long getCurrentId(){
        return threadLocal.get();
    }
}

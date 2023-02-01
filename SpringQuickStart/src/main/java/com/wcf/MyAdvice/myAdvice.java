package com.wcf.MyAdvice;

import com.wcf.text.people;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class myAdvice {

    @Pointcut("execution(* com.wcf.text.textBean.eat(..))")
    private void pt(){}

    /*@Before("pt()")*/
    public void method(){
        System.out.println("增强切面方法????");
    }

    /*@Around("pt()")*/
    public Object Around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕通知测试qian");
        System.out.println("环绕通知测试qian");
        Signature signature = pjp.getSignature();
        //System.out.println(Arrays.toString(pjp.getArgs()));
        people people=new people();
        people.setName("立下龙");
        Object[] args = pjp.getArgs();
        args[0]=people;
        System.out.println(signature);
        System.out.println(signature.getDeclaringTypeName());
        System.out.println(signature.getName());
        Object ret=pjp.proceed(args);
        ret=9875623;
        System.out.println("环绕通知测试后");
        return ret;
    }

   // @AfterReturning(value = "pt()",returning = "ret")
    public void afterReturning(JoinPoint jp,int ret){
        System.out.println("返回后测试qian");
        Signature signature = jp.getSignature();
        //System.out.println(Arrays.toString(pjp.getArgs()));
        people people=new people();
        people.setName("立下龙");
        Object[] args = jp.getArgs();
        args[0]=people;
        System.out.println(signature);
        System.out.println(signature.getDeclaringTypeName());
        System.out.println(signature.getName());
        ret=55523423;
        System.out.println("advice的"+ret);
    }
}

package org.learn.spring;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class OurAspect {

    @Pointcut("execution(* org.learn.spring.aop.*.*(..))")
    public void doPointCut(){

    }

    /* Types of point cut execution...*/
    
    @Before("doPointCut()")
    public void somethingBefore(){
        System.out.println("Method execution starting...");
    }

    @After("doPointCut()")
    public void somethingAfter(){
        System.out.println("Method execution finished...");
    }

    @Around("doPointCut()")
    public String somethingAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Reached to the point..");
        String s = (String) joinPoint.proceed();
        return s = "What a powerful tool it is..";     // This will change the given string....

    }

}

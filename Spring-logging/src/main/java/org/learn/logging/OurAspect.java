package org.learn.logging;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class OurAspect {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    @Pointcut("execution(* org.learn.logging.aop.*.*(..))")
    public void doPointCut(){

    }

    /* Types of point cut execution...*/

  /*  @Before("doPointCut()")
    public void somethingBefore(){
        System.out.println("Method execution starting...");
    }

    @After("doPointCut()")
    public void somethingAfter(){
        System.out.println("Method execution finished...");
    }
*/
    @Around("doPointCut()")
    public String somethingAround(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("Reached to the point..");
        String s = (String) joinPoint.proceed();
        return s = "What a powerful tool it is..";     // This will change the given string....

    }

}

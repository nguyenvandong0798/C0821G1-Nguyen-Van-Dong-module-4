package com.codegym.bt.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class BookAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @After("execution(* com.codegym.bt.controller.BookController.*(..))")
    public void logAfterMethodReturn(JoinPoint joinPoint){
        String nameMethod = joinPoint.getSignature().getName();
//        System.out.println(nameMethod);
        logger.error("ten phuong thuc "+ nameMethod);
    }
}

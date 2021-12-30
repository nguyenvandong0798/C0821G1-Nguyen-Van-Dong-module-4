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
    static int browserBook = 0;
    static int returnBook = 0;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @AfterThrowing("execution(* com.codegym.bt.controller.BookController.*(..))")
    public void logAfterMethodReturn(JoinPoint joinPoint) {
        String nameMethod = joinPoint.getSignature().getName();
        logger.error("method name is: " + nameMethod);
    }

    @After("execution(* com.codegym.bt.controller.BookController.*(..))")
    public void countLogAfterMethodReturn(JoinPoint joinPoint) {
        String nameMethod = joinPoint.getSignature().getName();
        if (nameMethod.equals("browser")) {
            System.out.println("method name is: " + nameMethod);
            System.out.println("browser times: " + ++browserBook);
        } else if (nameMethod.equals("returnBook")) {
            System.out.println("method name is: " + nameMethod);
            System.out.println("return times: " + ++returnBook);
        } else {
            logger.error("method name is: " + nameMethod);
        }
    }
}

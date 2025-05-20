package com.dss.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.postgresql.shaded.com.ongres.scram.common.util.Preconditions;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    /*

        @Before("execution (* com.dss.serviceImpl.TaskServiceImpl.createTask(..))")
        public void loggableMethod() {
            System.out.println("Aspect log before called");
        }
    *//*
    @After("execution(* com.dss.serviceImpl.TaskServiceImpl.createTask(..))")
    public void loggableMethod() {
        System.out.println("After Executing the tasks.. ");
    }
*/


    /*   @Around("execution(* com.dss.serviceImpl.*.*(..))")
       public Object loggableMethhod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

           System.out.println("Before Executing task.. ");
           Object proceed = proceedingJoinPoint.proceed();
           System.out.println("After executing the task..");
           return proceed;
       }
   */
    @Pointcut("execution(* com.dss.serviceImpl.*.*(..))")
    public void doAccess() {
    }

    @Around("doAccess()")
    public Object loggableMethhod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        System.out.println("Before Executing task.. ");
        Object proceed = proceedingJoinPoint.proceed();
        System.out.println("After executing the task..");
        return proceed;
    }

    @AfterReturning("doAccess()")
    public void returningMethod() {
        System.out.println("RETURNED Executing task.. ");
    }
}

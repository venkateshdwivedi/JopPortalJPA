package com.example.jobportaljpa.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceMonitorAspect {

     private static final Logger LOGGER=LoggerFactory.getLogger(PerformanceMonitorAspect.class);

    @Around("execution(* com.example.jobportaljpa.service.JobService.*(..))")
    public Object monitorTime(ProceedingJoinPoint jp) throws Throwable{
        long start =System.currentTimeMillis();

        Object obj=jp.proceed();
        long end =System.currentTimeMillis();

        LOGGER.info("time taken for : "+ jp.getSignature().getName()+ " " + (end-start) + "ms");

        return obj;

    }
    
}

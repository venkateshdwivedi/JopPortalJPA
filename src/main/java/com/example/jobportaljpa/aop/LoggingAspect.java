package com.example.jobportaljpa.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    private static final Logger LOGGER=LoggerFactory.getLogger(LoggingAspect.class);

    // @Before("execution(* com.example.jobportaljpa.service.JobService.*(..))") // for all methods
    
    @Before("execution(* com.example.jobportaljpa.service.JobService.getjob(..))")
    public void logMethodCall(JoinPoint jp){
        LOGGER.info("method called "+ jp.getSignature().getName());
    }

    @After("execution(* com.example.jobportaljpa.service.JobService.getjob(..))")
    public void logMethodexecuted(JoinPoint jp){
        LOGGER.info("method executed "+ jp.getSignature().getName());
    }
}

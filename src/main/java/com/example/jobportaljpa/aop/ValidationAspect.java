package com.example.jobportaljpa.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidationAspect {

    private static final Logger LOGGER=LoggerFactory.getLogger(ValidationAspect.class);

    @Around("execution(* com.example.jobportaljpa.service.JobService.getjob(..)) && args(id) ")
    public Object validateandupdate(ProceedingJoinPoint jp,int id) throws Throwable{

        //changing value of id before method getjob executes
        if(id<0){
            LOGGER.info("post id is negative,updating it");
            id=-id;
            LOGGER.info("post id updated to: "+id);
        }

        Object obj= jp.proceed(new Object[]{id});// basically passing changed value to method

        return obj;
    }
}

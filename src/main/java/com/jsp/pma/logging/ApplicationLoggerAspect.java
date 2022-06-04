package com.jsp.pma.logging;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;

import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class ApplicationLoggerAspect {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Pointcut("within(com.jsp.pma.controller..*)")
    public void definePackagePointcuts() {
        // empty method just to name the location specify in the pointcut
    }


    @After("definePackagePointcuts()")
    public void logBefore(JoinPoint jp) {
        log.debug("\n \n \n");
        log.debug("************ After Method Execution ********** \n {}.{} () with arguments[s] = {}",
                jp.getSignature().getDeclaringTypeName(),
                jp.getSignature().getName(),
                Arrays.toString(jp.getArgs()));
        log.debug("_________________________________");
    }
}
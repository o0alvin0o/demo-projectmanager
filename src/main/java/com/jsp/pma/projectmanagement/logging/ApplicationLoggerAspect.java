package com.jsp.pma.projectmanagement.logging;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;

import org.slf4j.Logger;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ApplicationLoggerAspect {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Pointcut("within(com.jsp.pma.projectmanagement.controller..*)")
    public void definePackagePointcuts() {
        // empty method just to name the location specify in the pointcut
    }


    @After("definePackagePointcuts()")
    public void log() {
        log.debug(" ------------------------- ");
    }
}

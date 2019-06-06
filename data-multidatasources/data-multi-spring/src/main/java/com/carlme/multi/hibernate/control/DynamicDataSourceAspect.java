package com.carlme.multi.hibernate.control;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class DynamicDataSourceAspect {
    @Pointcut("execution (public service.impl..*.*(..))")
    public void serviceExecution(){}

    @Before("serviceExecution()")
    public void setDynamicDataSource(JoinPoint jp) {
        for(Object o : jp.getArgs()) {
            //处理具体的逻辑 ，根据具体的境况CustomerContextHolder.setCustomerType()选取DataSource
        }
    }
}
package com.carlme.multi.mybatis.aop.datautil;

import com.carlme.multi.mybatis.aop.annotation.DataSourceType;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class DataSourceAop {

	@Before("execution(* com.carlme.multi.mybatis.aop.mapper..*(..))")
	public void setDataSource(JoinPoint joinPoint) {

		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

		Method method = methodSignature.getMethod();

		DataSourceType dataSourceType = method.getAnnotation(DataSourceType.class);
		if (dataSourceType != null && DbContextHolder.DATA_SOURCE_SLAVE.equals(dataSourceType.value())) {
			DbContextHolder.setDbType(DbContextHolder.DATA_SOURCE_SLAVE);
		}
	}
}

package com.carlme.multi.mybatis.aop.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName: DataSourceType
 * @Description: 数据源类型
 * @Auther: SuperWang
 * @Date: 2019/6/10 16:32
 * @Vsersion: 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
@Documented
public @interface DataSourceType {

	/**
	 * 数据源
	 */
	String value() default  "";

	/**
	 * 数据源的描述
	 */
	String description() default "";

}

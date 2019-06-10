package com.carlme.multi.mybatis.aop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.carlme.multi.mybatis.aop.mapper")
@SpringBootApplication
public class MultiMybatisAopApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultiMybatisAopApplication.class, args);
	}

}

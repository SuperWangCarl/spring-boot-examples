package com.carlme.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.carlme.mybatisplus.persistence.mapper")
@SpringBootApplication
public class MybatisPlusApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybatisPlusApplication.class, args);
	}

}

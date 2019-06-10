package com.carlme.multi.mybatis.pack;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.carlme.multi.mybatis.pack.mapper")
@SpringBootApplication
public class MultiMybatisPackApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultiMybatisPackApplication.class, args);
	}

}

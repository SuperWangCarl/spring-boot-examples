package com.carlme.multi.mybatisplus;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.carlme.mybatisplus.persistence.mapper")
@SpringBootApplication(exclude = DruidDataSourceAutoConfigure.class)
public class MultiMybatisPlusApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultiMybatisPlusApplication.class, args);
	}

}

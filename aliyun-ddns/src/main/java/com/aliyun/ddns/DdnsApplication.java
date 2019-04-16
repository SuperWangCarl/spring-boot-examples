package com.aliyun.ddns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DdnsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DdnsApplication.class, args);
	}

}

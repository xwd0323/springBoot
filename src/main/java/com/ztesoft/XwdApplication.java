package com.ztesoft;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
@MapperScan("com.ztesoft.dao.*")
public class XwdApplication {

	public static void main(String[] args) {
		SpringApplication.run(XwdApplication.class, args);
	}
}

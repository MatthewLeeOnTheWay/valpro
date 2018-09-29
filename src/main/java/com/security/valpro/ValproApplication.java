package com.security.valpro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan("com.security.valpro.dao")
public class ValproApplication {

	public static void main(String[] args) { SpringApplication.run(ValproApplication.class, args);
	}
}

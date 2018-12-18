package com.security.valpro;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableDubboConfiguration
@EnableCaching
public class ValproApplication {
	public static void main(String[] args) { SpringApplication.run(ValproApplication.class, args);
	}
}

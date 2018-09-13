package com.cncompute;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cncompute.dao")
public class RadiationMgtApplication {

	public static void main(String[] args) {
		SpringApplication.run(RadiationMgtApplication.class, args);
	}
}

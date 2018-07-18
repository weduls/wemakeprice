package com.wemakeprice.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.wemakeprice.*" })
public class WemakepriceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WemakepriceApplication.class, args);
	}
}

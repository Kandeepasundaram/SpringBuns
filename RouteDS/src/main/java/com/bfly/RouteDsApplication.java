package com.bfly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class RouteDsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RouteDsApplication.class, args);
	}
}

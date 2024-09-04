package com.example.qkare.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class PostgreSqlFirstProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostgreSqlFirstProjectApplication.class, args);
	}

}
